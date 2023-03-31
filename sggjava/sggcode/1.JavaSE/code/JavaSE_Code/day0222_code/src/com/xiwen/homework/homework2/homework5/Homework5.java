package com.xiwen.homework.homework2.homework5;

import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:32
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("liusan", 20, 90.0);
        students[1] = new Student("lisi", 22, 90.0);
        students[2] = new Student("wangwu", 20, 99.0);
        students[3] = new Student("sunliu", 22, 100.0);

        System.out.println("按照成绩和年龄排序：");
        MyArrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }


        System.out.println("按照姓名排序：");
        MyArrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
