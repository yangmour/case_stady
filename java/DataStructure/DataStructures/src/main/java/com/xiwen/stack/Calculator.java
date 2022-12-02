package com.xiwen.stack;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/2-20:09
 * @Version: 1.0
 */
public class Calculator {
    public static void main(String[] args) {

        //完成表达式的运算 7*2*2-5+1-5+3-4
        String expression = "3+2*6-2"; // 15//如何处理多位数的问题?

        //创建两个栈一个存放数一个存放符号
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //需要的变量
        //用于扫描的指针
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  //每次扫描的字符

        while (true) {
            // 按顺序得到字符
            ch = expression.substring(index, index + 1).charAt(0);

            //判断字符是字符还是数字
            if (operStack.isOper(ch)) { //字符

                //不为空就处理一下
                if (!operStack.isEmpty()) {
                    //判断符号的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        //计算
                        res = operStack.cul(num1, num2, oper);
                        //结果入栈
                        numStack.push(res);
                        //将当前符号入栈
                        operStack.push(ch);
                    } else { //大于栈中的操作符就直接入栈
                        operStack.push(ch);
                    }

                } else { //如果字符的栈为空直接添加
                    operStack.push(ch);
                }

            } else { //数
                numStack.push(ch - '0');
            }

            index++;
            // 如果扫描到最后就break
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描完毕后，按照顺序计算结果
        while (true) {
            //如果符号栈为空则计算到最后一个结果，数栈中只有一个数字结果
            if (operStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            //计算
            res = operStack.cul(num1, num2, oper);
            //结果入栈
            numStack.push(res);
        }
        //将数栈的最后数，pop出就是结果
        res = numStack.pop();
        System.out.printf("表达式 %s=%d", expression, res);


    }
}

// 创建一个栈
class ArrayStack2 {
    // 最大存放数量
    private int maxSize;
    // 数组模拟栈
    private int[] stack;
    // 表示栈顶
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        // 判断栈是否满了
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        // 指针位移
        top++;
        // 插入数据
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        // 判断栈是不是空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }

        // 记录临时数据
        int value = stack[top];
        // 数据移位
        top--;
        return value;

    }

    // 打印数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~~");
            return;
        }

        // 需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }

    // 判断是符号还是数
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 判断符号优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 计算
    public int cul(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;

    }

    public int peek() {
        return stack[top];
    }

}

