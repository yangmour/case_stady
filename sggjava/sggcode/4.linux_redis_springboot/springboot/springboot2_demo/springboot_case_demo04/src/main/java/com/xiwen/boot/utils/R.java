package com.xiwen.boot.utils;

import lombok.Data;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/26 -09:47
 * @Version: 1.0
 */
@Data
public class R {

    private boolean status;
    private String msg;
    private Object data;

    private R() {
    }

    public static R ok() {
        return ok(null);
    }

    public static R ok(String msg) {
        return ok(msg, null);
    }

    public static R ok(String msg, Object data) {
        R r = new R();
        r.status = true;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static R error() {
        return error(null);
    }

    public static R error(String msg) {
        return error(msg, null);
    }

    public static R error(String msg, Object data) {
        R r = new R();
        r.msg = msg;
        r.data = data;
        return r;
    }

}
