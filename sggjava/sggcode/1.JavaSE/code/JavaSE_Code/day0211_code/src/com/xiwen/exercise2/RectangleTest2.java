package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-15:09
 * @Version: 1.0
 */
public class RectangleTest2 {
    public static void main(String[] args) {

        Rectangle[] rectangles = new Rectangle[3];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle();
        }

        rectangles[0].length = 5;
        rectangles[0].width = 5;

        rectangles[1].length = 10;
        rectangles[1].width = 6;

        rectangles[2].length = 6;
        rectangles[2].width = 8;

        System.out.println("没排序:");
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("第"+(i+1)+"个矩形，"+rectangles[i]);
        }

        System.out.println("排序后:");
        for (int i = 1; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length - i; j++) {
                if (rectangles[j].area() > rectangles[j + 1].area()) {
                    Rectangle temp = rectangles[j];
                    rectangles[j] = rectangles[j + 1];
                    rectangles[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("第"+(i+1)+"个矩形，"+rectangles[i]);
        }


    }
}
