package com.soft_engin.hospital.controller;

import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.pojo.ResponseResult;
import com.soft_engin.hospital.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Linf
 * @date 9/27/2022 10:40 PM
 */
@Api(tags = "User")
@RequestMapping("/user")
@RestController
public class UserController {
     private final LoginService loginService;

     public UserController(LoginService loginService) {
          this.loginService = loginService;
     }

     @ApiOperation("login")
     @PostMapping("/login")
     public ResponseResult<Map<String, String>> login(@RequestBody UserInfo userInfo) {
          return loginService.login(userInfo);
     }

     @ApiOperation("logout")
     @PostMapping("/logout")
     public ResponseResult<Null> logout() {
          return loginService.logout();
     }

     // TODO: 在此续写权限管理，需要先登录，才有权限修改个人信息
     @ApiOperation("edit_user_info")
     @PutMapping("/edit")
     @PreAuthorize("hasAuthority('se:root:edit_user')")
     public boolean editUserInfo() {
          return true;
     }
}
