package com.xiwen.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/02 -23:21
 * @Version: 1.0
 */
public class HorseChessboard {
    private static int x; // 行数
    private static int y; // 列数
    private static boolean[] visited; //已访问记录
    private static boolean success;


    public static void main(String[] args) {
        x = 8;
        y = 8;
        int row = 1;
        int column = 1;
        System.out.println("开始");
        int[][] chessboard = new int[x][y];
        visited = new boolean[x * y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - start) + "毫秒");
        Arrays.stream(chessboard).forEach(o -> System.out.println(Arrays.toString(o)));
    }

    /**
     * 完成骑士周游问题的算法，回溯加贪心
     *
     * @param chessboard 棋盘
     * @param row        行
     * @param column     列
     * @param step       第几步
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //记录已访问
        visited[row * y + column] = true;
        //获取当前位置的下一个位置集合
        ArrayList<Point> next = next(new Point(column, row));
        sort(next);
        while (!next.isEmpty()) {
            //取出下一个可走的节点
            Point point = next.remove(0);
            //没访问过的        5*6 + 2
            if (!visited[point.y * y + point.x]) {
                traversalChessboard(chessboard, point.y, point.x, step + 1);
            }
        }

        //判断是不是完成了
        if (step < x * y && !success) {
            //没完成
            chessboard[row][column] = 0;
            visited[row * y + column] = false;
        } else {
            success = true;
        }
    }

    public static void sort(ArrayList<Point> list) {
        list.sort((o1, o2) -> next(o1).size() - next(o2).size());

    }

    /**
     * 根据当前的为获取下一个可以走的位置
     *
     * @param curPoint 当前坐标
     * @return 返回下一个可以走的下标列表
     */
    public static ArrayList<Point> next(Point curPoint) {

        ArrayList<Point> next = new ArrayList<>();
        Point p = new Point();
        //左 5
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            next.add(new Point(p));
        }
        //左二 6
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            next.add(new Point(p));
        }
        //右二 7
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < y) {
            next.add(new Point(p));
        }

        //右二 0
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < y) {
            next.add(new Point(p));
        }

        //右二 1
        if ((p.x = curPoint.x + 1) < x && (p.y = curPoint.y + 2) < y) {
            next.add(new Point(p));
        }
        //右二 2
        if ((p.x = curPoint.x + 2) < x && (p.y = curPoint.y + 1) < y) {
            next.add(new Point(p));
        }
        //左 3
        if ((p.x = curPoint.x + 2) < x && (p.y = curPoint.y - 1) >= 0) {
            next.add(new Point(p));
        }
        //左 4
        if ((p.x = curPoint.x + 1) < x && (p.y = curPoint.y - 2) >= 0) {
            next.add(new Point(p));
        }
        return next;
    }


}
