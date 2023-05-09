package com.xiwen.system.service.impl;

import com.xiwen.model.system.SysMenu;
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
import java.util.List;

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
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("账号已停用！");
        }
        List<SysMenu> sysMenus = sysUserService.getSysMenus(sysUser);
        List<String> buttons = sysUserService.getButtons(sysMenus);
        sysUser.setUserPermsList(buttons);
        return new CustomUser(sysUser, Collections.emptyList());
    }
}
