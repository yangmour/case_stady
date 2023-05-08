package com.xiwen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwen.model.system.SysUser;
import com.xiwen.model.vo.LoginVo;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:48
 * @Version: 1.0
 */
public interface SysUserService extends IService<SysUser> {
    boolean updateStatus(Long uid, Integer status);

    HashMap<String, Object> login(LoginVo loginVo);

    HashMap<String, Object> getUserMenuByToken(String token);

    SysUser loadUserByUsername(String username);
}
