package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:32
 * @Version: 1.0
 */
public class Student extends Person {
    private double score;

    public Student() {
    }

    public Student(String name, int age, String gender, double score) {
        super(name, age, gender);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString() + ",分数:" + score;
    }
}
