package com.xiwen.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.common.helper.MenuHelper;
import com.xiwen.model.system.SysMenu;
import com.xiwen.model.system.SysRoleMenu;
import com.xiwen.model.vo.AssignMenuVo;
import com.xiwen.system.mapper.SysMenuMapper;
import com.xiwen.system.mapper.SysRoleMenuMapper;
import com.xiwen.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/07 -16:32
 * @Version: 1.0
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findMenuNodes() {
        // 查询所有的
        List<SysMenu> sysMenuList = baseMapper.selectList(null);
        //构建成树返回
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void saveMenu(SysMenu sysMenu) {
        baseMapper.insert(sysMenu);
    }

    @Override
    public SysMenu getByIdMenu(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void updateMenu(SysMenu sysMenu) {
        sysMenu.setUpdateTime(null);
        baseMapper.updateById(sysMenu);
    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);
    }


    @Override
    public List<SysMenu> getRoleMenuList(Long id) {
        //全部的
        QueryWrapper<SysMenu> sysMenuQueryWrapper = new QueryWrapper<>();
        sysMenuQueryWrapper.eq("status", 1);
        List<SysMenu> sysMenuList = baseMapper.selectList(sysMenuQueryWrapper);
        //用户已有的权限
        LambdaQueryWrapper<SysRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleMenu::getRoleId, id);
        List<SysRoleMenu> roleSelectedMenu = sysRoleMenuMapper.selectList(lambdaQueryWrapper);

        List<Long> checkedIds = new ArrayList<>();
        roleSelectedMenu.forEach(item -> checkedIds.add(item.getMenuId()));

        // 将角色已选择中的做标记
        sysMenuList.forEach(item -> {
            if (checkedIds.contains(item.getId())) {
                item.setSelect(true);
            }
        });

//        for (SysMenu sysMenu : sysMenuList) {
//            if (checkedIds.contains(sysMenu.getId())) {
//                sysMenu.setSelect(true);
//            }
//        }

        // 将菜单树化
        return MenuHelper.buildTree(sysMenuList);
    }


    @Override
    public void assignMenu(AssignMenuVo assignMenuVo) {

        // 先删后加
        QueryWrapper<SysRoleMenu> sysRoleMenuQueryWrapper = new QueryWrapper<>();
        sysRoleMenuQueryWrapper.eq("role_id", assignMenuVo.getRoleId());
        sysRoleMenuMapper.delete(sysRoleMenuQueryWrapper);

        List<Long> menuIdList = assignMenuVo.getMenuIdList();
        menuIdList.forEach(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu(assignMenuVo.getRoleId(), menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        });

//        for (Long menuId : menuIdList) {
//            SysRoleMenu sysRoleMenu = new SysRoleMenu(assignMenuVo.getRoleId(), menuId);
//            sysRoleMenuMapper.insert(sysRoleMenu);
//        }
    }
}
