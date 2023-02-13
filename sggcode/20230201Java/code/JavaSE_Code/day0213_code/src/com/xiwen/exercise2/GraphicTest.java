package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-15:34
 * @Version: 1.0
 */
public class GraphicTest {

    public static void main(String[] args) {
        Graphic[] graphics = new Graphic[5];

        Circle circle1 = new Circle(1.2);
        Circle circle2 = new Circle(30);
        Rectangle rectangle1 = new Rectangle(10, 20);
        Rectangle rectangle2 = new Rectangle(5, 10);
        Rectangle rectangle3 = new Rectangle(20, 20);

        graphics[0] = circle1;
        graphics[1] = circle2;
        graphics[2] = rectangle1;
        graphics[3] = rectangle2;
        graphics[4] = rectangle3;

        System.out.println("排序前:");
        for (Graphic graphic : graphics) {
            System.out.println(graphic);
        }
        System.out.println("排序后:");
        for (int i = 1; i < graphics.length; i++) {
            boolean flag = true;
            for (int j = 0; j < graphics.length - 1; j++) {
                if (graphics[j].area() > graphics[j + 1].area()) {
                    Graphic temp = graphics[j];
                    graphics[j] = graphics[j + 1];
                    graphics[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        for (Graphic graphic : graphics) {
            System.out.println(graphic);
        }
    }
}
