package com.xiwen.algorithm.kruskal;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -21:00
 * @Version: 1.0
 */
public class KruskalCase {
    private int edgeNum; // 节点个数
    private char[] vertexs; // 定点个数
    private int[][] matrix; // 邻接矩阵
    // 表示两点没有连通
    private final static Integer INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};// 克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                ///// *A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /* A */{0, 12, INF, INF, INF, 16, 14},
                /* B */{12, 0, 10, INF, INF, 7, INF},
                /* C */{INF, 10, 0, 3, 5, 6, INF},
                /* D */{INF, INF, 3, 0, 4, INF, INF},
                /* E */{INF, INF, 5, 4, 0, 2, 8},
                /* F */{16, 7, 5, 6, INF, 0, 9},
                /* F */{14, INF, INF, INF, 8, 9, 0},
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.showMatrix();

        //生成
        EData[] edges = kruskalCase.getEdges();
        //排序
        kruskalCase.sortEdges(edges);
        System.out.println("排序");
        System.out.println("edges = " + Arrays.toString(edges));
        //最小生成树
        EData[] kruskal = kruskalCase.kruskal();
        System.out.println("生成");
        Arrays.stream(kruskal).forEach(System.out::println);
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        // 拷贝
        this.vertexs = new char[vertexs.length];
        this.matrix = new int[matrix.length][matrix[0].length];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vertexs.length);
        System.arraycopy(matrix, 0, this.matrix, 0, matrix.length);

        int length = vertexs.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 按权值排序
     */
    public void sortEdges(EData[] eDatas) {
        for (int i = 1; i < eDatas.length; i++) {

            boolean f = true;
            for (int j = 0; j < eDatas.length - i; j++) {
                if (eDatas[j].weight > eDatas[j + 1].weight) {
                    EData temp = eDatas[j];
                    eDatas[j] = eDatas[j + 1];
                    eDatas[j + 1] = temp;
                    f = false;
                }
            }
            if (f) {
                break;
            }
        }
    }

    /**
     * 获取值
     *
     * @return
     */
    public EData[] getEdges() {
        int index = 0;
        EData[] eDatas = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    eDatas[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return eDatas;
    }

    public EData[] kruskal() {

        int index = 0;
        int[] ends = new int[edgeNum];

        //获取
        EData[] edges = getEdges();
        //排序
        sortEdges(edges);
        //存放连接点
        EData[] temp = new EData[edgeNum];

        //去遍历权值
        for (int i = 0; i < edges.length; i++) {
            //获取第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第二个顶点
            int p2 = getPosition(edges[i].end);

            //获取第一个顶点的终点
            int m = getEnd(ends, p1);
            //获取第二个顶点的终点
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                temp[index++] = edges[i];

            }
        }
        return Arrays.stream(temp).filter(o -> o != null).toArray(EData[]::new);
    }

    /**
     * 获取最后一个顶点
     *
     * @param ends
     * @param index
     * @return
     */
    private int getEnd(int[] ends, int index) {

        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }

    /**
     * 获取顶点的下标
     *
     * @param c
     * @return
     */
    private int getPosition(char c) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == c) {
                return i;
            }
        }
        return -1;
    }

}

class EData {

    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }

}