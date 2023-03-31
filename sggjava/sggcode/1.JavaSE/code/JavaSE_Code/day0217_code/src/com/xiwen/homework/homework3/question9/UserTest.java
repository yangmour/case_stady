package com.xiwen.homework.homework3.question9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-19:17
 * @Version: 1.0
 */
public class UserTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserManger userManger = new UserManger();
        boolean flag = true;
        while (flag) {
            System.out.println("--------尚硅谷----------");
            System.out.println("\t\t1、注册");
            System.out.println("\t\t2、登陆");
            System.out.println("\t\t3、退出");
            System.out.print("请选择(输入数字):");
            int nextInt;
            try {
                nextInt = scanner.nextInt();
                if (nextInt == 1) {
                    String name = "";
                    while (true) {
                        System.out.print("请输入用户名:");
                        name = scanner.next();
                        try {
                            userManger.checkUsername(name);
                            break;
                        } catch (UserNameAlreadyExistsException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }

                    System.out.print("请输入密码:");
                    String pass = scanner.next();
                    try {
                        userManger.add(new User(name, pass));
                        System.out.println("注册成功");
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }
                } else if (nextInt == 2) {
                    System.out.print("请输入用户名:");
                    String name = scanner.next();
                    System.out.print("请输入密码:");
                    String pass = scanner.next();
                    try {
                        userManger.login(new User(name, pass));
                        System.out.println("登陆成功！");
                    } catch (LoginFailException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (nextInt == 3) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
