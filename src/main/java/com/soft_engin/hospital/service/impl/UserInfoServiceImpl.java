package com.soft_engin.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft_engin.hospital.entity.UserInfo;
import com.soft_engin.hospital.mapper.UserInfoMapper;
import com.soft_engin.hospital.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* @author Linf
* @description 针对表【user_info(员工信息表)】的数据库操作Service实现
* @createDate 2022-10-17 13:47:51
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}




