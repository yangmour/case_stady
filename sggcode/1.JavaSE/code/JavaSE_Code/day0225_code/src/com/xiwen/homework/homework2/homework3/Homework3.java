package com.xiwen.homework.homework2.homework3;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:19
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        //案例：双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
        // 红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）
        //开发提示：可以使用TreeSet和ArrayList结合
        Random random = new Random();

        TreeSet<Integer> set = new TreeSet<>();
        while (set.size() < 6) {
            set.add(random.nextInt(33) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(set);
        list.add(random.nextInt(16) + 1);
        System.out.println(list);

    }
}
