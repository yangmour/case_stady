package com.xiwen.tree;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/17-15:26
 * @Version: 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        // 前序
        binaryTree.preOrder();
        System.out.println("----------------------");
        // 中序
        binaryTree.infixOrder();
        System.out.println("----------------------");
        // 后序
        binaryTree.postOrder();


    }
}

// 创建二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("根节点为空！");
        }

    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("根节点为空！");
        }

    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("根节点为空！");
        }

    }


}

// 创建节点类
class HeroNode {
    private int no;
    private String name;

    // 左节点
    private HeroNode left;
    // 右节点
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历 根->左->右
     */
    public void preOrder() {

        System.out.println(this);

        // 左递归
        if (this.left != null) {
            this.left.preOrder();
        }

        // 右递归
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    /**
     * 中序遍历 左->根->右
     */
    public void infixOrder() {
        // 左递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        // 右
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历 左->右->根
     */
    public void postOrder() {
        // 左递归
        if (this.left != null) {
            this.left.postOrder();
        }

        // 右
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);

    }


}
