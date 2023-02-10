package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-15:24
 * @Version: 1.0
 */
public class MethodToolsExercise6 {
    public static void main(String[] args) {
        /**
         * 6、判断程序运行结果
         */
        int i = 0;
        new MethodToolsExercise6().change(i); // 计算无效因为是形参
        i = i++; // 无效自增类型
        System.out.println("i = " + i); //0
    }

    void change(int i) {
        i++;
    }
}
