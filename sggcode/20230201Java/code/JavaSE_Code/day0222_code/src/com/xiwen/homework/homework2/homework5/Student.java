package com.xiwen.homework.homework2.homework5;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:40
 * @Version: 1.0
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int compare = -Double.compare(score, o.getScore());
        if (compare == 0) {
            return age - o.getAge();
        }
        return compare;
    }


}
