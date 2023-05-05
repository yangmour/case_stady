package com.xiwen.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.model.system.SysUser;
import com.xiwen.system.mapper.SysUserMapper;
import com.xiwen.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:49
 * @Version: 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
