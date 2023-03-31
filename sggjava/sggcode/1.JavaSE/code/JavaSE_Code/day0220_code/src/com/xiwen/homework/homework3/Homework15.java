package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:50
 * @Version: 1.0
 */
public class Homework15 {
    public static void main(String[] args) {

        /**
         * 案例需求：
         * 假设日期段用两个6位长度的正整数表示，
         * 例如：(201401，201406)用来表示2014年1月到2014年6月，求两个日期段的重叠月份数。
         * 例如：输入：时间段1：201401和201406，时间段2：201403和201409，输出：4
         * 解释：重叠月份：3,4,5,6月共4个月
         */

        //情景一不考虑年份的
//        String date1Start = "201401";
//        String date1End = "201406";
//
//        String date2Start = "201403";
//        String date2End = "201409";
//
//        int date1StartI = Integer.parseInt(date1Start.substring(4));
//        int date1EndI = Integer.parseInt(date1End.substring(4));
//        int date2StartI = Integer.parseInt(date2Start.substring(4));
//        int date2EndI = Integer.parseInt(date2End.substring(4));
//
//
//        int start = Math.max(date1StartI, date2StartI);
//        int end = Math.min(date1EndI, date2EndI);
//
//        System.out.println("重叠的月份数:" + (end - start + 1));
//        for (int i = start; i <= end; i++) {
//            System.out.print(i + " ");
//        }

        //情景二不考虑年份的
        String date1Start = "201301";
        String date1End = "201406";

        String date2Start = "201403";
        String date2End = "201409";

//        String date1 = handleDate(date1Start, date1End);
//        String date2 = handleDate(date2Start, date2End);
//
//        System.out.println(date1);
//        System.out.println(date2);
//
//        String sameDate = findMaxSubString(date1, date2);
//
//        System.out.println("重叠的月份数：" + sameDate.length() / 6);
//        if (!"".equals(sameDate)) {
//            System.out.println("重叠的月份有：");
//            while (sameDate.length() > 0) {
//                String sameMonth = sameDate.substring(0, 6);
//                System.out.println(sameMonth);
//                sameDate = sameDate.substring(6);
//            }
//
//        }

        String date1 = handleDate2(date1Start, date1End);
        String date2 = handleDate2(date2Start, date2End);

        System.out.println(date1);
        System.out.println(date2);

        String sameDate = findMaxSubString2(date1, date2);

        System.out.println("重叠的月份数：" + sameDate.length() / 6);
        if (!"".equals(sameDate)) {
            System.out.println("重叠的月份有：");
            while (sameDate.length() > 0) {
                String sameMonth = sameDate.substring(0, 6);
                System.out.println(sameMonth);
                sameDate = sameDate.substring(6);
            }

        }


    }

    private static String findMaxSubString2(String date1, String date2) {

        String res = "";

        String max = date1.length() > date2.length() ? date1 : date2;
        String min = date1.length() < date2.length() ? date1 : date2;


//        //外循环控制从左到右的下标，内循环控制从右到左的下标
//        for (int i = 0; i < min.length(); i += 6) {
//            for (int j = min.length(); j >= i; j -= 6) {
//                String str = min.substring(i, j);
//                if (max.contains(str)) {
//                    //找出最大相同子串
//                    if (res.length() < str.length()) {
//                        res = str;
//                    }
//                }
//            }
//        }

        for (int i = 0; i < min.length(); i += 6) {
            for (int j = min.length(); j >= i; j -= 6) {
                String sub = min.substring(i, j);
                if (max.contains(sub)) {
                    if (res.length() < sub.length()) {
                        res = sub;
                    }
                }
            }
        }
        return res;
    }

    private static String handleDate2(String date1Start, String date1End) {

        int dateStartYear = Integer.parseInt(date1Start.substring(0, 4));
        int dateEndYear = Integer.parseInt(date1End.substring(0, 4));

        int dateStartMonth = Integer.parseInt(date1Start.substring(4));
        int dateEndMonth = Integer.parseInt(date1End.substring(4));

        String res = "";
        //是同一年
        if (dateStartYear == dateEndYear) {
            for (int i = dateStartMonth; i <= dateEndMonth; i++) {
                if (i < 10) {
                    res += dateStartYear + "0" + i;
                } else {
                    res += dateStartYear + "" + i;
                }
            }

        } else { // 多个年份

            //第一年
            for (int i = dateStartMonth; i <= 12; i++) {
                if (i < 10) {
                    res += dateStartYear + "0" + i;
                } else {
                    res += dateStartYear + "" + i;
                }
            }

            // 中间的年

            for (int i = dateStartYear + 1; i < dateEndYear; i++) {
                for (int j = 1; j <= 12; j++) {
                    if (j < 10) {
                        res += dateStartYear + "0" + j;
                    } else {
                        res += dateStartYear + "" + j;
                    }
                }
            }


            //最后一年
            for (int i = 1; i <= dateEndMonth; i++) {
                if (i < 10) {
                    res += dateEndYear + "0" + i;
                } else {
                    res += dateEndYear + "" + i;
                }
            }

        }

        return res;
    }

    public static String findMaxSubString(String str1, String str2) {
        String result = "";

        String mixStr = str1.length() < str2.length() ? str1 : str2;
        String maxStr = str1.length() > str2.length() ? str1 : str2;

        //外循环控制从左到右的下标，内循环控制从右到左的下标
        for (int i = 0; i < mixStr.length(); i += 6) {
            for (int j = mixStr.length(); j >= i; j -= 6) {
                String str = mixStr.substring(i, j);
                if (maxStr.contains(str)) {
                    //找出最大相同子串
                    if (result.length() < str.length()) {
                        result = str;
                    }
                }
            }
        }
        return result;
    }

    public static String handleDate(String dateStart, String dateEnd) {
        int dateStartYear = Integer.parseInt(dateStart.substring(0, 4));
        int dateEndYear = Integer.parseInt(dateEnd.substring(0, 4));
        int dateStartMonth = Integer.parseInt(dateStart.substring(4));
        int dateEndMonth = Integer.parseInt(dateEnd.substring(4));

        String date = "";
        if (dateStartYear == dateEndYear) {//一年之内
            for (int i = dateStartMonth; i <= dateEndMonth; i++) {
                if (i < 10) {
                    date += dateStartYear + "0" + i;
                } else {
                    date += dateStartYear + "" + i;
                }
            }
        } else {//跨年
            for (int i = dateStartMonth; i <= 12; i++) {//date1StartYear起始年
                if (i < 10) {
                    date += dateStartYear + "0" + i;
                } else {
                    date += dateStartYear + "" + i;
                }
            }
            for (int i = dateStartYear + 1; i < dateEndYear; i++) {//中间间隔年
                for (int j = 1; j <= 12; j++) {
                    if (j < 10) {
                        date += i + "0" + j;
                    } else {
                        date += i + "" + j;
                    }
                }
            }
            for (int i = 1; i <= dateEndMonth; i++) {//date1EndYear结束年
                if (i < 10) {
                    date += dateEndYear + "0" + i;
                } else {
                    date += dateEndYear + "" + i;
                }
            }
        }
        return date;
    }
}
