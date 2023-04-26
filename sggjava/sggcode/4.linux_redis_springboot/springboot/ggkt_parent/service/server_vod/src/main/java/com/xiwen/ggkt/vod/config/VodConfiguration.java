package com.xiwen.ggkt.vod.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -23:21
 * @Version: 1.0
 */
@SpringBootConfiguration
@MapperScan("com.xiwen.ggkt.vod.mapper")
public class VodConfiguration {
}
