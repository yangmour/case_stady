package com.xiwen.homework.homework2.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:01
 * @Version: 1.0
 */
public class Homework1 {
    public static void main(String[] args) {
        //	1、用一个String[]数组存点数
        //	2、用一个String[]数组存花色
        //	3、用一个String[]数组存大王、小王
        String[] dian = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] hua = {"黑桃", "红桃", "方片", "梅花"};
        String[] wang = {"大王", "小王"};
        //	4、用上面的数组，生成一副扑克牌
        ArrayList<String> pai = new ArrayList<>();
        for (int i = 0; i < dian.length; i++) {
            for (int j = 0; j < hua.length; j++) {
                String res = hua[j] + dian[i];
                pai.add(res);
            }
        }

        for (int i = 0; i < wang.length; i++) {
            pai.add(wang[i]);
        }
        //	5、遍历显示全副扑克牌
        for (String s : pai) {
            System.out.print(s + " ");
        }


        //	6、模拟给4个人随机发牌，每个人11张牌
        System.out.println();
        System.out.println("发牌：");

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Random rand = new Random();

        ArrayList<String> one = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            one.add(pai.remove(rand.nextInt(pai.size())));
        }

        ArrayList<String> two = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            two.add(pai.remove(rand.nextInt(pai.size())));
        }
        ArrayList<String> tree = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            tree.add(pai.remove(rand.nextInt(pai.size())));
        }
        ArrayList<String> four = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            four.add(pai.remove(rand.nextInt(pai.size())));
        }

        Collections.addAll(list, one, two, tree, four);

        //	7、显示每个人的牌和剩余的牌
        for (ArrayList<String> strings : list) {
            System.out.println(strings);
        }
        System.out.println("剩余的牌:" + pai);

    }
}
