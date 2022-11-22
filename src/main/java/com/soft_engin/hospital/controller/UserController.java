package com.soft_engin.hospital.controller;

import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.pojo.LoginUserInfo;
import com.soft_engin.hospital.pojo.ResponseResult;
import com.soft_engin.hospital.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
     public ResponseResult<Map<String, String>> login(@RequestBody LoginUserInfo loginUserInfo) {
          UserInfo userInfo = new UserInfo();
          userInfo.setName(loginUserInfo.getName());
          userInfo.setPassword(loginUserInfo.getPassword());
          return loginService.login(userInfo);
     }

     @ApiOperation("logout")
     @PostMapping("/logout")
     @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "header")
     public ResponseResult<Null> logout() {
          return loginService.logout();
     }

     @ApiOperation("edit_user_info")
     @PutMapping("/edit/all")
     @PreAuthorize("hasAuthority('se:root:edit_user')")
     public boolean editUserInfo() {
          return true;
     }
}
