package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-18:18
 * @Version: 1.0
 */
public class HomeWork2 {
    public static void main(String[] args) {

        /**
         * 案例需求：遍历输出一副扑克牌。
         * 开发提示：
         * （1）用第一个数组保存扑克牌的所有花色：黑桃、红桃、梅花、方片
         * String[] hua = {"黑桃","红桃","梅花","方片"};
         * （2）用第二个数组保存具有以上花色的数字：2-K
         * String[] dian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
         * （3）用第三个数组保存扑克牌的牌面
         * String[] pu = new String[hua.length*dian.length+2];
         * （4）嵌套遍历第1个、第2个数组，排列组合生成扑克牌牌面，并把结果放到第3个数组的元素中
         * （5）单独考虑大王小王
         * （6）遍历输出
         */

        String[] hua = {"黑桃", "红桃", "梅花", "方片"};
        String[] dian = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] pu = new String[hua.length * dian.length + 2];
        int k = 0;
        for (int i = 0; i < hua.length; i++) {
            for (int j = 0; j < dian.length; j++, k++) {
                pu[k] = hua[i] + dian[j];
            }

        }

        pu[k] = "大王";
        pu[++k] = "小王";

        for (String str : pu) {
            System.out.print(str);
            if (str.contains("K")) {
                System.out.println();
            }
        }


    }
}
