package com.xiwen.sparsearray;

public class SparseArray {

    public static void main(String[] args){

        //创建一个原始的二维数组 11 * 11
        //0：表示没有棋子，1 表示 黑子 2 表篮子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][6] = 2;

        //遍历原始数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组
        //1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum += 1;
                }
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        //将数组放入数组
        int index = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr[i][j];

                }
            }
        }

        System.out.println("-----------稀疏数组------------");
        System.out.println("-----------------------");
        //遍历稀疏数组
        for (int[] data : sparseArr) {
            System.out.println(data[0] + "\t" + data[1] + "\t" +data[2]);

        }

        //将稀疏数组 恢复成 原始数组
        //1.先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //恢复数组
        for (int i=1;i<sparseArr.length;i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("-----------恢复成 原始数组------------");
        System.out.println("-----------------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}