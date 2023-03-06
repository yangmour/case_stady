package com.xiwen.exercise.exercise7;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-22:39
 * @Version: 1.0
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
