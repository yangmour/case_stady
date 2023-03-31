package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-21:09
 * @Version: 1.0
 */
public class ArrayTools {

    boolean isOrderedD(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    boolean isOrderedI(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    boolean isOrderedC(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    int binarySearch(int[] arr, int value) {
        if (!isOrderedI(arr)) {
            System.out.println("数组不是有序的！");
            return -2;
        }

        int flag = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == arr[mid]) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return flag;
    }

    int binarySearch(double[] arr, double value) {
        if (!isOrderedD(arr)) {
            System.out.println("数组不是有序的！");
            return -2;
        }

        int flag = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == arr[mid]) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return flag;
    }

    int binarySearch(char[] arr, char value) {
        if (!isOrderedC(arr)) {
            System.out.println("数组不是有序的！");
            return -2;
        }

        int flag = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == arr[mid]) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return flag;
    }

    void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

    }

    void sort(double[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

    }

    void sort(char[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "ArrayTools{}";
    }

    public String toString(int[] arr) {
        String result = "{";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length - 1 ? "," : "");
        }

        return result += "}";
    }

    public String toString(char[] arr) {
        String result = "{";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length - 1 ? "," : "");
        }

        return result += "}";
    }

    public String toString(double[] arr) {
        String result = "{";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length - 1 ? "," : "");
        }

        return result += "}";
    }


}

class ArrayToolsTest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 6};  //显示排序前后的元素、查找5
        char[] letters = {'h', 'e', 'w', 'o', 'd'};//显示排序前后的元素、查找'a'
        double[] nums = {2.3, 1.5, 2.0, 3.5, 3.0};//显示排序前后的元素、查找1.5


        ArrayTools mathTools = new ArrayTools();
        System.out.println(mathTools.toString(arr));
        mathTools.sort(arr);
        System.out.println(mathTools.binarySearch(arr, 2));
        System.out.println(mathTools.toString(arr));
        System.out.println("---------------");
        System.out.println(mathTools.toString(letters));
        mathTools.sort(letters);
        System.out.println(mathTools.binarySearch(letters, 'a'));

        System.out.println(mathTools.toString(letters));
        System.out.println("---------------");
        System.out.println(mathTools.toString(nums));
        mathTools.sort(nums);
        System.out.println(mathTools.binarySearch(nums, 3.5));

        System.out.println(mathTools.toString(nums));


    }
}