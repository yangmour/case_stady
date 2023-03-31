package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-10:56
 * @Version: 1.0
 */
public class MethodExercise2 {
    /**
     * ### 2、数组最值算法
     * （1）定义一个maxInArray方法，查找int[]数组中最大值
     * （2）定义一个minInArray方法，查找int[]数组中最小值
     * （3）测试
     * A：自行准备一个int[]数组，
     * B：调用上面的方法找出最大值和最小值
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 10, 2, 6};
        System.out.println(maxInArray(arr));
    }

    private static int maxInArray(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = arr[max] < arr[i] ? i : max;
        }
        return arr[max];
    }

}
