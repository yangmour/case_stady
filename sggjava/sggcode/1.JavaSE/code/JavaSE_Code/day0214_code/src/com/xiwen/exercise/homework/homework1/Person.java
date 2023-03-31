package com.xiwen.exercise.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:37
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person() {
    }

    public void eat() {
        System.out.println(name + "吃饭！");
    }

    public void toiler() {
        System.out.println(name + "上洗手间！");
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "姓名=" + name +
                ", 年龄=" + age +
                ", 职业='" + occupation;
    }
}
