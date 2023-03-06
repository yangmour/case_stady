package com.xiwen.homework.homework2.homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:39
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        //案例：添加你喜欢的歌手以及你喜欢他唱过的歌曲
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> wangfei = new ArrayList<>();
        wangfei.add("《红豆》");
        wangfei.add("《传奇》");
        wangfei.add("《容易受伤的女人》");
        map.put("王菲", wangfei);
        ArrayList<String> zxy = new ArrayList<>();
        zxy.add("《一路上有你》");
        zxy.add("《吻别》");
        zxy.add("《一千个伤心的理由》");
        map.put("张学友", zxy);

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            System.out.println(entry);

        }
    }
}
