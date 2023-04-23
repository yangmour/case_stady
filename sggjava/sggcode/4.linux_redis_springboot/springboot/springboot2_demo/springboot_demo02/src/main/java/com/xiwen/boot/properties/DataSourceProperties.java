package com.xiwen.boot.properties;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/23 -23:10
 * @Version: 1.0
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 将properties|yml文件中的键值对绑定到Properties类对应的属性上：三种方式：
 *   方式1：Properties类上加@Component 、同时在Properties类属性上加@Value
 *   方式2: Properties类上加@Component 及 @ConfigurationProperties（prefix=""）:批量给属性赋值的方式
 *   方式3：Properties类上加@ConfigurationProperties（prefix=""）,同时在主启动类上加@EnableConfigurationProperties（value=DataSourceProperties.class）
 *
 */


/**
 * 方式3
 */
@ConfigurationProperties(prefix = "spring.xxxx.jdbc.datasource")
public class DataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

/**
 * 方式2
 */

/*@Component
@ConfigurationProperties(prefix = "spring.xxxx.jdbc.datasource")
public class DataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}*/

/**
 * 方式1
 */
/*@Component
public class DataSourceProperties {

    @Value("${spring.xxxx.jdbc.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.xxxx.jdbc.datasource.url}")
    private String url;
    @Value("${spring.xxxx.jdbc.datasource.username}")
    private String username;
    @Value("${spring.xxxx.jdbc.datasource.password}")
    private String password;

    @Override
    public String toString() {
        return "DataSourceProperties{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}*/
