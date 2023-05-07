package com.xiwen.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwen.model.system.SysMenu;
import com.xiwen.model.vo.AssignMenuVo;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/07 -16:32
 * @Version: 1.0
 */
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> findMenuNodes();

    void saveMenu(SysMenu sysMenu);

    SysMenu getByIdMenu(Long id);

    void updateMenu(SysMenu sysMenu);

    void deleteById(Long id);

    List<SysMenu> getRoleMenuList(Long id);

    void assignMenu(AssignMenuVo assignMenuVo);
}
