package com.xiwen;

/**
 * Description:
 *
 * @author: yf
 * @data: 2022/11/27-11:52
 */
public class SingleLikedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


        //测试不按顺序添加节点的时候
        SingleLikedList singleLikedList = new SingleLikedList();
        singleLikedList.add(hero1);
        singleLikedList.add(hero3);
        singleLikedList.add(hero2);
        singleLikedList.add(hero4);

        singleLikedList.list();


    }
}

//定义SingleLikedList管理英雄
class SingleLikedList {
    //当做头节点，头节点不要动，不放具体内容
    private HeroNode head = new HeroNode();


    /**
     * 添加节点到单链表
     * 思路，当不考虑编号顺序时
     * 1.找到当前链表的最后一个节点
     * 2.将最后这个节点的next指向 新节点
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此需要一个临时辅助节点
        HeroNode temp = head;

        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                //不在循环
                break;
            }
            //如果上面没找到最后一个就将temp后移
            temp = temp.next;
        }

        //当退出循环的时候，temp指向了链表的最后一个
        //将最后这个节点的next指向添加的新节点
        temp.next = heroNode;
    }

    /**
     * 打印所有节点信息
     */
    public void list() {
        //判断链表是不是空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //因为头节点不能动，因此需要一个辅助临时节点
        HeroNode temp = head.next;
        //遍历节点
        while (true) {
            //判断是否到了链表的最后
            if (temp == null) {
                break;
            }

            //如果没到最后就打印节点信息
            System.out.println(temp);
            //将节点后移
            temp = temp.next;

        }
    }


}


//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //构造器

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

