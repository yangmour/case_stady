package com.xiwen.homework.homework1;

import java.io.Serializable;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-18:50
 * @Version: 1.0
 */
public class AtguiguStudent implements Serializable, Comparable<AtguiguStudent> {
    private static String school;
    private String className;


    public AtguiguStudent() {
    }

    public AtguiguStudent(String className) {
        this.className = className;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        AtguiguStudent.school = school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "AtguiguStudent{" +
                "className='" + className + '\'' + ",school=" + school +
                '}';
    }

    @Override
    public int compareTo(AtguiguStudent o) {
        return className.compareTo(o.className);
    }
}

