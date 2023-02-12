package com.xiwen.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-15:05
 * @Version: 1.0
 */
public class Employee2Test {
    public static void main(String[] args) {

        Employee2[] employee2s = new Employee2[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < employee2s.length; i++) {
            System.out.println("-------请添加第" + (i + 1) + "个员工-------");
            System.out.print("姓名:");
            String name = scanner.next();
            System.out.print("性别:");
            String sex = scanner.next();
            System.out.print("年龄:");
            int age = scanner.nextInt();
            System.out.print("工资:");
            double salary = scanner.nextDouble();
            System.out.print("手机号:");
            String phone = scanner.next();
            System.out.print("邮箱:");
            String email = scanner.next();

            Employee2 employee = new Employee2(name, sex, age, salary, phone, email);
            employee2s[i] = employee;
        }

        System.out.println("-------------添加完成-----------------");
        System.out.println("-------------员工列表-----------------");
        System.out.println("编号\t姓名\t性别\t年龄\t工资\t\t电话\t\t邮箱");
        for (int i = 0; i < employee2s.length; i++) {
            System.out.println(employee2s[i]);
        }
        System.out.println("-------------员工列表完成-----------------");
        scanner.close();


    }
}
