package com.xiwen.dataStructures.tree;

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
//        // 前序
//        binaryTree.preOrder();
//        System.out.println("----------------------");
//        // 中序
//        binaryTree.infixOrder();
//        System.out.println("----------------------");
//        // 后序
//        binaryTree.postOrder();

        // 前序查找
        HeroNode heroNode = binaryTree.preOrderSearch(3);
        if (heroNode != null) {
            System.out.println(heroNode);
        } else {
            System.out.println("没有找到节点！");
        }

        // 中序查找
        heroNode = binaryTree.infixOrderSearch(2);
        if (heroNode != null) {
            System.out.println(heroNode);
        } else {
            System.out.println("没有找到节点！");
        }

        // 后序查找
        heroNode = binaryTree.postOrderSearch(5);
        if (heroNode != null) {
            System.out.println(heroNode);
        } else {
            System.out.println("没有找到节点！");
        }

        // 删除前
        System.out.println("删除前");
        binaryTree.preOrder();

        binaryTree.delNode(5);

        System.out.println("删除后");
        binaryTree.preOrder();


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


    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            System.out.println("根节点为空！");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            System.out.println("根节点为空！");
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            System.out.println("根节点为空！");
            return null;
        }
    }

    public void delNode(int no) {
        // 判断root节点是不是no节点如果是就删除，如果不是就递归删除
        if (root != null && root.getNo() == no) {
            root = null;
        } else {
            root.delNode(no);
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

    /**
     * 前序递归查找
     *
     * @param no 查找的编号
     * @return 找到就返回这个节点没找到就返回null
     */
    public HeroNode preOrderSearch(int no) {

        if (this.no == no) {
            return this;
        }

        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }

    /**
     * 中序递归查找
     *
     * @param no 查找的编号
     * @return 找到就返回这个节点没找到就返回null
     */
    public HeroNode infixOrderSearch(int no) {

        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.no == no) {
            return this;
        }


        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }

    /**
     * 后序递归查找
     *
     * @param no 查找的编号
     * @return 找到就返回这个节点没找到就返回null
     */
    public HeroNode postOrderSearch(int no) {

        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }

        if (this.no == no) {
            return this;
        }

        return res;
    }


    /**
     * 删除节点
     * 策略制定: 不考虑删除有子节点的情况下将子节点替换父节点
     * 删除节点思路:
     * 1.先看左节点是不是当前要删除的节点，如果是要删除的就将节点置为null
     * 2.如果右节点是不是要删除的节点，如果是要删除的就将节点置为null
     * 3.上面1、2思路继续向左递归继续执行，如果左节点为空就执行右递归继续执行
     *
     * @param no 要删除的节点
     */
    public void delNode(int no) {

        if (this.left != null && this.left.no == no) {
            this.left = null;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}
