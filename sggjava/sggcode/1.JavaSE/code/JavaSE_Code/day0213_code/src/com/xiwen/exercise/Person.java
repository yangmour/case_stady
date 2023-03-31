package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-10:31
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "姓名：" + name +
                        ", 年龄：" + age +
                        ", 性别：" + gender;
    }
}
