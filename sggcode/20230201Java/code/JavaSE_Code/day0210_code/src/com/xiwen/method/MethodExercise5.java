package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-14:13
 * @Version: 1.0
 */
public class MethodExercise5 {
    public static void main(String[] args) {
        /**
         * （1）在MathTools类中声明如下方法：
         * - 声明方法int min(int... nums)：返回n个整数中的最小值
         * - 声明方法int maxApproximate(int... nums)：返回n个整数的最大公约数
         * （2）在测试类的main方法中调用测试
         */
        int[] nums = {1, 3, 4, 5, 10, 2, 6};
        nums = new int[]{6, 12};
        int min = min(nums);

        int maxApproximate = maxApproximate(nums);
        maxApproximate = maxApproximate(1, 3, 4, 5, 10, 2, 6);
        System.out.println(min);
        System.out.println(maxApproximate);


    }

    private static int maxApproximate(int... nums) {

        int min = min(nums);
        int divisor = -1;
        for (int i = 1; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                divisor = i;
            }
        }


        return divisor;
    }

    private static int min(int[] nums) {
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[min] > nums[i]) {
                min = i;
            }
        }
        return nums[min];
    }

}
