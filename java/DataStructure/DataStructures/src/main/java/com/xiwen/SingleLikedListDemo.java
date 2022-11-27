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


        System.out.println("不按顺序添加节点的时候!");
        System.out.println("-----------------------------------------");
        //测试不按顺序添加节点的时候
        SingleLikedList singleLikedList = new SingleLikedList();
        singleLikedList.add(hero1);
        singleLikedList.add(hero3);
        singleLikedList.add(hero2);
        singleLikedList.add(hero4);

        singleLikedList.list();


        System.out.println("按顺序添加节点的时候!");
        System.out.println("-----------------------------------------");
        //测试不按顺序添加节点的时候
        singleLikedList = new SingleLikedList();
        singleLikedList.addByOrder(hero4);
        singleLikedList.addByOrder(hero3);
        singleLikedList.addByOrder(hero3);
        singleLikedList.addByOrder(hero1);
        singleLikedList.addByOrder(hero2);

        singleLikedList.list();

        System.out.println("修改测试!");
        System.out.println("-----------------------------------------");
        singleLikedList.update(new HeroNode(2,"阿文","a"));

        singleLikedList.list();

        System.out.println("删除测试!");
        System.out.println("-----------------------------------------");
        singleLikedList.del(2);
        singleLikedList.del(1);
        singleLikedList.del(5);
        singleLikedList.del(4);

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
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){

        //因为head节点不能动，因此需要一个临时辅助节点
        HeroNode temp = head;
        boolean flag = false;

        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                //不在循环
                break;
            }

            //如果下一个节点的比较大就将数据插入到前面
            if (temp.next.no>heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){ //说明已存在
                flag = true;
                break;
            }

            //如果上面都不符合就将temp后移
            temp = temp.next;
        }

        //判断flag，如果为true就是编号已存在
        if (flag){
            System.out.printf("准备插入的英雄编号 %d 已经存在了，不能加入\n", heroNode.no);
        }else {
            //将heroNode连接到temp的下一个
            heroNode.next = temp.next;
            //插入到链表，temp 的后面
            temp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode){
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
                System.out.println("未找到！");
                break;
            }
            //找到就修改
            if (temp.no == newHeroNode.no){
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                System.out.println("节点以修改！");
                break;
            }

            temp =temp.next;

        }
    }

    /**
     * 按照编号删除
     * @param delNo
     */
    public void del(int delNo){
        //判断链表是不是空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //因为头节点不能动，因此需要一个辅助临时节点
        HeroNode temp = head;
        boolean flag = false;
        //遍历节点
        while (true) {
            //判断是否到了链表的最后
            if (temp.next == null) {
                break;
            }
            //找到就删除
            if (temp.next.no == delNo){
                flag = true;
                break;
            }
            temp =temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到！");
        }
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

