package com.xiwen.homework.homework2.homework6;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:43
 * @Version: 1.0
 */
public class Homework6 {
    public static void main(String[] args) throws Exception {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("北京市", Arrays.asList("北京市"));
        map.put("海南省", Arrays.asList("海口市","三亚市"));
        map.put("浙江省", Arrays.asList("绍兴市","温州市","湖州市","嘉兴市","台州市","金华市","舟山市","衢州市","丽水市"));

        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            System.out.println(entry);
        }
    }
}