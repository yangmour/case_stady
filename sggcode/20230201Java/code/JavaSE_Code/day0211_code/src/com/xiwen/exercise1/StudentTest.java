package com.xiwen.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-11:15
 * @Version: 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "张三";
        s1.score = 89;
        s2.name = "李四";
        s2.score = 80;

        System.out.println(s1);
        System.out.println(s2);

    }
}
