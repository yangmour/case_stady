package com.xiwen.homework.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-20:08
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String[][] data = Data.EQUIPMENTS;

        Equipment[] equipment = new Equipment[data.length];
        for (int i = 0; i < equipment.length; i++) {
            equipment[i] = new Equipment(Integer.parseInt(data[i][0]), data[i][1], Double.parseDouble(data[i][2]), data[i][3], Status.getByValue(Integer.parseInt(data[i][4])));
            System.out.println(equipment[i]);
        }


    }
}
