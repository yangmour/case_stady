package com.xiwen.test.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-20:12
 * @Version: 1.0
 */
public class Homework6 {


    public static void main(String[] args) {
        /**
         * 案例需求：判断数组中是否存在一个值，其左侧的值累加加和等于其右侧的值累加和
         * ，如果存在，找出这个值，如果不存在就显示不存在。
         * 例如：[1,2,5,3,2,4,2]，结果为：平衡数是3，因为3左边的1,2,5累加和是8，3右边的2,4,2累加和也是8。
         *		    [9, 6, 8, 8, 7, 6, 9, 5, 2, 5]，结果是平衡数不存在。
         */
        int[] arr = {1, 2, 5, 3, 2, 4, 2};
        boolean flag = true;

        for (int mid = 0; mid < arr.length; mid++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < mid; i++) {
                leftSum += arr[i];
            }
            for (int i = mid + 1; i < arr.length; i++) {
                rightSum += arr[i];
            }

            if (leftSum == rightSum) {
                System.out.println("平衡数是" + mid);
                flag = false;
            }


        }

        if (flag){
            System.out.println("没有平衡数");
        }
    }
}
