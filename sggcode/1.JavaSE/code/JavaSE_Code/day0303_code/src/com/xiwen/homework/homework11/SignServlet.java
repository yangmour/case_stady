package com.xiwen.homework.homework11;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:38
 * @Version: 1.0
 */
@PathAnnotation("/sign")
public class SignServlet extends MyServlet {
    @Override
    public void service(HashMap<String, String> map) throws Exception {
        Set<Map.Entry<String, String>> entries = map.entrySet();

        String username = "";
        String password = "";
        for (Map.Entry<String, String> entry : entries) {
            if ("username".equals(entry.getKey())) {
                username = entry.getKey();
            } else if ("password".equals(entry.getValue())) {
                password = entry.getValue();
            }
        }

        InputStream is = ClassLoader.getSystemResourceAsStream("users.properties");
        Properties properties = new Properties();
        properties.load(is);

        String value = properties.getProperty(username);
        if (value != null) {
            System.out.println("注册失败！");
        } else {
            System.out.println("注册成功！");
            FileWriter fileWriter = new FileWriter("day0303_code/src/users.properties", true);
            fileWriter.write("\r\n" + username + ":" + password);
            fileWriter.close();
        }

    }
}
