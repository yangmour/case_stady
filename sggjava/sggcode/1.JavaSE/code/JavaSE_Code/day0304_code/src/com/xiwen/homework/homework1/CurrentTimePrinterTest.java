package com.xiwen.homework.homework1;

import java.time.LocalDate;
import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-23:24
 * @Version: 1.0
 */
public class CurrentTimePrinterTest {
    public static void main(String[] args) {

        CurrentTimePrinter currentTimePrinter = ()->System.out.println(System.currentTimeMillis());
        currentTimePrinter.printCurrentTime();

        CurrentTimePrinter currentTimePrinter1 = ()-> System.out.println(new Date());
        currentTimePrinter1.printCurrentTime();
        CurrentTimePrinter currentTimePrinter2 = ()-> System.out.println(LocalDate.now());
        currentTimePrinter2.printCurrentTime();
    }
}
