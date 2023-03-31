package com.xiwen.homework.homework1.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-18:38
 * @Version: 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("选择（1、录入:0、退出）");
            System.out.print("请选择:");
            if (scanner.nextInt() == 0) {
                break;
            }
            System.out.print("姓名:");
            String name = scanner.next();
            System.out.print("年龄:");
            int age = scanner.nextInt();
            Student student = new Student(name, age);

            students.add(student);

        }
        for (Student student1 : students) {
            System.out.println(student1);
        }


    }
}
