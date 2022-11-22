package com.xiwen.queue;

import java.util.Scanner;

/**
 * @author yf
 * @data 2022/11/22-21:31
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        //测试队列
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);

        char key = ' ';
        boolean flag = true;
        while (flag) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.println(result);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出~~~");

    }

}

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示队列最大容量
     */
    private int maxSize;
    /**
     * 代表队列的前一个索引
     */
    private int front;
    /**
     * 代表队列的尾部前一个索引
     */
    private int rear;
    /**
     * 代表队列，用来存放数据
     */
    private int[] arr;

    /**
     * 初始化队列
     *
     * @param maxSize 队列最大容量
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是不是满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是不是空的
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 向队列添加一个数据
     *
     * @param num 数据
     */
    public void addQueue(int num) {
        //判断队列是不是满了
        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        //队列尾索引移动一位
        rear++;
        //添加数据
        arr[rear] = num;
    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        //判断队列是不是空的
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }


        //头索引位置移位
        front++;
        //获取数据
        int value = arr[front];
        arr[front] = 0;
        //返回数据
        return value;
    }

    /**
     * 获取队列的头部数据
     */
    public int headQueue() {
        //判断队列是不是空的
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }

        return arr[front + 1];

    }

    /**
     * 获取全部队列数据
     */
    public void showQueue() {
        //判断队列是不是空的
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }

    }


}