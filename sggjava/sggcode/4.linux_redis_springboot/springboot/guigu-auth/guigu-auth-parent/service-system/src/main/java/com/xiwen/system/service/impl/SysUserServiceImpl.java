package com.xiwen.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwen.common.helper.MenuHelper;
import com.xiwen.common.helper.RouterHelper;
import com.xiwen.common.result.ResultCodeEnum;
import com.xiwen.common.util.MD5;
import com.xiwen.model.system.SysMenu;
import com.xiwen.model.system.SysUser;
import com.xiwen.model.vo.LoginVo;
import com.xiwen.model.vo.RouterVo;
import com.xiwen.system.exception.GuiGuException;
import com.xiwen.system.mapper.SysMenuMapper;
import com.xiwen.system.mapper.SysUserMapper;
import com.xiwen.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:49
 * @Version: 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public boolean updateStatus(Long uid, Integer status) {
        if (status == 0 || status == 1) {
            SysUser sysUser = new SysUser();
            sysUser.setId(uid);
            sysUser.setStatus(status);
            baseMapper.updateById(sysUser);
            return true;
        }
        return false;
    }

    @Override
    public HashMap<String, Object> login(LoginVo loginVo) {

        if (loginVo == null) {
            throw new GuiGuException(ResultCodeEnum.DATA_ERROR);
        }
        if (StringUtils.isEmpty(loginVo.getUsername()) || StringUtils.isEmpty(loginVo.getPassword())) {
            throw new GuiGuException(ResultCodeEnum.ILLEGAL_REQUEST);
        }
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("username", loginVo.getUsername());
        SysUser sysUser = baseMapper.selectOne(sysUserQueryWrapper);

        if (!sysUser.getPassword().equals(MD5.encrypt(loginVo.getPassword()))) {
            throw new GuiGuException(ResultCodeEnum.PASSWORD_ERROR);
        }
        if (sysUser.getStatus() == 0) {
            throw new GuiGuException(ResultCodeEnum.ACCOUNT_STOP);
        }

        String uuidToken = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.boundValueOps(uuidToken).set(sysUser, 2, TimeUnit.HOURS);

        HashMap<String, Object> map = new HashMap<>();
        map.put("token", uuidToken);
        return map;
    }

    @Override
    public HashMap<String, Object> getUserMenuByToken(String token) {
        //redis中拿到对象
        SysUser sysUser = (SysUser) redisTemplate.boundValueOps(token).get();
        if (sysUser == null) {
            throw new GuiGuException(ResultCodeEnum.ILLEGAL_REQUEST);
        }

        // 查询用户的菜单项
        List<SysMenu> sysMenus = getSysMenus(sysUser);

        //构建成菜单树
        List<SysMenu> sysMenuTree = MenuHelper.buildTree(sysMenus);
        //构建成动态路由的菜单树
        List<RouterVo> buildRouters = RouterHelper.buildRouters(sysMenuTree);

        // 获取button按钮
        List<String> buttons = getButtons(sysMenus);

        HashMap<String, Object> map = new HashMap<>();

        ArrayList<String> roles = new ArrayList<>();
        map.put("roles", roles);
        map.put("introduction", sysUser.getDescription());
        map.put("name", sysUser.getName());
        map.put("avatar", sysUser.getHeadUrl());
        map.put("routers", buildRouters);
        map.put("buttons", buttons);

        return map;
    }

    private static List<String> getButtons(List<SysMenu> sysMenus) {
        List<String> buttons = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getType() == 2)
                buttons.add(sysMenu.getPerms());
        }
        return buttons;
    }

    private List<SysMenu> getSysMenus(SysUser sysUser) {
        // 如果是admin用户就直接查询
        List<SysMenu> sysMenus = null;
        if (sysUser.getId() == 1L) {
            QueryWrapper<SysMenu> sysMenuQueryWrapper = new QueryWrapper<>();
            sysMenuQueryWrapper.eq("status", 1);
            sysMenuQueryWrapper.orderByAsc("sort_value");
            sysMenus = sysMenuMapper.selectList(sysMenuQueryWrapper);

        } else { //其他用户 查询权限
            //根据用户id获取到菜单管理
            sysMenus = baseMapper.getRolesByUid(sysUser.getId());
        }
        return sysMenus;
    }

    @Override
    public SysUser loadUserByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
    }
}
