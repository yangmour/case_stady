package com.xiwen.homework.homework13_1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-18:28
 * @Version: 1.0
 */
public class Programmer extends Employee {

    public Programmer() {
    }

    public Programmer(Integer id, String name, Integer age, Double salary) {
        super(id, name, age, salary);
    }

    @Override
    public String toString() {
        return super.getBasicInfo() + ",职业:程序员";
    }
}
