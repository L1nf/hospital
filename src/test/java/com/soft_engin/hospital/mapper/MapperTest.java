package com.soft_engin.hospital.mapper;

import com.soft_engin.hospital.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Linf
 * @date 10/16/2022 8:02 PM
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSelectPermsByUserId() {
        List<String> list = menuMapper.selectPermsByUserId(1L);
        System.out.println(list);
    }

    @Test
    public void testUserInfoMapper() {
        List<UserInfo> users = userInfoMapper.selectList(null);
        System.out.println(users);
    }
}
