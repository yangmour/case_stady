package com.xiwen.system.bcrpt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/10 -08:42
 * @Version: 1.0
 */
@SpringBootTest
public class BCryptPasswordEncoderTest {
    @Test
    public void test() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("加密");
        String encode1 = bCryptPasswordEncoder.encode("123456");
        String encode2 = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode1);
        System.out.println(encode2);

        System.out.println("解密");
        boolean matches1 = bCryptPasswordEncoder.matches("123456", encode1);
        boolean matches2 = bCryptPasswordEncoder.matches("123456", encode2);
        //原密码 $2a$10$PDhYrkq1lNOhu.kWcjCZmObdAFasroHSLeDB63NoWtYJsMP27XLKi
        //改后 $2a$10$PDhYrkq1lNOhu.kWcjCZmObdAFasroHSLeDB63NoWtYJsMP27XLKg
        boolean matches3 = bCryptPasswordEncoder.matches("123456", "$2a$10$PDhYrkq1lNOhu.kWcjCZmObdAFasroHSLeDB63NoWtYJsMP27XLKg");
        System.out.println(matches1);
        System.out.println(matches2);
        System.out.println(matches3);

    }
}
