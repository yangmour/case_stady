package com.xiwen.homework.homework3.question8;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:52
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int lifeValue;

    public Person() {
    }

    public Person(String name, int lifeValue) {
        this.name = name;
        setLifeValue(lifeValue);
    }

    public void setPerson(String name, int lifeValue) {
        this.name = name;
        this.lifeValue = lifeValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if (lifeValue <= 0) {
            throw new NoLifeValueException("生命值不能为负数");
        }
        this.lifeValue = lifeValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }
}


class PersonTest {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("张三", -5);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(person);

        try {
            person = new Person();
            person.setName("王五");
            person.setLifeValue(20);
            person.setLifeValue(-10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(person);
    }
}