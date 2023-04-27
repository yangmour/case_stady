package com.xiwen.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwen.model.system.SysRole;
import com.xiwen.model.vo.SysRoleQueryVo;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:48
 * @Version: 1.0
 */
public interface SysRoleService extends IService<SysRole> {
    Page<SysRole> selectPage(Page<SysRole> page, SysRoleQueryVo sysRoleQueryVo);
}
