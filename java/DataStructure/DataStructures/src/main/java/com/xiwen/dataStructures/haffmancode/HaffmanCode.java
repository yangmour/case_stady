package com.xiwen.dataStructures.haffmancode;

import java.io.*;
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

        String src = "data/huffmanData/第二章 HTML&CSS.md";
        String dst = "data/huffmanData/第二章 HTML&CSS.md.zip";
        zipFile(src, dst);
        System.out.println("压缩完成");

        src = "data/huffmanData/第二章 HTML&CSS.md.zip";
        dst = "data/huffmanData/第二章 HTML&CSS2.md";
        unZipFile(src, dst);
        System.out.println("解压完成");
       /* String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();

        // 封装的方法实验
        byte[] zipRes = huffmanZip(bytes);
        System.out.println("压缩数据显示" + Arrays.toString(zipRes));

        byte[] decode = decode(huffmanCode, zipRes);
        System.out.println("解码后的字符" + new String(decode));*/

        /**
         * 分解步骤的实验
         */
//
//        List<Node> nodes = getNodes(bytes);
//
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//
//        huffmanTreeRoot.preOrder();
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//        System.out.println("霍夫曼编码" + huffmanCodes);
//
//        byte[] huffmanCodeZipBytes = zip(bytes, huffmanCodes);
//        System.out.println(Arrays.toString(huffmanCodeZipBytes));


    }

    /**
     * 文件解压
     *
     * @param src 源文件
     * @param dst 目标文件路径
     */
    public static void unZipFile(String src, String dst) {
        ObjectInputStream ois = null;
        OutputStream os = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(src));
            byte[] srcBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCode = (Map<Byte, String>) ois.readObject();
            byte[] decode = decode(huffmanCode, srcBytes);
            os = new FileOutputStream(dst);
            os.write(decode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 文件压缩
     *
     * @param src 源文件
     * @param dst 目标文件路径
     */
    public static void zipFile(String src, String dst) {

        InputStream is = null;
        ObjectOutputStream oos = null;

        try {
            is = new FileInputStream(src);
            oos = new ObjectOutputStream(new FileOutputStream(dst));

            byte[] srcBytes = new byte[is.available()];
            is.read(srcBytes);

            byte[] dstBytes = huffmanZip(srcBytes);
            //将压缩数据存入文件
            oos.writeObject(dstBytes);
            //将编码格式存入方便解压
            oos.writeObject(huffmanCode);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 解码
     *
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes 赫夫曼编码的得到的字节数组
     * @return 返回原来正确的字符串数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 将每为二进制数添加到builder中
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 最后一位的编码有可能不是八位
            boolean flag = (i == huffmanBytes.length - 1);
            builder.append(byteToBitString(!flag, b));
        }
        //
        Byte b = huffmanBytes[huffmanBytes.length - 1];
        String lastByteStr = byteToBitString(false, b);
        if (builder.length() + lastByteStr.length() == stringBuilder.length()) {
            builder.append(lastByteStr);
        } else {
            while (builder.length() + lastByteStr.length() < stringBuilder.length()) {
                builder.append(0);
            }
            builder.append(lastByteStr);
        }


        // 将编码进行解码操作
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        // 创建一个集合存放byte
        List<Byte> list = new ArrayList<>();

        //扫描stringBuilder
        for (int i = 0; i < builder.length(); ) {
            int count = 1;
            boolean flag = true;
            b = null;

            while (flag && (i + count) <= builder.length()) {
                String key = builder.substring(i, i + count);
                b = map.get(key);

                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            if (b == null) {
                b = '0';
            }
            i += count;
            list.add(b);

        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;

    }

    // 将压缩的字符转换为byte编码字符串
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256; // 取模，当是正数的时候需要填充几位进行取模
        }

        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }


    }

    /**
     * 赫夫曼编码压缩封装
     *
     * @param bytes 元字符
     * @return 返回压缩的字符数组
     */
    private static byte[] huffmanZip(byte[] bytes) {

        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        byte[] zipRes = zip(bytes, codes);
        return zipRes;
    }


    /**
     * 赫夫曼树的字符压缩
     *
     * @param bytes        原始字符
     * @param huffmanCodes 原始字符的编码
     * @return 返回的是压缩字符数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
//        System.out.println("编码数据:" + stringBuilder);

        //进行压缩
        int len;
        // 或者直接写成 (stringBuilder.length + 7)/8
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        // 存放压缩的数据
        int index = 0;
        byte[] zipRes = new byte[len];

        for (int i = 0; i < stringBuilder.length(); i += 8) {
            // 防止越界
            String stringByte;
            if (i + 8 > stringBuilder.length()) {
                stringByte = stringBuilder.substring(i);

            } else {
                stringByte = stringBuilder.substring(i, i + 8);
            }
            zipRes[index++] = (byte) Integer.parseInt(stringByte, 2);
        }

        return zipRes;
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
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", new StringBuilder());

        getCodes(root.right, "1", new StringBuilder());

        return huffmanCode;

    }

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

class Node implements Comparable<Node> {
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



