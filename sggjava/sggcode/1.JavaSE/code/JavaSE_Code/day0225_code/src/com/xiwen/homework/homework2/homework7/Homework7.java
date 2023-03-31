package com.xiwen.homework.homework2.homework7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:45
 * @Version: 1.0
 */
public class Homework7 {
    public static void main(String[] args) {

        Map<Integer, String> m = new HashMap<>();

        m.put(1930, "乌拉圭");
        m.put(1934, "意大利");
        m.put(1938, "意大利");
        m.put(1950, "乌拉圭");
        m.put(1954, "西德");
        m.put(1958, "巴西");
        m.put(1962, "巴西");
        m.put(1966, "英格兰");
        m.put(1970, "巴西");
        m.put(1974, "西德");
        m.put(1978, "阿根廷");
        m.put(1982, "意大利");
        m.put(1986, "阿根廷");
        m.put(1990, "西德");
        m.put(1994, "巴西");
        m.put(1998, "法国");
        m.put(2002, "巴西");
        m.put(2006, "意大利");
        m.put(2010, "西班牙");
        m.put(2014, "德国");
        m.put(2018, "法国");
        //（1）从键盘输入一个年份，输出该年的世界杯冠军是哪支球队。如果该年没有举办世界杯，则输出：没有举办世界杯。
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份:");
        String year = scanner.next();
        boolean flag = true;
        Set<Map.Entry<Integer, String>> entrySet = m.entrySet();
        for (Map.Entry<Integer, String> integerStringEntry : entrySet) {

            if (integerStringEntry.getKey().toString().equals(year)) {
                System.out.println(integerStringEntry.getValue());
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("没有举办世界杯。");
        }
        //（2）从键盘输入一支球队的名字，输出该球队夺冠的年份列表。 例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯
        //

        //开发提示：
        //
        //把年份作为key，改年夺冠的国家名称作为value存到map中
        //
        //附：历届世界杯冠军
    }
}
