package com.case01.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:10
 * @Version: 1.0
 */
public class Part01_Exercise03_2 {
    public static void main(String[] args){
        int x = 1,y = 1;

        if(x++==2 && ++y==2){
            x =7;
        }
        System.out.println("x="+x+",y="+y); // x=2 y=1
    }
}
