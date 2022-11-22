package com.xiwen.sparsearray;

import java.io.*;


public class SparseArray {

    public static void main(String[] args) throws Exception {

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
        //将稀疏数组保存到文件中
        //文件流
        FileWriter fw = new FileWriter("map.data", false);
        //提升速度缓存文件流
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("-----------稀疏数组------------");
        System.out.println("-----------------------");
        //遍历稀疏数组并写入数据
        for (int[] data : sparseArr) {
            System.out.println(data[0] + "\t" + data[1] + "\t" + data[2]);
            bw.write(data[0] + "\t" + data[1] + "\t" + data[2] + "\n");
        }
        bw.close();
        fw.close();


        //在文件中一行一行读取稀疏数组
        BufferedReader br = new BufferedReader(new FileReader("map.data"));

        String line;
        int rowIndex = 0;
        //统计数据行数
        while ((line = br.readLine()) != null) {
            rowIndex++;
        }
        br.close();

        //创建一个用于存储文件中读取的稀疏数组
        int[][] sparse2Arr = new int[rowIndex][3];
        //由于读取完毕整个文本文档，所以”重启“流
        br = new BufferedReader(new FileReader("map.data"));

        int rowTemp = 0;
        //将文件中的数据恢复为稀疏数组
        while ((line = br.readLine()) != null) {
            String[] lineArr = line.split("\t");
            for (int j = 0; j < lineArr.length; j++) {
                sparse2Arr[rowTemp][j] = Integer.parseInt(lineArr[j]);
            }
            rowTemp++;

        }
        br.close();

        System.out.println("-----------遍历文件中恢复的稀疏数组------------");
        System.out.println("--------------------------------------------");
        //遍历文件中恢复的稀疏数组
        for (int[] data : sparse2Arr) {
            System.out.println(data[0] + "\t" + data[1] + "\t" + data[2]);
        }

        //将稀疏数组 恢复成 原始数组
        //1.先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int[][] chessArr2 = new int[sparse2Arr[0][0]][sparse2Arr[0][1]];

        //恢复数组
        for (int i = 1; i < sparse2Arr.length; i++) {
            chessArr2[sparse2Arr[i][0]][sparse2Arr[i][1]] = sparse2Arr[i][2];
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