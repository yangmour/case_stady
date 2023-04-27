package com.xiwen.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiwen.model.system.SysRole;
import com.xiwen.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -16:55
 * @Version: 1.0
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    Page<SysRole> selectPage(Page<SysRole> page, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
