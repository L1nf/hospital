package com.soft_engin.hospital.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Linf
 * @date 11/8/2022 4:53 PM
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserInfo {
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
}
