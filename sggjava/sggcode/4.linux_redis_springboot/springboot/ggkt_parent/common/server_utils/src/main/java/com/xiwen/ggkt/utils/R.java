package com.xiwen.ggkt.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/02 -19:22
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public static <T> R ok(String msg, T data) {
        return new R(200, msg, data);
    }

    public static <T> R ok(T data) {
        return ok("成功", data);
    }

    public static R ok() {
        return ok(null);
    }

    public static R fail(Integer code, String msg) {
        return new R(code, msg, null);
    }

    public static R fail(Integer code) {
        return fail(code, "失败");
    }

    public static R fail() {
        return fail(400);
    }


}
