package com.xiwen.dataStructures.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        // 测试
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }

    }
}

// 创建一个栈
class ArrayStack {
    // 最大存放数量
    private int maxSize;
    // 数组模拟栈
    private int[] stack;
    // 表示栈顶
    private int top = -1;

    public ArrayStack(int maxSize) {
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

}
