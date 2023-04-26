package com.xiwen.system.mapper;

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
    public void test1(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.stream().forEach(System.out::println);
    }

}