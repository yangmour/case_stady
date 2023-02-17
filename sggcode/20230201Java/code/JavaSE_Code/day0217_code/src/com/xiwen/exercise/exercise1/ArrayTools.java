package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-15:09
 * @Version: 1.0
 */
public class ArrayTools {
    public static int max(int[] arr) {
        isException(arr);
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static boolean fromSmallToLarge(int[] arr) {
        isException(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;

    }

    public static boolean fromLargeToSmall(int[] arr) {
        isException(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;

    }

    public static void isException(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("数组不能为null！");
        } else if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("数组不能没有元素");
        }
    }

    public static int binarySearch(int[] arr, int value) {
        isException(arr);

        if (!fromSmallToLarge(arr)) {
            throw new RuntimeException("数组不是有序的，不能使用二分查找");
        }

        int left = 0;
        int right = arr.length - 1;

        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == arr[mid]) {
                index = mid;
                break;
            } else if (value == arr[left]) {
                index = left;
                break;
            } else if (value == arr[right]) {
                index = right;
                break;
            } else if (value < arr[mid]) {
                right = mid - 1;
                left++;
            } else {
                left = mid + 1;
                right--;
            }
        }

        if (index == -1) {
            return index;
        }

        while (value == arr[index - 1]) index--;
        return index;
    }

    public static String toString(int[] arr) {

        if (arr == null) {
            return "";
        } else if (arr.length == 0) {
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length - 1 ? "," : "");
        }
        return result + "]";
    }
}

class ArrayToolsTest {
    public static void main(String[] args) {
//          int[] arr = null;
        int[] arr = {};
//         int[] arr = {3,2,1,4};
//        int[] arr = {1,5,5,5,5,5,16,28,39};

        try {
            System.out.println(ArrayTools.toString(arr));
            System.out.println("最大值：" + ArrayTools.max(arr));
            System.out.println("查找5：" + ArrayTools.binarySearch(arr, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
