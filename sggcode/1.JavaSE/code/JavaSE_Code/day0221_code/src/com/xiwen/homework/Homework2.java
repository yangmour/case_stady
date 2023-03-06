package com.xiwen.homework;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-18:08
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) {
        Collection students = new ArrayList();
        students.add(new Student(2, "张三", 10));
        students.add(new Student(3, "李四", 30));
        students.add(new Student(3, "李四", 20));
        students.add(new Student(1, "王五", 20));

        for (Object student : students) {
            System.out.println(student);
        }
        students.removeIf(o -> {
            Student o1 = (Student) o;
            String o1Name = o1.getName();
            int o1Id = o1.getId();
            int o1Age = o1.getAge();

            Student my = new Student(1, "王五", 20);
            int myId = my.getId();
            String myName = my.getName();
            int myAge = my.getAge();
            if (o1Name.equals(myName) && o1Id == myId && myAge == o1Age) {
                return true;
            }
            return false;
        });

        System.out.println("删除自己");
        for (Object student : students) {
            System.out.println(student);
        }


        students.removeIf(o -> {
            Student o1 = (Student) o;
            int o1Age = o1.getAge();

            Student my = new Student(1, "王五", 20);
            int myAge = my.getAge();
            if (myAge == o1Age) {
                return true;
            }
            return false;
        });

        System.out.println("删除年龄一样的");
        for (Object student : students) {
            System.out.println(student);
        }

        students.removeIf(o -> {
            Student o1 = (Student) o;
            Student my = new Student(1, "张三", 20);
            String name = my.getName();
            if (name.equals(o1.getName())) {
                return true;
            }
            return false;
        });

        System.out.println("删除年龄一样的");
        for (Object student : students) {
            System.out.println(student);
        }


    }
}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
