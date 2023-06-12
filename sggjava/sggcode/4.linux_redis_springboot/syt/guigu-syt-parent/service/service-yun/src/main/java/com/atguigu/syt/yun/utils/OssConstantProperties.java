package com.atguigu.syt.yun.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:13
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssConstantProperties {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
}
