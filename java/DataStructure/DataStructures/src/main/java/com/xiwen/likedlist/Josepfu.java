package com.xiwen.likedlist;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/11/30-12:53
 * @Version: 1.0
 */
public class Josepfu {
    public static void main(String[] args) {

        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);

    }
}

/**
 * 创建一个环形单向链表
 */
class CircleSingleLinkedList {

    //创建一个first节点
    private Boy first = null;

    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums) {
        //做一个数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确！");
            return;
        }

        //创建一个辅助变量
        Boy curBoy = null;

        //创建环境链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //当第一个节点的时候
            if (i == 1) {
                //创建节点
                first = boy;
                //将节点指向下一个
                first.setNext(first);
                //辅助节点指向first第一个小孩
                curBoy = first;
            } else {
                //设置下一个节点
                curBoy.setNext(boy);
                //将当前孩子节点指向first节点的第一个孩子
                boy.setNext(first);
                //移动辅助指向
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是不是空
        if (first == null) {
            System.out.println("环形链表为空！");
            return;
        }

        //设置一个辅助节点
        Boy cur = first;
        while (true) {
            System.out.println("小孩的编号为" + cur.getNo());
            //说明遍历完毕
            if (cur.getNext() == first) {
                break;
            }
            //后移
            cur = cur.getNext();
        }

    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序的顺序
     *
     * @param startNo  从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || countNum > nums) {
            System.out.println("输入的参数有误，请重新输入");
            return;
        }

        //设置一个辅助节点
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //先将开始节点移动到指定节点位置 应该是startNo-1个因为当前所在的位置也算
        for (int i = 1; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {

            //当前圈中只有一个节点
            if (helper == first) {
                break;
            }

            //让两个指针同时移动 ，移动countNum-1个，移动到了出圈的小孩
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //上面的循环到小孩出圈的节点 进行输入 在设置成下一个指向
            System.out.printf("小孩%d出圈\n", first.getNo());
            //移动指向
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后一个出圈的小孩是: " + first.getNo());

    }

}


/**
 * 创建一个Boy类,表示一个节点
 */
class Boy {
    //编号
    private int no;
    //下一个节点
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
