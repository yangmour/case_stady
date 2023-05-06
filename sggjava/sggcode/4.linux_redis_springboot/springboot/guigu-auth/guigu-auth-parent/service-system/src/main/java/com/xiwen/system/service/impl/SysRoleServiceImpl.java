package com.xiwen.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.model.system.SysRole;
import com.xiwen.model.system.SysUserRole;
import com.xiwen.model.vo.AssignRoleVo;
import com.xiwen.model.vo.SysRoleQueryVo;
import com.xiwen.system.mapper.SysRoleMapper;
import com.xiwen.system.mapper.SysUserRoleMapper;
import com.xiwen.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:49
 * @Version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Page<SysRole> selectPage(Page<SysRole> page, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(page, sysRoleQueryVo);
    }

    @Override
    public Map<String, Object> getUserRole(String userId) {
        Map<String, Object> map = new HashMap<>();

        List<SysRole> sysRoles = baseMapper.selectList(null);

        LambdaQueryWrapper<SysUserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);

        List<Long> userRoleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());

        map.put("allRoles", sysRoles);
        map.put("userRoleIds", userRoleIds);
        return map;
    }

    @Override
    public void doAssign(AssignRoleVo assignRoleVo) {
        //先删除用户和角色表中数据
        LambdaQueryWrapper<SysUserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRole::getUserId,assignRoleVo.getUserId());
        sysUserRoleMapper.delete(queryWrapper);
        //增加用户和角色表中数据

        List<Long> roleIdList = assignRoleVo.getRoleIdList();
        for (Long roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assignRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        }


    }
}
