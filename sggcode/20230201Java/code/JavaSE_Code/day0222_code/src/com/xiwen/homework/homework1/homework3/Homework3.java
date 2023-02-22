package com.xiwen.homework.homework1.homework3;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-18:50
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 98));
        list.add(new Student("李四", 86));
        list.add(new Student("王五", 85));
        list.add(new Student("赵六", 98));
        list.add(new Student("钱七", 98));

        System.out.println(list);

        System.out.println("找出最高分:");
        int max = -1;
        for (Student student : list) {
            if (student.getScore() > max) {
                max = student.getScore();
            }
        }
        System.out.println(max);

        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (max == student.getScore()) {
                students.add(student);
            }
        }
        System.out.println(students);

    }

}
