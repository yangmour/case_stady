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

        // 将中缀表达式转成后缀表达式
        // 例子 1+(2+3)×4)-5 => 转成 123+4X+5-
        // 1.将字符串存入ArrayList中 如："1+((2+3)×4)-5"=>ArrayList[1,+,(,(2,+,3,),*,4,)-,5]
        // 2.中缀表达式的ArrayList转成后缀ArrayList 如：ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]=》ArrayList[1,2,3,+,4,*,+,5,-]

        //注意表达式
        String expression = "10+((2+3)*4)-5";

        // 转成集合
        List<String> infixExpreesionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式:" + infixExpreesionList);
        //将中缀表达式转成后缀表达式
        List<String> suffixExpressionList = parseSuffixExpreesionList(infixExpreesionList);
        System.out.println("后缀表达式:" + suffixExpressionList);

        StringBuilder stringBuilder = new StringBuilder();
        for (String item : suffixExpressionList) {
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);

        // 定义一个逆波兰表达式
        // (30+4)X5-6 => 30 4 + 5 × 6 - =>164
        // 4*5-8+60+8/2 => 4 5 * 8 - 60 + 8 2 / +
        //测试
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -"; //29

        //思路
        //1. 先将"3 4 + 5 × 6 -"=>放入ArrayList中
        //2. 将ArrayList传递给一个方法，遍历ArrayList配合栈 完成计算

        List<String> list = getListString(stringBuilder.toString());
        System.out.println(list);
        int res = calculate(list);

        System.out.println("计算的结果是=" + res);

    }

    //中缀转后缀
    // 思路
    // 1.准备两个栈 s1 放 数和符号过程中使用 s2 放结果
    // 2.将数据和符号遍历出来，如果是数就入栈
    //      如果是符号就看优先级 + - 是1、* / 是2
    //      如果是左括号就入栈，碰见右括号为止数和符号出栈

    private static List<String> parseSuffixExpreesionList(List<String> infixExpreesionList) {

        Stack<String> s1 = new Stack<>();
//        Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String item : infixExpreesionList) {
            // 如果是数 加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) { //如果是左符号入栈
                s1.push(item);
            } else if (item.equals(")")) { //右括号需要处理

                //如果栈顶中不是左括号就不断地取出放入s2中
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //取完之后在将左括号弹出
                s1.pop();

            } else {    //如果是其他符号在做处理
                // 先判断当前栈的数量当前栈中的符号
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);

            }
        }
        //将s1栈中的剩余运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }

    //将表达式按照顺序存入list中
    private static List<String> toInfixExpressionList(String expression) {

        List<String> list = new ArrayList<>();

        // 设置一个指针
        int index = 0;
        //保存一位
        char c;
        // 保存多位数
        String str;

        while (index < expression.length()) {
            // 如果是非数组，加入到list中
            if ((c = expression.charAt(index)) < '0' || (c = expression.charAt(index)) > '9') {
                list.add("" + c);
                //指针位移
                index++;
            } else { //如果是数就考虑是不是多位
                str = "";
                //先判断长度，在判断是不是数字
                while (index < expression.length() && (c = expression.charAt(index)) >= '0' && (c = expression.charAt(index)) <= '9') {
                    str += c;
                    index++;
                }
                list.add(str);
            }
        }
        return list;
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


// 编写一个类Operation 可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 获取优先级数字
    public static int getValue(String operation) {
        int result = 0;

        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符！");
        }
        return result;
    }
}
