package com.xiwen.dataStructures.recursion;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/8-16:26
 * @Version: 1.0
 */
public class MiGong {

    public static void main(String[] args) {


        // 用二维数组模拟地图
        int[][] map = new int[8][7];

        // 将上下的墙赋值为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }

        // 左右的墙赋值为1
        for (int i = 0; i < map[0].length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }

        // 中间的两格墙
        map[3][1] = 1;
        map[3][2] = 1;

        // 打印
        for (int i = 0; i < map.length; i++) {
            for (int j : map[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
//        setWay(map, 1, 1); //策略1
        setWay2(map, 1, 1); // 策略2
        System.out.println();
        // 打印
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 使用递归回溯给小球找路
     * 说明
     * 1.map表示地图
     * 2.i，j表示地图的哪个位置开始出发(1,1)
     * 3.如果小球能到map[6][5]位置，则说明通路找到了
     * 4.约定：当map[i][j] 为 0 表示该点没有走过，当为 1 表示墙，2表示路通， 3表示走过不通
     * 5.走迷宫时需要确定一个策略(方法) 下->右->上->左，如果该点走不通，在回溯
     *
     * @param map
     * @param i
     * @param j
     */
    private static boolean setWay(int[][] map, int i, int j) {

        // 如果找到了就返回true
        if (map[6][5] == 2) {
            return true;
        } else {
            // 等于0说明没走过
            if (map[i][j] == 0) {
                // 如果没找到开始按照策略走
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {    // 向下
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上
                    return true;
                } else { // 标记就说明是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 不是0的话就有可能是 1 2 3
                return false;
            }


        }

    }

    /**
     * 改一个策略
     * 使用递归回溯给小球找路
     * 说明
     * 1.map表示地图
     * 2.i，j表示地图的哪个位置开始出发(1,1)
     * 3.如果小球能到map[6][5]位置，则说明通路找到了
     * 4.约定：当map[i][j] 为 0 表示该点没有走过，当为 1 表示墙，2表示路通， 3表示走过不通
     * 5.走迷宫时需要确定一个策略(方法) 上->右->下->左，如果该点走不通，在回溯
     *
     * @param map
     * @param i
     * @param j
     */
    private static boolean setWay2(int[][] map, int i, int j) {

        // 如果找到了就返回true
        if (map[6][5] == 2) {
            return true;
        } else {
            // 等于0说明没走过
            if (map[i][j] == 0) {
                // 如果没找到开始按照策略走
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {    // 向上
                    return true;
                } else if (setWay2(map, i, j + 1)) { //向右
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下
                    return true;
                } else if (setWay2(map, i, j - 1)) { //向左
                    return true;
                } else { // 标记就说明是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 不是0的话就有可能是 1 2 3
                return false;
            }


        }

    }

}
