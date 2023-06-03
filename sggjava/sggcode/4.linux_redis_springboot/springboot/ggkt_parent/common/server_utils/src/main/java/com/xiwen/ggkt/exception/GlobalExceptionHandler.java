package com.xiwen.ggkt.exception;

import com.xiwen.ggkt.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/03 -09:20
 * @Version: 1.0
 */
// 全局处理异常
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        return R.fail(400, "失败，全局处理异常！");
    }

    @ExceptionHandler(GuiGuException.class)
    public R getGuiGuException(GuiGuException e) {
        log.error(ExceptionUtils.getStackTrace(e));
        return R.fail(e.getCode(), e.getMsg() + " -> 自定义异常");
    }

}
