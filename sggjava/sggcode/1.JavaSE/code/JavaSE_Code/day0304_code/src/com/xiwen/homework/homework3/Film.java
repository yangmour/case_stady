package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-23:32
 * @Version: 1.0
 */
public class Film {
    private String name;

    public Film(String name) {
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
        return "Film{" +
                "name='" + name + '\'' +
                '}';
    }
}
