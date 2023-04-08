package com.xiwen.aop01;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/08 -15:26
 * @Version: 1.0
 */
public interface Other {
    public void after(Object proxy, Method method, Object[] args);

    public void before(Object proxy, Method method, Object[] args, Object res);
}
