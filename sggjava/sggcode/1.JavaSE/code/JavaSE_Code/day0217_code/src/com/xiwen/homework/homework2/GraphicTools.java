package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:22
 * @Version: 1.0
 */
public class GraphicTools {
    public static void printRectangle(int line, int column, char sign) throws InvalidValueException {
        if (line <= 0 || column <= 0) {
            throw new InvalidValueException("矩形的长和宽必须是正整数");
        }
        if (sign < 33 || sign > 126) {
            throw new InvalidValueException("组成矩形的必字符必须是数字字母和基本标点符号");
        }

        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1) {
                    System.out.print(sign);
                } else if (j == 1) {
                    System.out.print(sign);
                } else if (i == line) {
                    System.out.print(sign);
                } else if (j == column) {
                    System.out.print(sign);
                } else {
                    System.out.print(" ");

                }
            }
            System.out.println();
        }

    }
}

class GraphicToolsTest {
    public static void main(String[] args) {
        try {
            GraphicTools.printRectangle(8, 6, '0');
        } catch (InvalidValueException e) {
            System.err.println(e.getMessage());
        }

    }
}
