package com.xiwen.homework.homework11;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:21
 * @Version: 1.0
 */
public class Homework11 {
    public static void main(String[] args) throws Exception {

        HashMap<String, Class> pathsMap = new HashMap<>();

        InputStream is = ClassLoader.getSystemResourceAsStream("servlet.properties");
        Properties properties = new Properties();
        properties.load(is);

        String servletClass = properties.getProperty("servletClass");
        String[] classNames = servletClass.split(",");

        for (String className : classNames) {
            Class<?> clazz = Class.forName(className);
            PathAnnotation annotation = clazz.getAnnotation(PathAnnotation.class);
            pathsMap.put(annotation.value(), clazz);
        }

        HashMap<String, String> user = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        user.put(username, password);

        System.out.print("请输入路径名:");
        String path = scanner.next();
        Class clazzName = pathsMap.get(path);
        if (clazzName != null) {
            Class<?> obj = Class.forName(clazzName.getName());
            MyServlet newInstance = (MyServlet) obj.newInstance();
            newInstance.service(user);
        } else {
            System.out.println("输入错误！");
        }

        scanner.close();


    }
}
