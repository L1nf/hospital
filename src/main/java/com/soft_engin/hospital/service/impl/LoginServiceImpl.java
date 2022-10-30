package com.soft_engin.hospital.service.impl;

import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.pojo.LoginUser;
import com.soft_engin.hospital.pojo.ResponseResult;
import com.soft_engin.hospital.service.LoginService;
import com.soft_engin.hospital.utils.JwtUtil;
import com.soft_engin.hospital.utils.RedisCache;
import org.apache.ibatis.jdbc.Null;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Linf
 * @date 10/17/2022 3:15 PM
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final RedisCache redisCache;

    public LoginServiceImpl(AuthenticationManager authenticationManager, RedisCache redisCache) {
        this.authenticationManager = authenticationManager;
        this.redisCache = redisCache;
    }

    @Override
    public ResponseResult<Map<String, String>> login(@NotNull UserInfo userInfo) {
        // 登录认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userInfo.getName(), userInfo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败");
        }
        // 返回jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUserInfo().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>(2);
        map.put("token", jwt);
        // 把用户信息存入redis,userId作为key
        redisCache.setCacheObject("login:" + userId, loginUser);
        return new ResponseResult<>(200, "登陆成功", map);
    }

    @Override
    public ResponseResult<Null> logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        long userId = loginUser.getUserInfo().getUserId();

        redisCache.deleteObject("login:" + userId);
        return new ResponseResult<>(200, "退出成功", null);
    }
}