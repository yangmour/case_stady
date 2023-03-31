package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-20:06
 * @Version: 1.0
 */
public class MathTools {

    boolean isEven(int... nums) {
        if (0 == nums.length) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    boolean isPositive(int... nums) {
        if (0 == nums.length) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                return false;
            }
        }
        return true;
    }

    String toArray(int... nums) {
        String str = "[";
        for (int i = 0; i < nums.length; i++) {
            str += nums[i] + (i < nums.length - 1 ? "," : "");
        }
        return str + "]";
    }

}
