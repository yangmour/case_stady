package com.xiwen.boot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/23 -22:40
 * @Version: 1.0
 */
@RestController
@RequestMapping("/actor") //路径名最好和类名一样
public class ActorController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("hello")
    public String hello() {
        System.out.println(dataSource);
        System.out.println("访问了hello");
        if (dataSource instanceof DruidDataSource) {
            DruidDataSource druidDataSource = (DruidDataSource) dataSource;
            String url = druidDataSource.getUrl();
            System.out.println(url);
        } else if (dataSource instanceof ComboPooledDataSource){
            ComboPooledDataSource druidDataSource = (ComboPooledDataSource) dataSource;
            String driverClass = druidDataSource.getDriverClass();
            System.out.println(driverClass);
        }
        return "蔡徐坤";
    }
}
