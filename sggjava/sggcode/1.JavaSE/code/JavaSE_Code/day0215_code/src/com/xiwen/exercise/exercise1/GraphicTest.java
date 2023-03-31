package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-10:22
 * @Version: 1.0
 */
public class GraphicTest {
    public static void main(String[] args) {

        Graphic[] graphics = new Graphic[3];
        graphics[0] = new Rectangle(3, 6);
        graphics[1] = new Triangle(3, 4, 5);
        graphics[2] = new Circle(2.0);

        for (Graphic graphic : graphics) {
            System.out.println(graphic);
        }
    }
}
