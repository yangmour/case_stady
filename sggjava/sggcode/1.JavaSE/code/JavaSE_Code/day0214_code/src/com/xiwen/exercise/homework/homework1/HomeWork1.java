package com.xiwen.exercise.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:35
 * @Version: 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) {
        Person[] p = new Person[3];
        p[0] = new Man("张三", 20, "抹灰");
        p[1] = new Woman("李四", 21, "做美甲");
        p[2] = new Woman("王五", 22, "做美食");

        for (Person person : p) {
            System.out.println(person);
        }
        for (Person person : p) {
            person.eat();
        }
        for (Person person : p) {
            person.toiler();
            if (person instanceof Woman) {
                ((Woman) person).makeup();
            } else {
                ((Man) person).smoke();
            }
        }

    }
}
