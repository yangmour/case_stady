package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:16
 * @Version: 1.0
 */
public class Homework2 {

}
class TestExample {
    //形参是String类型，String对象不可变，
    //形参修改和实参无关
    public static void stringReplace(String text){
        text = text.replace('j','i');
    }

    //形参是StringBuffer类型，StringBuffer对象可变，
    //形参修改和实参有关，但是如果形参指向新对象，就和实参无关了
    public static void bufferReplace(StringBuffer text){
        text.append("C");
        text = new StringBuffer("Hello");
        text.append("World!");
    }

    public static void main(String[] args) {
        String textString  = new String("java");
        StringBuffer textBuffer = new StringBuffer("java");
        stringReplace(textString);
        bufferReplace(textBuffer);

        System.out.println(textString+textBuffer); //javajavaC
    }
}
