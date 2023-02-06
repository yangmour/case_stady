package com.xiwen.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:33
 * @Version: 1.0
 */
public class Homework8 {
    public static void main(String[] args) {
        int month = 1;
        int day = 19;
        double md = month + 0.01 * day;

        String sign = null;
        if (month > 12 || month < 1 || day > 31 || day < 0) {
            System.out.println("日期错误！");
        }else if (md <= 2.18 && md >= 1.20) {
            sign = "水瓶座";
        }else if (md <= 3.20 && md >= 2.19) {
            sign = "双鱼座";
        } else if (md <= 4.19 && md >= 3.21) {
            sign = "白羊座";
        } else if (md <= 5.20 && md >= 4.20) {
            sign = "金牛座";
        } else if (md <= 6.21 && md >= 5.21) {
            sign = "双子座";
        } else if (md <= 7.22 && md >= 6.23) {
            sign = "巨蟹座";
        } else if (md <= 8.22 && md >= 7.23) {
            sign = "狮子座";
        } else if (md <= 9.22 && md >= 8.23) {
            sign = "处女座";
        } else if (md <= 10.23 && md >= 9.23) {
            sign = "天秤座";
        } else if (md <= 11.22 && md >= 10.24) {
            sign = "天蝎座";
        } else if (md <= 12.21 && md >= 11.23) {
            sign = "射手座";
        } else if (md <= 12.22 && md >= 1.19) {
            sign = "摩羯座";
        } else {
            sign = "错误";
        }
        System.out.println(sign);
    }
}
