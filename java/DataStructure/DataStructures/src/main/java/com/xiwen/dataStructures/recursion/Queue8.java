package com.xiwen.dataStructures.recursion;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/9-16:07
 * @Version: 1.0
 */
public class Queue8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];

    private static int count;
    private static int judgeCount;

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();

        queue8.check(0);

        System.out.println("一共有" + count + "解法");
        System.out.println("一共判断冲突的次数有" + judgeCount + "解法");
    }

    /**
     * 编写一个方法，放置第n个皇后
     * 特别注意: check是每一次递归时，进入到check中都有for(int i=0;i<n;i++)因此有回溯
     * @param n 第n个皇后
     */
    private void check(int n){
        // n =8 ,其实8个皇后就已经放好了
        if (n == max){
            print();
            return;
        }

        // 依次放入皇后
        for (int i = 0; i < max; i++) {
            //把当前这个皇后n，放到该行的第一列
            array[n] = i;
            // 不冲突就递归放下一个皇后
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    /**
     * 查看当前我们放置第n个皇后，就去检测该皇后是否和前面已经摆好的皇后冲突
     * @param n 表示第n个皇后
     * @return true 不冲突 false 冲突
     */
    private boolean judge(int n){

        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            // 1.array[i] == array[n] 表示n个皇后与前面n-1个皇后同列
            // 2.Math.abs(n-1) == Math.abs(array[n]-array[i]) 表示判断第n个皇后是不是同一斜线
            //      如n=1 放置第二列1 n=1 array[1] = 1
            //       Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1 - 0) = 1

            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }

        return true;
    }

    // 打印
    private void print(){
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
