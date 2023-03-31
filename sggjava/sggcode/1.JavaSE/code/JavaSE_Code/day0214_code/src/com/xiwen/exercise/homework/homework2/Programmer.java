package com.xiwen.exercise.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:55
 * @Version: 1.0
 */
public class Programmer extends Employee {
    private String occupation;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, String occupation) {
        super(id, name, age, salary);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return super.toString() +
                "occupation='" + occupation;
    }
}
