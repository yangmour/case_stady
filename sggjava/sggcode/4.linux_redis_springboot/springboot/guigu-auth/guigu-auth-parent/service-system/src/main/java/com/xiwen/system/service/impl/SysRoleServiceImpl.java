package com.xiwen.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.model.system.SysRole;
import com.xiwen.model.vo.SysRoleQueryVo;
import com.xiwen.system.mapper.SysRoleMapper;
import com.xiwen.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:49
 * @Version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public Page<SysRole> selectPage(Page<SysRole> page, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(page, sysRoleQueryVo);
    }
}
