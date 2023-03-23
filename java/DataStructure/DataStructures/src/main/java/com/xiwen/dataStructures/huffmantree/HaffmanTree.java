package com.xiwen.dataStructures.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/26-14:39
 * @Version: 1.0
 */
public class HaffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTreeRoot = createHuffmanTree(arr);

        preOrder(huffmanTreeRoot);


    }

    private static void preOrder(Node huffmanTreeRoot) {
        if (huffmanTreeRoot != null) {
            huffmanTreeRoot.preOrder();
        } else {
            System.out.println("根节点为空");
        }

    }


    /**
     * 创建赫夫曼树
     *
     * @param arr 需要将数组转换为哈夫曼数
     */
    public static Node createHuffmanTree(int[] arr) {

        // 创建一个集合存储节点
        List<Node> nodeList = new ArrayList<>();
        // 将数组转换为节点集合
        for (int num : arr) {
            nodeList.add(new Node(num));
        }

        while (nodeList.size() > 1) {

            // 将数组排序
            Collections.sort(nodeList);
            // 测试排序
//        System.out.println(nodeList);

            // 取出权值最小的两个值
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);

            // 创建一个父节点组成二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // 将上面处理过的两个最小值节点删除，将父节点添加到集合
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);

            nodeList.add(parent);
        }

        return nodeList.get(0);
    }

}

/**
 * 创建节点类
 * 让node对象持续排序Collections集合排序
 * 实现Comparable接口
 */
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}