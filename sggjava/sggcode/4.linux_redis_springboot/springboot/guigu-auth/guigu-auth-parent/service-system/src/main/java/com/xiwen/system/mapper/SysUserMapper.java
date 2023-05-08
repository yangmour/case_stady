package com.xiwen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwen.model.system.SysMenu;
import com.xiwen.model.system.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -16:55
 * @Version: 1.0
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysMenu> getRolesByUid(Long id);
}
