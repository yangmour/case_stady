package com.xiwen.system.exception;

import com.xiwen.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/28 -09:37
 * @Version: 1.0
 */
@Data
public class GuiGuException extends RuntimeException {

    private Integer code;
    private String msg;

    public GuiGuException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GuiGuException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }
}
