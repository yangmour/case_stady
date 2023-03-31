package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-19:01
 * @Version: 1.0
 */
public class HomeWork2 {

    public static void main(String[] args) {
        int year = 2000;
        if (isLeapYear(year)) {
            System.out.println("是闰年！");
        } else {
            System.out.println("不是闰年！");
        }

        int month = 2;
        System.out.println(monthName(month));

        int day = totalDaysOfMonth(year, month);
        System.out.println("day = " + day);

        int yearDay = totalDaysOfYear(year);
        System.out.println("yearDay = " + yearDay);

        day = 10;
        int daysOfTheYear = daysOfTheYear(year, month, day);
        System.out.println("daysOfTheYear = " + daysOfTheYear);

    }

    private static int daysOfTheYear(int year, int month, int day) {
        int result = 0;
        switch (month - 1) {
            case 12:
                result += 31;
            case 11:
                result += 30;
            case 10:
                result += 31;
            case 9:
                result += 30;
            case 8:
                result += 31;
            case 7:
                result += 31;
            case 6:
                result += 30;
            case 5:
                result += 31;
            case 4:
                result += 30;
            case 3:
                result += 31;
            case 2:
                result += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
            case 1:
                result += 31;
            default:
                result += day;
        }
        return result;
    }

    private static int totalDaysOfYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 366 : 365;
    }

    private static int totalDaysOfMonth(int year, int month) {
        int result = 0;
        switch (month) {
            case 12:
            case 10:
            case 8:
            case 7:
            case 5:
            case 3:
            case 1:
                result = 31;
                break;
            case 11:
            case 9:
            case 6:
            case 4:
                result = 30;
                break;
            case 2:
                result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
                break;
        }
        return result;
    }

    private static String monthName(int month) {
        String monthStr = null;
        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            default:
                System.out.println("输入错误！");
                System.exit(0);
        }
        return monthStr;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }


}
