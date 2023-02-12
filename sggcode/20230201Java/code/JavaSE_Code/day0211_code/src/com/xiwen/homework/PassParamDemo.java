package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-11:42
 * @Version: 1.0
 */
public class PassParamDemo {
    public void doubleNumber(int num) {
        num *= 2;
    }
    void toUpperCase(char letter) {
        letter -= 32;
    }
    void expandCircle(Circle c, double times) {
        if (c == null) {
            System.out.println("请创建一个圆的对象");
            return;
        }
        c.setRadius(c.getRadius() * times);
    }
    void doubleElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
    void grow(int[] arr) {
        arr = new int[10];
    }
}

class PassParamDemoTest {
    public static void main(String[] args) {
        PassParamDemo demo = new PassParamDemo();

        int x = 1;
        demo.doubleNumber(x);
        System.out.println("x = " + x);

        char c = 'a';
        demo.toUpperCase(c);
        System.out.println("c = " + c);

        Circle circle = new Circle();
        circle.setRadius(1);
        demo.expandCircle(circle, 5);
        System.out.println("circle.radius = " + circle.getRadius());

        int[] arr = {1, 2, 3, 4, 5};
        demo.doubleElement(arr);
        System.out.println("调用doubleElement方法之后：");
        System.out.println("arr数组的元素：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        demo.grow(arr);
        System.out.println("调用grow方法之后：arr的数组长度：" + arr.length);
        System.out.println("arr数组的元素：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
