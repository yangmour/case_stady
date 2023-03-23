package com.xiwen.dataStructures.likedlist;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/11/29-16:17
 */
public class DoubleLikedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");


        System.out.println("不按顺序添加节点的时候!");
        System.out.println("-----------------------------------------");
        //测试不按顺序添加节点的时候
        DoubleLikedList doubleLikedList = new DoubleLikedList();
        doubleLikedList.add(hero1);
        doubleLikedList.add(hero3);
        doubleLikedList.add(hero2);
        doubleLikedList.add(hero4);

        doubleLikedList.list();


        System.out.println("按顺序添加节点的时候!");
        System.out.println("-----------------------------------------");
        //测试不按顺序添加节点的时候
        doubleLikedList = new DoubleLikedList();
        doubleLikedList.addByOrder(hero4);
        doubleLikedList.addByOrder(hero3);
//        doubleLikedList.addByOrder(hero3);
        doubleLikedList.addByOrder(hero1);
        doubleLikedList.addByOrder(hero2);

        doubleLikedList.list();

        System.out.println("修改测试!");
        System.out.println("-----------------------------------------");
        doubleLikedList.update(new HeroNode2(2, "阿文", "a"));

        doubleLikedList.list();

        System.out.println("删除测试!");
        System.out.println("-----------------------------------------");
        doubleLikedList.del(2);
//        doubleLikedList.del(1);
//        doubleLikedList.del(5);
        doubleLikedList.del(4);

        doubleLikedList.list();
    }

}

/**
 * 定义SingleLikedList管理英雄
 */
class DoubleLikedList {
    //当做头节点，头节点不要动，不放具体内容
    private HeroNode2 head = new HeroNode2();

    /**
     * 返回头节点
     *
     * @return
     */
    public HeroNode2 getHead() {
        return head;
    }


    /**
     * 添加节点到双向链表
     * 思路，当不考虑编号顺序时
     * 1.找到当前链表的最后一个节点
     * 2.将最后这个节点的next指向 新节点，将per指向前一个节点
     */
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此需要一个临时辅助节点
        HeroNode2 temp = head;

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
        heroNode.pre = temp;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        if (head.next == null){
            head.next = heroNode;
            heroNode.pre = head;
            return;
        }

        //因为head节点不能动，因此需要一个临时辅助节点
        HeroNode2 temp = head.next;
        boolean flag = false;

        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp == null) {
                //不在循环
                break;
            }

            //如果下一个节点的比较大就将数据插入到前面
            if (temp.no > heroNode.no) {
                break;
            } else if (temp.no == heroNode.no) { //说明已存在
                flag = true;
                break;
            }

            //如果上面都不符合就将temp后移
            temp = temp.next;
        }

        //判断flag，如果为true就是编号已存在
        if (flag) {
            System.out.printf("准备插入的英雄编号 %d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //双向链表的改变
            //新的节点的下一个指向temp
            heroNode.next = temp;
            //新的节点前一个指向temp的前一个
            if (temp != null) {
                heroNode.pre = temp.pre;
                //temp的前面节点连接新节点
                temp.pre.next = heroNode;
                //设置当前节点的前一个
                temp.pre = heroNode;
            }



        }

    }

    /**
     * 更新没什么变化
     *
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode) {
        //判断链表是不是空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //因为头节点不能动，因此需要一个辅助临时节点
        HeroNode2 temp = head.next;
        //遍历节点
        while (true) {
            //判断是否到了链表的最后
            if (temp == null) {
                System.out.println("未找到！");
                break;
            }
            //找到就修改
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                System.out.println("节点以修改！");
                break;
            }

            temp = temp.next;

        }
    }

    /**
     * 按照编号删除 双向链表有点不同
     *
     * @param delNo
     */
    public void del(int delNo) {
        //判断链表是不是空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }

        //因为头节点不能动，因此需要一个辅助临时节点
        HeroNode2 temp = head.next;
        boolean flag = false;
        //遍历节点
        while (true) {
            //判断是否到了链表的最后
            if (temp == null) {
                break;
            }
            //找到就删除
            if (temp.no == delNo) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //单链表的方式
            // temp.next = temp.next.next;

            //双链表的方式
            temp.pre.next = temp.next;
            //当删除最后一个时候需要判断一下下一个是不是空
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("未找到节点！");
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
        HeroNode2 temp = head.next;
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


//定义HeroNode2，每个HeroNode对象就是一个节点，双向链表
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    //构造器

    public HeroNode2() {
    }

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

