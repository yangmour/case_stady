package com.xiwen.exercise.exercis3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:36
 * @Version: 1.0
 */
public class GraphicTools {

    public static int compare(Graphic s1, Graphic s2) {
        if (s1.area() > s2.area()) {
            return 1;
        } else if (s1.area() < s2.area()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static boolean equals(Graphic s1, Graphic s2) {
        if (s1.area() == s2.area() && s1.perimeter() == s2.perimeter()) {
            return true;
        }
        return false;
    }

    public static void sort(Graphic[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (compare(arr[j], arr[j + 1]) == 1) {
                    flag = false;
                } else if (arr[j].area() == arr[j + 1].area() && arr[j].perimeter() > arr[j + 1].perimeter()) {
                    flag = false;
                }else {
                    break;
                }
                Graphic temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

            }
            if (flag) {
                break;
            }

        }
    }

    public static void print(Graphic[] arr) {
        for (Graphic graphic : arr) {
            System.out.println(graphic);
        }
    }

}


