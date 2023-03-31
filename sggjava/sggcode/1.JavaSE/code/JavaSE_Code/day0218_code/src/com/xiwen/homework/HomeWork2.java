package com.xiwen.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/18-14:45
 * @Version: 1.0
 */
public class HomeWork2 {
    public static void main(String[] args) throws ParseException {

        System.out.println("-------1--------");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        String nowStr1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .format(now);
        System.out.println(nowStr1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒 M 是这一年的D天");
        String nowStr2 = now.format(dtf);
        System.out.println(nowStr2);

        System.out.println("---------2--------");

        now = LocalDateTime.now();

        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("America/Chicago"));
        Duration between = Duration.between(now, now2);
        System.out.println(between);
        System.out.println("间隔时间" + between.toHours() + ":" + between.toMillis());


        System.out.println("---------3---------");

        LocalDate date = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入您的生日");
//        System.out.print("年-月-日");
//        String yearMonthDay = scanner.next();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate birthday = LocalDate.from(dateTimeFormatter.parse(yearMonthDay));
//
//        Period between1 = Period.between(date, birthday);
//        System.out.println(between1.getYears() + "年" + between1.getMonths() + "月" + between1.getDays() + "日");

        System.out.println("--------4------------");

        long timeMillis = System.currentTimeMillis();
        System.out.println("请输入出生日期:");
        System.out.print("年-月-日 时:分");
//        scanner.nextLine();
        String yearMonthDayHourM = scanner.nextLine();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("第一种有点麻烦");
        LocalDateTime yearMonthDayHourMForm = LocalDateTime.from(dtf2.parse(yearMonthDayHourM));
        ZonedDateTime zonedDateTime = yearMonthDayHourMForm.atZone(ZoneId.systemDefault());
        long toEpochMilli = zonedDateTime.toInstant().toEpochMilli();
        long l = timeMillis - toEpochMilli;
        System.out.println(l);

        System.out.println("第二种方式");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = simpleDateFormat.parse(yearMonthDayHourM);
        long parseTime = parse.getTime();
        System.out.println(timeMillis - parseTime);


    }
}
