package com.xiwen.system.handler;

import com.xiwen.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -19:03
 * @Version: 1.0
 */
// 处理全局异常类
@RestControllerAdvice // 等于@ResponseBody + @ControllerAdvice注解组合
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Object> error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

}
