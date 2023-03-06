package com.xiwen.homework.homework2.homework4;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-17:26
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        //开发提示：可以使用Map，key是字母，value是该字母的次数
        //效果演示：例如：String str = "Your future depends on your dreams, so go to sleep.";

        String str = "Your future depends on your dreams, so go to sleep.";
        char[] charArray = str.trim().replaceAll("[^a-zA-Z]", "").toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            int count = map.get(charArray[i]) == null ? 0 : map.get(charArray[i]);
            map.put(charArray[i], count + 1);
        }

        System.out.println(map);

    }
}
