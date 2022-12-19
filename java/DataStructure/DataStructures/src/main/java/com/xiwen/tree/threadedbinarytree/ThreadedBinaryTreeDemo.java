package com.xiwen.tree.threadedbinarytree;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/19-14:02
 * @Version: 1.0
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        //测武一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建，现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试：以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是=" + leftNode);//3
        System.out.println("10号结点的后继结点是=" + rightNode);//1


    }
}


// 创建二叉树
class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode pro;


    // 重载中序线索化
    public void threadedNodes() {
        threadedNodes(root);
    }

    /**
     * 中序遍历线索树
     *
     * @param node 当前节点
     */
    public void threadedNodes(HeroNode node) {

        // 当前节点不存在
        if (node == null) {
            return;
        }

        // 1.左子树递归线索化
        threadedNodes(node.getLeft());

        // 2.设置前驱 和 后继
        // 设置前驱
        if (node.getLeft() == null) {
            node.setLeft(pro);
            node.setLeftType(1);
        }

        // 设置后继
        if (pro != null && pro.getRight() == null) {
            pro.setRight(node);
            pro.setRightType(1);
        }

        // 注意将当前节点设置为前驱
        pro = node;

        // 3.右子树递归线索化
        threadedNodes(node.getRight());

    }

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

    // leftType 等于 0 时 前序节点是左子树 等于 1 时是前驱节点
    private int leftType;
    // rightType 等于 0 时 前序节点是右子树 等于 1 时是后继节点
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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