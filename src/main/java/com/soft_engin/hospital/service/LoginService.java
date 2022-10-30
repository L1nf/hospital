package com.soft_engin.hospital.service;

import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.pojo.ResponseResult;
import org.apache.ibatis.jdbc.Null;

import java.util.Map;

/**
 * @author Linf
 * @date 10/17/2022 3:15 PM
 */
public interface LoginService {
    /**
     * 登录校验
     *
     * @param userInfo 登录时获取到的用户名、密码
     */
    ResponseResult<Map<String, String>> login(UserInfo userInfo);

    /**
     * 退出登录
     */
    ResponseResult<Null> logout();
}