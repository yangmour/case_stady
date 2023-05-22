package com.xiwen.cloud.origin;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/22 -20:32
 * @Version: 1.0
 */
@Component
public class RequestHeadOrigin implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String k1 = httpServletRequest.getHeader("k1");
        if (StringUtils.isEmpty(k1)) {
            return "blank";
        }
        return k1;
    }
}
