package com.xiwen.stack;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/11/27-11:52
 */
public class SingleLikedListStackDemo {

    public static void main(String[] args) {
        // 进行测试
       

        System.out.println("-----------------------------------------");
        // 测试不按顺序添加节点的时候
        SingleLikedList singleLikedList = new SingleLikedList(new HeroNode(5));

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
                singleLikedList.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int no = scanner.nextInt();
                    HeroNode heroNode = new HeroNode();
                    heroNode.no = no;
                    singleLikedList.push(heroNode);
                    break;
                case "pop":
                    try {
                        System.out.println(singleLikedList.pop());
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

/**
 * 定义SingleLikedList管理英雄
 */
class SingleLikedList {
    // 当做头节点，头节点不要动，不放具体内容
    private HeroNode head = new HeroNode();

    

    public SingleLikedList(HeroNode head) {
        this.head = head;
    }

    /**
     * 返回头节点
     *
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    public int getSize() {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isFull() {
        return getSize() == head.maxSize;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 入栈
     */
    public void push(HeroNode heroNode) {

        if (isFull()) {
            System.out.println("栈满了\n");
            return;
        }

        // 因为head节点不能动，因此需要一个临时辅助节点
        HeroNode temp = head;

        // 遍历链表
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                // 不在循环
                break;
            }
            // 如果上面没找到最后一个就将temp后移
            temp = temp.next;
        }

        // 当退出循环的时候，temp指向了链表的最后一个
        // 将最后这个节点的next指向添加的新节点
        temp.next = heroNode;
    }

    /**
     * 出栈
     */
    public int pop() {
        // 判断链表是不是空
        if (isEmpty()) {
            throw new RuntimeException("栈空\n");
        }

        // 因为头节点不能动，因此需要一个辅助临时节点
        HeroNode temp = head;
        // 遍历节点 5
        for (int i = 0; i < getSize() - 1; i++) {
            temp = temp.next;
        }

        int value = temp.next.no;
        temp.next = null;
        return value;

    }

    /**
     * 打印所有节点信息
     */
    public void list() {
        // 判断链表是不是空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        // 因为头节点不能动，因此需要一个辅助临时节点
        HeroNode temp = head.next;
        // 遍历节点
        while (true) {
            // 判断是否到了链表的最后
            if (temp == null) {
                break;
            }

            // 如果没到最后就打印节点信息
            System.out.println(temp);
            // 将节点后移
            temp = temp.next;

        }
    }
}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public int maxSize;
    public HeroNode next;

    // 构造器

    public HeroNode() {
    }

    public HeroNode(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +'}';
    }
}
