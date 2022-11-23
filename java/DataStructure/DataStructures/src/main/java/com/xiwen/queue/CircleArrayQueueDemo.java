package com.xiwen.queue;

import java.util.Scanner;

/**
 * @author yf
 * @data 2022/11/23-10:05
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        //测试队列
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
 * 使用数组模拟环形队列-编写一个CircleArrayQueue类
 * 有预留一个位置的后面在写一个不预留位置的
 */
class CircleArrayQueue {
    /**
     * 表示队列最大容量
     */
    private int maxSize;
    /**
     * 代表队列的第一个元素
     */
    private int front;
    /**
     * 代表队列的尾部为数组最后一个元素的最后一个位置
     */
    private int rear;
    /**
     * 代表环形队列，用来存放数据
     */
    private int[] arr;

    /**
     * 初始化队列
     *
     * @param maxSize 队列最大容量
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是不是满了
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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

        //rear最后一个元素的位置
        arr[rear] = num;
        //环形队列需要重复使用
        rear = (rear+1)%maxSize;

    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue() {
        //判断队列是不是空的
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }

        //获取临时数据
        int value = arr[front];
        front = (front + 1) % maxSize;
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

        return arr[front];

    }

    /**
     * 获取全部队列数据
     */
    public void showQueue() {
        //判断队列是不是空的
        if (isEmpty()) {
            throw new RuntimeException("对列为空");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }

    }

    /**
     * 获取全部队列有多少数据
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


}