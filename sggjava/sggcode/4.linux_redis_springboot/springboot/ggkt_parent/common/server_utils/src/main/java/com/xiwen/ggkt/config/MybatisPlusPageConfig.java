package com.xiwen.ggkt.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/03 -08:33
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusPageConfig {
    /**
     * 调用MybatisPlusInterceptor
     * mybatis-plus中的分页查询功能，需要 PaginationInnerInterceptor 分页插件的支持，否则功能不生效
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //向Mybatis过滤器链中添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
