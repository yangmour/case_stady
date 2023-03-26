package com.xiwen.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/26 -13:09
 * @Version: 1.0
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {

        //创建广播电视台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        //将各个电视台放入broadcasts中
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //放入map中
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        System.out.println(allAreas);

        //用于临时存放地区
        HashSet<String> temp = new HashSet<>();

        //用于存储的最大的k值
        String maxKey = null;

        //用于存放所有的电台
        ArrayList<String> selectAll = new ArrayList<>();

        //迭代所有k的
        while (allAreas.size() != 0) {

            //将key遍历一遍
            for (String k : broadcasts.keySet()) {

                //获取value值
                HashSet<String> hashSet = broadcasts.get(k);
                temp.addAll(hashSet);

                //找出和allAreas交集的部分，保存到temp中
                temp.retainAll(allAreas);

                //
                HashSet<String> maxKeySet = broadcasts.get(maxKey);
                if (maxKeySet != null) {
                    maxKeySet.retainAll(allAreas);
                }
                if (temp.size() > 0 && (maxKey == null || temp.size() > maxKeySet.size())) {
                    maxKey = k;
                }
                //如果有值就将值放入list集合中
                if (maxKey != null) {
                    selectAll.addAll(temp);
                    allAreas.removeAll(broadcasts.get(maxKey));
                }
                //情况临时数据防止影响下次
                maxKey = null;
                temp.clear();
            }

        }

        System.out.println(selectAll);

    }
}
