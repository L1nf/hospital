package com.soft_engin.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.mapper.UserInfoMapper;
import com.soft_engin.hospital.pojo.LoginUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Linf
 * @date 10/16/2022 8:30 PM
 */
@Service
public class  UserDetailServiceImpl implements UserDetailsService {
    private final UserInfoMapper userInfoMapper;

    public UserDetailServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getName, username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if (Objects.isNull(userInfo)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        //TODO 查询对应的权限信息
        List<String> list = new ArrayList<>(Arrays.asList("root","admin","user"));

        return new LoginUser(userInfo,list);
    }
}
