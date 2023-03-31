package com.case01.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:11
 * @Version: 1.0
 */
public class Part01_Exercise03_3 {
    public static void main(String[] args){
        int x = 1,y = 1;

        if(x++==1 | ++y==1){
            x =7;
        }
        System.out.println("x="+x+",y="+y); //x=7 y=2
    }
}
