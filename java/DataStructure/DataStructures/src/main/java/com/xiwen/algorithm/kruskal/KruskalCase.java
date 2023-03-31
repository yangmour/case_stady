package com.xiwen.algorithm.kruskal;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -21:00
 * @Version: 1.0
 */
public class KruskalCase {
    private int edgeNum; //节点个数
    private char[] vertexs; //定点个数
    private int[][] matrix; //邻接矩阵
    //表示两点没有连通
    private final static Integer INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /////*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{0, 12, INF, INF, INF, 16, 14},
                /*B*/{12, 0, 10, INF, INF, 7, INF},
                /*C*/{INF, 10, 0, 3, 5, 6, INF},
                /*D*/{INF, INF, 3, 0, 4, INF, INF},
                /*E*/{INF, INF, 5, 4, 0, 2, 8},
                /*F*/{16, 7, 5, 6, INF, 0, 9},
                /*F*/{14, INF, INF, INF, 8, 9, 0},
        };
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.showMatrix();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //拷贝
        this.vertexs = new char[vertexs.length];
        this.matrix = new int[matrix.length][matrix[0].length];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vertexs.length);
        System.arraycopy(matrix, 0, this.matrix, 0, matrix.length);

        int length = vertexs.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
