package com.xiwen.exercise.exercis3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:45
 * @Version: 1.0
 */
public class GraphicTest {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(3, 6);
        Triangle triangle = new Triangle(3, 4, 5);
        Circle circle = new Circle(2.0);

        System.out.println("矩形和三角形");
        if (GraphicTools.compare(rectangle, triangle) == 0) {
            System.out.println("相等");
        } else if (GraphicTools.compare(rectangle, triangle) == 1) {
            System.out.println("矩形大!");
        } else {
            System.out.println("三角形大");
        }
        System.out.println("矩形和圆");
        if (GraphicTools.equals(rectangle, circle)) {
            System.out.println("相等");
        } else{
            System.out.println("不相等");
        }

        Graphic[] graphics = new Graphic[3];
        graphics[0] = rectangle;
        graphics[1] = triangle;
        graphics[2] = circle;
        //排序前:
        GraphicTools.print(graphics);
        //排序后:
        GraphicTools.sort(graphics);
        GraphicTools.print(graphics);


    }
}
