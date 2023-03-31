package com.xiwen.homework.homework11;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:24
 * @Version: 1.0
 */
public abstract class MyServlet {
    public abstract void service(HashMap<String, String> map) throws Exception;
}
