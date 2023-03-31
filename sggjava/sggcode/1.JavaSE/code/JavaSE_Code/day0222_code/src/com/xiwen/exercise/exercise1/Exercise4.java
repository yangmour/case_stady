package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-11:22
 * @Version: 1.0
 */
public class Exercise4 {
    public static void main(String[] args) {
        //（1）声明一个Person<T>类，包含姓名和伴侣属性，其中姓名是String类型，而伴侣的类型不确定，用T表示，
        //因为伴侣可以是Person，可以是Animal（例如：金刚），可以是Ghost鬼（例如：倩女幽魂），
        //可以是Demon妖（例如：白娘子），可以是Robot机器人（例如：剪刀手爱德华）。。。。
        //
        //Person<T>类属性私有化，提供有参构造、get/set方法、重写toString方法。
        //
        //（2）声明Demon妖类，包含姓名属性，属性私有化，提供有参构造、get/set方法、重写toString方法。


        //（3）在测试类中，
        //
        //- 创建1个Person对象“你自己”，伴侣为另一个Person对象"你对象"，打印显示信息；
        //- 创建1个Person对象“许仙”，他伴侣为Demon对象"白娘子"，打印显示信息；
        //方式1
        Person<Person> my = new Person<>("张三", new Person<>("小王"));
        my.getPartner().setPartner(my);
        //方式2
//        Person<Person> my2 = new Person<>("张三");
//        Person<Person> she2 = new Person<>("小王");
//        my.setPartner(she2);
//        she2.setPartner(my2);

        System.out.println(my);
        Person<Demon> xuxian = new Person<>("许仙", new Demon("白娘子", "妖"));
        System.out.println(xuxian);


    }
}

//（1）声明一个Person<T>类，包含姓名和伴侣属性，其中姓名是String类型，而伴侣的类型不确定，用T表示，
//因为伴侣可以是Person，可以是Animal（例如：金刚），可以是Ghost鬼（例如：倩女幽魂），
//可以是Demon妖（例如：白娘子），可以是Robot机器人（例如：剪刀手爱德华）。。。。
//
//Person<T>类属性私有化，提供有参构造、get/set方法、重写toString方法。
class Person<T> {
    private String name;
    private T partner;

    public Person(String name, T partner) {
        this.name = name;
        this.partner = partner;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPartner() {
        return partner;
    }

    public void setPartner(T partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        if (partner instanceof Person) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", partner=" + ((Person) partner).name +
                    '}';
        }
        return "Person{" +
                "name='" + name + '\'' +
                ", partner=" + partner +
                '}';
    }
}

//（2）声明Demon妖类，包含姓名属性，属性私有化，提供有参构造、get/set方法、重写toString方法。
class Demon {
    private String name;
    private String attributes;

    public Demon(String name, String attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public Demon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Demon{" +
                "name='" + name + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}