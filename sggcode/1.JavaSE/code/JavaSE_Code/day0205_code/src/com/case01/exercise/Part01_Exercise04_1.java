package com.case01.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:13
 * @Version: 1.0
 */
public class Part01_Exercise04_1 {
    public static void main(String[] args){
        boolean x = true;
        boolean y = false;
        short z = 42;

        if((z++==42)&&(y==true))	z++; // z=43
        if((x=false) || (++z==45))  z++; // z=44

        System. out.println("z="+z); // 44
    }
}
