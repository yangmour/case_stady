package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:35
 * @Version: 1.0
 */
public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person("张三", 20, "女");
        Student student = new Student("李四", 19, "男", 90);
        Teacher teacher = new Teacher("李四", 19, "男", 9000);

        System.out.println(person);
        System.out.println(student);
        System.out.println(teacher);

    }
}
