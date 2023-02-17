package com.xiwen.test;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-11:25
 * @Version: 1.0
 */
public class Test1 extends Father{
    private String name = "test";

    public static void main(String[] args) {
        Test1 test = new Test1();
        System.out.println(test.getName());//father
    }
}
class Father {
    private String name = "father";

    public String getName() {
        return name;
    }
}