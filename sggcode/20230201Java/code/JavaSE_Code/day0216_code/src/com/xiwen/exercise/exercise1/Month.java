package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-15:53
 * @Version: 1.0
 */
public enum Month {

    JANUARY("一月"), FEBRUARY("二月"), MARCH("三月"), APRIL("四月"), MAY("五月"), JUNE("六月"), JULY("七月"), AUGUST("八月"), SEPTEMBER("九月"), OCTOBER("十月"), NOVEMBER("十一月"), DECEMBER("十二月");
    private final String description;

    Month(String description) {
        this.description = description;
    }

    public static Month getByValue(int value) {
        if (value > 0 && value <= 12) {
            return Month.values()[value - 1];
        }
        return null;
    }

    public int length(boolean leapYear) {
        switch (this) {
            case FEBRUARY:
                return leapYear ? 29 : 28;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;
            default:
                return 31;

        }
    }

    @Override
    public String toString() {
        return ordinal() + 1 + "->" + name() + "->" + description;
    }
}
