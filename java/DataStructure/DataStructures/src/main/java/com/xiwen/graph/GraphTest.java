package com.xiwen.graph;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -08:32
 * @Version: 1.0
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        for (int i = 1; i <= 8; i++) {
            graph.insertVertex(String.valueOf(i));
        }

        /*for (char i = 'A'; i <= 'E'; i++) {
            graph.insertVertex(String.valueOf(i));
        }*/

        /*graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);*/

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        System.out.println("遍历矩阵");
        graph.showEdges();
        System.out.println("dfs深度优先");
        graph.dfs();
        System.out.println("\nbfs广度优先");
        graph.bfs();
    }
}

class Graph {
    private List<String> vertex;
    private int[][] edges;
    private int numOfEdge;
    private boolean[] isVisited;

    public Graph(int v) {
        vertex = new ArrayList<>();
        edges = new int[v][v];
    }

    /**
     * 添加图的节点
     *
     * @param v
     */
    public void insertVertex(String v) {
        vertex.add(v);
    }

    /**
     * 添加连接节点边
     *
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;

        numOfEdge++;
    }

    /**
     * 查看图矩阵
     */
    public void showEdges() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertex.size();
    }

    /**
     * 返回边数
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdge;
    }

    /**
     * 返回对应下标的数据
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertex.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 查找当前节点的第一个节点的邻接节点
     *
     * @param i 当前节点
     * @return 当前节点的邻接节点值下标
     */
    public int getFirstNeighbor(int i) {
        for (int j = i + 1; j < vertex.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取当前节点的下一个邻接节点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertex.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 递归和当前节点有连接的首个节点,如果首个节点已被访问就找下一个
     *
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        //设置为已访问
        isVisited[i] = true;
        //获取当前节点的下一个节点
        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果已访问过就获取下一个
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 遍历所有图，有可能有无连接图情况
     */
    public void dfs() {
        isVisited = new boolean[vertex.size()];

        for (int i = 0; i < vertex.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先bfs
     *
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited, int i) {
        //当前节点
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        //当前节点入栈
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(i);


        //当前队列不为空说明还有同一级连接边
        while (!linkedList.isEmpty()) {
            //获取队列头
            Integer f = linkedList.removeFirst();
            //获取队列头将下一个第一个节点获取到下标
            int w = getFirstNeighbor(f);
            //如果有下一个节点就进入
            while (w != -1) {
                //如果没有被访问就访问一下输出，标记
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    linkedList.addLast(w);
                }
                //看看同一级下其他节点
                w = getNextNeighbor(f, w);
            }
        }
    }

    //防止无连接图
    public void bfs() {
        isVisited = new boolean[vertex.size()];

        for (int i = 0; i < vertex.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

}
