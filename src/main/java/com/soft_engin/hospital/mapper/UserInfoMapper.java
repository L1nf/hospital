package com.soft_engin.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft_engin.hospital.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Linf
 * @description 针对表【user_info(员工信息表)】的数据库操作Mapper
 * @createDate 2022-10-17 13:47:51
 * @Entity com.soft_engin.hospital.entity.UserInfo
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




