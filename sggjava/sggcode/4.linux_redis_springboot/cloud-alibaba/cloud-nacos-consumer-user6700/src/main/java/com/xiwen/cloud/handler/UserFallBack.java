package com.xiwen.cloud.handler;

import com.xiwen.cloud.bean.User;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/22 -15:03
 * @Version: 1.0
 */
public class UserFallBack {
    public static User infoFallback(@PathVariable Integer id,Throwable e) {
        e.printStackTrace();
        return new User(-1, "sentinel测试降级方法", 0, "", "", 0);
    }
}
