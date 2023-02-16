package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-19:51
 * @Version: 1.0
 */
public enum Color {
    RED(255, 0, 0, "赤"),
    ORANGE(255, 128, 0, "橙"),
    YELLOW(255, 255, 0, "黄"),
    GREEN(0, 255, 0, "绿"),
    CYAN(0, 255, 255, "青"),
    BLUE(0, 0, 255, "蓝"),
    PURPLE(128, 0, 255, "紫");
    final int red;
    final int green;
    final int blue;
    final String description;

    Color(int red, int green, int blue, String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString() {
        return name() + "(" + red + "," + green + "," + blue + ")->" + description;
    }
}
class ColorTest{
    public static void main(String[] args) {

        System.out.println(Color.GREEN);
    }
}