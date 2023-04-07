package com.xiwen.bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/06 -16:54
 * @Version: 1.0
 */
public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                '}';
    }
}
