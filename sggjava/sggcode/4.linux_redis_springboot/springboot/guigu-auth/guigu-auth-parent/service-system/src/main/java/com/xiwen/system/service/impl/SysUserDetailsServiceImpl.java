package com.xiwen.system.service.impl;

import com.xiwen.model.system.SysUser;
import com.xiwen.system.custom.CustomUser;
import com.xiwen.system.service.SysUserDetailsService;
import com.xiwen.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/08 -19:51
 * @Version: 1.0
 */
@Component
public class SysUserDetailsServiceImpl implements SysUserDetailsService, UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.loadUserByUsername(username);
        return new CustomUser(sysUser, Collections.emptyList());
    }
}
