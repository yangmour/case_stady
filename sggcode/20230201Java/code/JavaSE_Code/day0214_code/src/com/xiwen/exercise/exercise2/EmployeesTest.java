package com.xiwen.exercise.exercise2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:56
 * @Version: 1.0
 */
public class EmployeesTest {
    public static void main(String[] args) {
        Employee[] e = new Employee[5];

        e[0] = new SalaryEmployee("张三", 5000, new MyDate(2000, 10, 1));
        e[1] = new SalaryEmployee("李四", 4000, new MyDate(2002, 7, 2));
        e[2] = new HourEmployee("王五", 3, 200);
        e[3] = new HourEmployee("王2", 6, 200);

        e[4] = new Manager("小明", 8000, new MyDate(1990, 2, 4), 1.2);

        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入当前月份:");
        int month = scanner.nextInt();
        System.out.print("请输入当前日期:");
        int day = scanner.nextInt();
        for (int i = 0; i < e.length; i++) {
            if (e[i] instanceof SalaryEmployee || e[i] instanceof Manager) {
                if (((SalaryEmployee) e[i]).getBirthday().getMonth() == month && ((SalaryEmployee) e[i]).getBirthday().getDay() == day) {
                    System.out.println(e[i].getName() + "请去领生日礼物");
                }

            }
        }

    }
}
