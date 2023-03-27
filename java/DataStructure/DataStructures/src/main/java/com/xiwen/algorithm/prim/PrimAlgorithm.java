package com.xiwen.algorithm.prim;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/27 -08:30
 * @Version: 1.0
 */
public class PrimAlgorithm {
    public static void main(String[] args) {

        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {Integer.MAX_VALUE, 5, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 5, Integer.MAX_VALUE, 6},
                {2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 6, Integer.MAX_VALUE,}
        };
        MGraph mGraph = new MGraph(data.length);
        MinTree minTree = new MinTree();
        minTree.createMGraph(mGraph, data.length, data, weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph, 1);

    }

}

//创建最小生成树，村庄的最短权值路线图
class MinTree {
    /**
     * 创建图的连接矩阵
     */
    public void createMGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        //将权值付给图
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的连接矩阵
    public void showGraph(MGraph graph) {
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //编写prim算法，得到最小生成树
    public void prim(MGraph graph, int n) {

        //用来标记以访问
        int[] visited = new int[graph.verxs];
        //当前节点被访问
        visited[n] = 1;

        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE;

        //因为从第一个节点开始，最短图的路线是n-1个边
        for (int i = 1; i < graph.verxs; i++) {
            //找出每次生成的子图，哪个节点最近
            for (int j = 0; j < graph.verxs; j++) {
                //用于循环所有的连接边
                for (int k = 0; k < graph.verxs; k++) {
                    //找到权值最小的边然后赋值
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值:" + minWeight);
            //将当前这个节点标记为已访问
            visited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }
    }
}

//创建一个图
class MGraph {
    //节点个数
    int verxs;
    //节点数据
    char[] data;
    //存放边
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }


}
