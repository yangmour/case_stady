package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-10:39
 * @Version: 1.0
 */
public class PeopleTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("张三");
        p.setAge(21);
        p.setGender("男");
        System.out.println(p);

        Student s = new Student();
        s.setName("李四");
        s.setAge(22);
        s.setGender("女");
        s.setScore(89);
        System.out.println(s);

        Teacher t = new Teacher();
        t.setName("李四");
        t.setAge(22);
        t.setGender("女");
        t.setSalary(3000.12);
        System.out.println(t);
    }
}
