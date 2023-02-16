package com.xiwen.homework.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-20:02
 * @Version: 1.0
 */
public enum Status {

    FREE("空闲"),
    USED("再用"),
    SCRAP("报废");

    final String description;
    final int value = ordinal();

    Status(String description) {
        this.description = description;
    }

    public static Status getByValue(int value) {
        return values()[value];
    }

    @Override
    public String toString() {
        return "Status{" +
                "description='" + description + '\'' +
                '}';
    }
}
