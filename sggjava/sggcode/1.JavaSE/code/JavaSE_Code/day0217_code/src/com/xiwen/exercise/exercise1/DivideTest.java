package com.xiwen.exercise.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-14:51
 * @Version: 1.0
 */
public class DivideTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        while (true) {
            try {
                System.out.print("请输入整数被除数");
                num1 = scanner.nextInt();
                System.out.print("请输入整数除数");
                num2 = scanner.nextInt();
                if (num2 > 0) {
                    break;
                } else {
                    System.out.println("输入错误，您输入的除数是0，请输入整数！");
                }
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请输入整数！");
                scanner.nextLine();
            }catch (IllegalArgumentException e){

            }
        }

        int div = num1 / num2;
        System.out.println(div);


    }

}
