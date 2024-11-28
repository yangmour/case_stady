package com.example.demo.demos.web.r;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * 通用数据响应对象
 */
@Data
@Builder
@Accessors(chain = true)
public class R<T> {

    private int code;
    private String msg;
    private T data;


    private R() {
        this(200, null);
    }

    private R(T data) {
        this(200, data);
    }

    private R(int code) {
        this(code, null);
    }

    private R(int code, T data) {
        this(code, null, data);
    }

    private R(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <T> R<T> ok(T data) {
        return new R<T>(data);
    }

}
