package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-15:04
 * @Version: 1.0
 */
public class ExerTest2 {
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test); // 8
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{
            result = x - y;
        }
    }
}
