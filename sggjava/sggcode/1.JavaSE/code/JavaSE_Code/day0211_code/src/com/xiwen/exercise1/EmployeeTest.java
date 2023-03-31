package com.xiwen.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-11:28
 * @Version: 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        MyDate myDate1 = new MyDate();
        MyDate myDate2 = new MyDate();
        myDate1.year = 2001;
        myDate1.month = 8;
        myDate1.day = 20;

        myDate2.year = 2002;
        myDate2.month = 2;
        myDate2.day = 10;

        employee1.name = "张三";
        employee1.birthday = myDate1;
        employee2.name = "李四";
        employee2.birthday = myDate2;

        System.out.println(employee1);
        System.out.println(employee2);


    }
}
