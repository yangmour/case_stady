package com.atguigu.syt.yun.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/18 -15:39
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
@Data
public class SmsProperties {
    private String host;
    private String path;
    private String method;
    private String appcode;
}
