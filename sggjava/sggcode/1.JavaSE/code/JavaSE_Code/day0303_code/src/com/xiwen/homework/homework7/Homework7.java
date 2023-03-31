package com.xiwen.homework.homework7;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:34
 * @Version: 1.0
 */
public class Homework7 {
}
 class Test07 {
    {
        System.out.println("a");
    }
    static{
        System.out.println("b");
    }
    Test07(){
        System.out.println("c");
    }
    public static String getOut(){
        try{
            return "1";
        }catch(Exception e){
            return "2";
        }finally{
            return "3";
        }
    }
    public static void main(String[] args) {
        System.out.println(getOut());
        //b
        //3
    }
}