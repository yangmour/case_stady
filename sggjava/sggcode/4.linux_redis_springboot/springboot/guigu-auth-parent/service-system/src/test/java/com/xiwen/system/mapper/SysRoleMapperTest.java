package com.xiwen.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiwen.model.base.BaseEntity;
import com.xiwen.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -16:57
 * @Version: 1.0
 */
@SpringBootTest
class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Test
    public void testQuery1() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("role_name", "管理员");
        queryWrapper.le("id", 8);
        queryWrapper.or().eq("id", 9); //或者
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        sysRoles.stream().forEach(System.out::println);
    }

    @Test
    public void testQuery2() {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(BaseEntity::getId, "管理员");
        queryWrapper.le(SysRole::getId, 8);
        queryWrapper.or().eq(SysRole::getId, 9); //或者
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        sysRoles.stream().forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.stream().forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("动物管理员");
        sysRole.setRoleCode("animal");
        sysRole.setDescription("铲屎官");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testDelete() {
        //逻辑删除因为实体类中使用了逻辑删除注解
        int delete = sysRoleMapper.deleteById(9);
        System.out.println("delete = " + delete);
    }

    @Test
    public void testUpdate() {
        //
        SysRole sysRole = new SysRole();
        sysRole.setId(9L);
        sysRole.setRoleName("动物管理员2");
        sysRole.setRoleCode("anima2l");
        sysRole.setDescription("铲屎官2");
        int update = sysRoleMapper.updateById(sysRole);
        System.out.println("update = " + update);


        //不管用,需要自己手动set更新时间
//        SysRole sysRole = sysRoleMapper.selectById(9L);
//        sysRole.setRoleName("动物管理员3");
//        int update = sysRoleMapper.updateById(sysRole);
//        System.out.println("update = " + update);
    }

}