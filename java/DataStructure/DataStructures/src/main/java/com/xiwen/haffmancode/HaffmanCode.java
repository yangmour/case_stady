package com.xiwen.haffmancode;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/1/13-15:44
 * @Version: 1.0
 */
public class HaffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();

        List<Node> nodes = getNodes(bytes);

        Node huffmanTreeRoot = createHuffmanTree(nodes);

        huffmanTreeRoot.preOrder();
        getCodes(huffmanTreeRoot,"",new StringBuilder());
        System.out.println(huffmanCode);

    }

    /**
     * 将字符转换为list集合
     *
     * @param bytes 字符数组
     * @return 集合
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;

    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes 节点集合
     * @return 返回根节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {

            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        // 最后一个节点就是根节点
        return nodes.get(0);
    }

    static Map<Byte, String> huffmanCode = new HashMap<>();

    /**
     * 获取赫夫曼编码
     *
     * @param node 节点
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {

        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        // 节点不等于空的时候处理
        if (node != null) {
            // data是空就非叶子节点继续递归处理
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);

                getCodes(node.right, "1", stringBuilder2);
            } else { //是叶子节点就是说明找到最后
                huffmanCode.put(node.data, stringBuilder2.toString());

            }
        }


    }
}

class Node implements Comparable<Node>{
    //存放数据
    Byte data;
    //权值表示字符出现的次数
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }
}



