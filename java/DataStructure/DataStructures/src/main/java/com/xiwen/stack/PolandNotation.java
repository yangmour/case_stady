package com.xiwen.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/6-10:29
 * @Version: 1.0
 */
public class PolandNotation {

    public static void main(String[] args) {

        // 定义一个逆波兰表达式
        // (30+4)X5-6 => 30 4 + 5 × 6 - =>164
        // 4*5-8+60+8/2 => 4 5 * 8 - 60 + 8 2 / +
        //测试
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -"; //29

        //思路
        //1. 先将"3 4 + 5 × 6 -"=>放入ArrayList中
        //2. 将ArrayList传递给一个方法，遍历ArrayList配合栈 完成计算

        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        int res = calculate(list);

        System.out.println("计算的结果是=" + res);

    }

    //计算逆波兰表达式结果

    /**
     * 1.从左到右扫描，如果是数字就压入栈中
     * 2.遇到运算符就弹出两个栈顶元素进行计算，将结果入栈
     *
     * @param list 逆波兰表达式
     * @return 结果
     */
    private static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //将表达式的元素取出来，然后判断是数字还是符号
            //这里用正则表达式取数,就入栈
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数来计算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                // 判断符号
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num2 * num1;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误！");
                }

                //结果入栈
                stack.push("" + res);

            }
        }
        return Integer.parseInt(stack.pop());

    }

    //将逆波兰表达式，依次将数据和运算符放到ArrayList中
    private static List<String> getListString(String suffixExpression) {

        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();

        for (String ele : split) {
            list.add(ele);
        }

        return list;
    }
}
