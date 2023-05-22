package com.xiwen.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiwen.cloud.bean.User;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/22 -14:28
 * @Version: 1.0
 */

public class UserBlockHandler {
    // 方法必须是静态的
    public static User info2(@PathVariable Integer id, BlockException ex) {
        ex.printStackTrace();
        return new User(-1, "sentinel测试备用方法", 0, "", "", 0);
    }

    public static String writeBlockHandler(BlockException ex) {
        ex.printStackTrace();
        return "writeBlockHandlerException";
    }

    public static String readBlockHandler(BlockException ex) {
        ex.printStackTrace();
        return "readBlockHandlerException";
    }


    public static String commonBlockHandler(BlockException ex) {
        ex.printStackTrace();
        return "commonBlockHandlerException";
    }
}
