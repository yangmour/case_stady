package com.xiwen.exercise.homework.homework2;


/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:53
 * @Version: 1.0
 */
public class HomeWork2 {
    public static void main(String[] args) {

        Employee[] arr = new Employee[3];
        arr[0] = new Programmer(1, "张三", 10, 5000, "程序员");
        arr[1] = new Designer(2, "李四", 30, 7000, "设计师", 1000);
        arr[2] = new Architect(3, "王五", 20, 9000, "架构师", 1000, 1.2);

        System.out.println("----------------员工信息管理-------------------");
        System.out.println("编号\t姓名\t年龄\t工资\t\t职位\t奖金\t股票");
        for (int i = 0; i < arr.length; i++) {
            arr[i].setId(i + 1);
            System.out.println(arr[i]);
        }
        System.out.println("----------------------------------------------");

    }
}
