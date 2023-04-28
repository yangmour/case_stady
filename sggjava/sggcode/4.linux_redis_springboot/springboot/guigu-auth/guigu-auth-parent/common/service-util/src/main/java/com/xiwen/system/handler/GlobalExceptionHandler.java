package com.xiwen.system.handler;

import com.xiwen.common.result.Result;
import com.xiwen.system.exception.GuiGuException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

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

    //1.兜底异常
    @ExceptionHandler(Exception.class)
    public Result<Object> handlerException(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    //2.处理特定异常，当有一个异常没有设置就一层一层的向上找，找最近的异常
    @ExceptionHandler(SQLException.class)
    public Result<Object> handlerSQLException(Exception e) {
        e.printStackTrace();
        return Result.fail().message("sql异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    public Result<Object> handlerArithmeticException(Exception e) {
        e.printStackTrace();
        return Result.fail().message("数学异常");
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<Object> handlerRuntimeException(Exception e) {
        e.printStackTrace();
        return Result.fail().message("运行时异常");
    }

    //自定义异常
    @ExceptionHandler(GuiGuException.class)
    public Result<Object> handlerGuiGuException(GuiGuException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
