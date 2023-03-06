package com.xiwen.homework.homework1.homework4;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-18:56
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        //案例需求：从键盘输入10个单词，并分别统计这些单词中出现过哪些字母和未出现过哪些字母，按字母顺序输出。
        Scanner scanner = new Scanner(System.in);

        TreeSet<Character> characters = new TreeSet<>();
        for (int i = 0; i < 2; i++) {
            System.out.print("请输入第" + (i + 1) + "个单词:");
            String word = scanner.next();
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                characters.add(chars[j]);
            }
        }
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 26; i++) {
            if (!(characters.contains((char) (i + 97)))) {
                linkedHashSet.add((char) (i + 97));
            }
        }
        System.out.println("没出现过的字母:");
        for (Character character : linkedHashSet) {
            System.out.print(character + " ");
        }
        System.out.println(linkedHashSet.size());


        System.out.println();
        System.out.println("出现过的字母:");
        for (Character character : characters) {
            System.out.print(character + " ");
        }
        System.out.println(characters.size());

    }
}
