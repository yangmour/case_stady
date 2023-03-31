package com.xiwen.homework.homework11;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:24
 * @Version: 1.0
 */
@PathAnnotation("/login")
public class LoginServlet extends MyServlet {
    @Override
    public void service(HashMap<String, String> map) throws Exception {
        Set<Map.Entry<String, String>> entries = map.entrySet();

        InputStream is = ClassLoader.getSystemResourceAsStream("users.properties");
        Properties properties = new Properties();
        properties.load(is);


        boolean flag = true;
        for (Map.Entry<String, String> entry : entries) {
            String user = entry.getKey();
            System.out.println(user);
            String value = properties.getProperty(user);
            if (value != null && entry.getValue().equals(value)) {
                System.out.println("登陆成功！");
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println("登陆失败！");

        }


    }
}
