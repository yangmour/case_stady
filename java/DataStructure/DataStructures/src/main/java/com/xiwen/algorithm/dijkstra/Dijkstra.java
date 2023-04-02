package com.xiwen.algorithm.dijkstra;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/02 -21:59
 * @Version: 1.0
 */
public class Dijkstra {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        //表示不可连接
        final int N = 65535;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建图
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();

    }
}

class Graph {
    private char[] vertex;
    private int[][] matrix;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        Arrays.stream(matrix)
                .forEach(m -> System.out.println(Arrays.toString(m)));
    }
}
