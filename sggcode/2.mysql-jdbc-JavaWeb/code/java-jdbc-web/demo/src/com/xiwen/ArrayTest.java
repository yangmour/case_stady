package com.xiwen;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/20 -09:49
 * @Version: 1.0
 */
public class ArrayTest {
    public static void main(String[] args) {

        //!true
        //f
        //! false&true
        //true

        //!false|true
        //false


//        int[] arr = {2, 3, 6, 1, 4, 7};
        int[] arr = {2, 3, 6, 7, 7};
//        int[] arr = {6, 5, 9, 3, 1, 4};

//        int[] arr = {6,8,10,2,4,12};
        //       Scanner input = new Scanner(System.in);
//        int[] arr = new int[6];
//        for (int i = 0; i < 6; i++) {
//            System.out.println("请输入数字：");
//            arr[i] = input.nextInt();
//        }

        int[] arr2 = arr.clone();
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        //i<j-1 是因为减少最后一次交换
        for (int i = 0, j = arr2.length - 1; i < j;) {
            /*//当左边为偶数的值，如果是偶数就交换，是奇数就下标加1
            while (i < j && arr2[i] % 2 != 0) {
                i++;
            }
            //找右边奇数的值，如果是奇数就交换，偶数就当前下标减1
            while (j > 0 && arr2[j] % 2 == 0) {
                j--;
            }*/
            if (arr2[i] % 2 != 0) {
                i++;
            }
            if (arr2[j] % 2 == 0) {
                j--;
            }


            if (arr2[i] % 2 == 0 && arr[j] % 2 != 0) {
                //交换数据
                int temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
