package com.atguigu.syt.user.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -20:14
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "wx.open")
@Data
public class WxProperties {
    private String appId;
    private String appSecret;
    private String redirectUri;
    private String sytBaseUrl;
}
