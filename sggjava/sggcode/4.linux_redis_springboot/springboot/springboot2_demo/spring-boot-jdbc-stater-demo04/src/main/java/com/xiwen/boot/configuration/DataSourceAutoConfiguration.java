package com.xiwen.boot.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiwen.boot.properties.DataSourceProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/25 -15:22
 * @Version: 1.0
 */
@SpringBootConfiguration
@EnableConfigurationProperties(value = DataSourceProperties.class)
public class DataSourceAutoConfiguration {
    private DataSourceProperties dataSourceProperties;

    public DataSourceAutoConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    @ConditionalOnProperty(value = "spring.aaa.jdbc.datasource.type",havingValue = "druid")
    public DataSource getDruidDataSource() {
        DruidDataSource dataSourceFactory = new DruidDataSource();
        dataSourceFactory.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSourceFactory.setUrl(dataSourceProperties.getUrl());
        dataSourceFactory.setUsername(dataSourceProperties.getUsername());
        dataSourceFactory.setPassword(dataSourceProperties.getPassword());
        return dataSourceFactory;
    }

    @Bean
    @ConditionalOnProperty(value = "spring.aaa.jdbc.datasource.type",havingValue = "c3p0")
    public DataSource getC3p0DataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(dataSourceProperties.getDriverClassName());
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setUser(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;

    }
}
