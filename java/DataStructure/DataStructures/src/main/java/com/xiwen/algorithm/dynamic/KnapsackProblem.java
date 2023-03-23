package com.xiwen.algorithm.dynamic;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/23 -14:57
 * @Version: 1.0
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //重量
        int[] weight = {1, 4, 3};
        //价值
        int[] value = {1500, 3000, 2000};
        //背包容量
        int m = 4;
        //物体个数
        int n = value.length;
        //存放动态表单
        int[][] v = new int[n + 1][m + 1];
        //存放物品进行标记
        int[][] path = new int[n + 1][m + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                //将按照公式将数据放入表单中，默认v[0][j-1]和v[i-1][0] 默认都是0
                //因为程序是从1开始所以下标需要减一
                //j相当于每一榜的重量都列举
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //Math.max(v[i - 1][j], value[i] + v[i - 1][j - weight[j - 1]]);
                    //根据公式获取当前表格的上一个j表单的数据和当前表单的价值作比较，
                    // 当前表单的价值是根据当前物体的重量 + 背包容量-减去当前物体的重量获取剩余的容量然后匹配到对应的物体重量下标
                    // ，然后将物体的价值与当前物体价值相加
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                        path[i][j] = 1; //标记物品
                    }
                }
            }
        }
        for (int[] values : v) {
            System.out.println(Arrays.toString(values));
        }

        int i = path.length - 1;
        int j = path[i].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个商品放入背包");
                j -= weight[i - 1]; //减去当前物品重量
            }
            i--;
        }
    }

}
