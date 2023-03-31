package com.xiwen.test.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-15:36
 * @Version: 1.0
 */
public class ArrayPascalTriangle {
    public static void main(String[] args) {
        int[][] arr = new int[10][];

        //第一个
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new int[i + 1];
//            arr[i][0] = 1;
//            arr[i][i] = 1;
//            for (int j = 1; j < arr[i].length - 1; j++) {
//                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//            }
//        }

        //第二个
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new int[i + 1];
//            for (int j = 0; j < arr[i].length; j++) {
//                if (j == 0) {
//                    arr[i][j] = 1;
//                } else if (j == arr[i].length - 1) {
//                    arr[i][j] = 1;
//                } else {
//                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//                }
//            }
//        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 第三个合并起来的
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            arr[i][0] = 1;
            arr[i][i] = 1;
            System.out.print(arr[i][0]);
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

                System.out.print("\t" + arr[i][j]);

            }
            if (i != 0) {
                System.out.print("\t" + arr[i][i]);
            }
            System.out.println();
        }


    }
}
