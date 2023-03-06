package com.xiwen.homework.homework2.homework1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-18:15
 * @Version: 1.0
 */
public class Homework1 {
    public static void main(String[] args) {

        ArrayList<Character> letterList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 26 + 10; i++) {
            if (i <= 9) {
                letterList.add((char) (i + 48));
            } else if (i < (26 + 10)) {
                letterList.add((char) (97 - 10 + i));
                letterList.add((char) (97 - 10 - 32 + i));
            }
        }
        System.out.println(letterList);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                int r = random.nextInt(letterList.size());
                builder.append(letterList.get(r));
            }
            list.add(builder.toString());
            builder.delete(0, builder.length());
        }

        System.out.println(list);

        ArrayList<String> containsNum = new ArrayList<>();
        for (String s : list) {
            if (s.matches(".*\\d.*")) {
                containsNum.add(s);
            }
        }
        System.out.println(containsNum);


    }

}
