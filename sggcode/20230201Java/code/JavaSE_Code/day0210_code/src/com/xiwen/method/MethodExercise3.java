package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-11:25
 * @Version: 1.0
 */
public class MethodExercise3 {
    public static void main(String[] args) {
        /**
         * ### 3、数组查找算法
         * （1）定义一个isSmallToBig方法，判断数组元素是否从小到大排序的
         * （2）定义一个isBigtoSmall方法，判断数组元素是否从大到小排序的
         * （3）定义一个binarySearchSTB方法，二分查找target是否在int[]数组中，不存在返回-1，存在返回第一次找到的下标值，如果传入的数组不是从小到大排序的，结果将是不确定的
         * （4）定义一个binarySearchBTS方法，二分查找target是否在int[]数组中，不存在返回-1，存在返回第一次找到的下标值，如果传入的数组不是从大到小排序的，结果将是不确定的
         * （5）定义一个orderSearch方法，顺序查找target是否在int[]数组中，不存在返回-1，存在返回第一次找到的下标值
         * （6）测试
         * A：自行准备一个int[]数组，并从键盘输入查找目标
         * B：判断如果数组是升序排序，就调用binarySearchSTB方法查找目标是否存在，如果是降序排列，就调用binarySearchBTS方法查找是否存在，如果数组无序，就调用orderSearch方法查找目标是否存在。
         */

        int[] arr = {1, 3, 4, 5, 10, 2, 6};
        arr = new int[]{7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(isSmallToBig(arr) ? "是从小到大排序" : "不是从小到大排序");
        System.out.println(isBigToSmall(arr) ? "是从大到小排序" : "不是从大到小排序");
        int target = 2;
        int indexSTB = binarySearchSTB(arr, target);
        int indexBTS = binarySearchBTS(arr, target);
        int indexOrder = orderSearch(arr, target);

        System.out.println(indexSTB);
        System.out.println(indexBTS);
        System.out.println(indexOrder);

    }

    private static int orderSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearchBTS(int[] arr, int target) {
        if (!isBigToSmall(arr)) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearchSTB(int[] arr, int target) {
        if (!isSmallToBig(arr)) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static boolean isBigToSmall(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                flag = false;
            }
        }
        return flag;
    }

    private static boolean isSmallToBig(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = false;
            }
        }
        return flag;
    }
}
