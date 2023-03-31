package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-15:09
 * @Version: 1.0
 */
public class RectangleTest {
    public static void main(String[] args) {

        Rectangle2[] rectangles = new Rectangle2[3];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle2();
        }

        rectangles[0].setLength(8);
        rectangles[0].setWidth(2);

        rectangles[1].setLength(7);
        rectangles[1].setWidth(3);

        rectangles[2].setLength(6);
        rectangles[2].setWidth(4);

        System.out.println("没排序:");
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("第" + (i + 1) + "个矩形，" + rectangles[i].getInfo());
        }

        System.out.println("排序后:");
        for (int i = 1; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length - i; j++) {
                if (rectangles[j].area() > rectangles[j + 1].area()) {
                    Rectangle2 temp = rectangles[j];
                    rectangles[j] = rectangles[j + 1];
                    rectangles[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("第" + (i + 1) + "个矩形，" + rectangles[i].getInfo());
        }


    }
}
