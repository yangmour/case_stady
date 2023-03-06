package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-15:05
 * @Version: 1.0
 */
public class ExerTest3 {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        try{
            return ++i;
        }finally{
            return ++i;
        }
    }
}
