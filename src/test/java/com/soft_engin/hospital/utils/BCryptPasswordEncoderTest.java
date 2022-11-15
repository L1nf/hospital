package com.soft_engin.hospital.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Linf
 * @date 10/22/2022 5:47 PM
 */
@SpringBootTest
public class BCryptPasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder() {
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
         String encode1 = passwordEncoder.encode("123456");
        //  String encode2 = passwordEncoder.encode("123456");
         System.out.println(encode1);
        //  System.out.println(encode2);
        System.out.println(passwordEncoder.matches("123456", "$2a$10$lYBUnU4qE4H60P98FkiiE.S0MasJTrAk2TKNixdBVsHTPTCthLnjG"));
        // passwordEncoder.matches("1234", "$2a$10$vqKkX87vdT/0uHUPwe14NutyAAxPJQaIpEYdQJS4hVO4aDNgCCgr6");
    }
}
