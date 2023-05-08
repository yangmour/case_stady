package com.xiwen.system.custom;

import com.xiwen.common.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/08 -19:59
 * @Version: 1.0
 */
@Component
public class CustomMd5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5.encrypt(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encrypt = MD5.encrypt(rawPassword.toString());
        return encodedPassword.equals(encrypt);
    }
}
