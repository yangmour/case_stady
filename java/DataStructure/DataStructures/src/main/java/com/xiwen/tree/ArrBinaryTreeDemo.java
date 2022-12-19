package com.xiwen.tree;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/19-12:07
 * @Version: 1.0
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        System.out.println("前序遍历");
        arrBinaryTree.preOrder(0);
        System.out.println();

        System.out.println("中序遍历");
        arrBinaryTree.infixOrder(0);
        System.out.println();
        System.out.println("后序遍历");
        arrBinaryTree.postOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 编写一个方法完成顺序存储二叉树的前序遍历
     *
     * @param index 从根开始 下标为0
     */
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉数的前序遍历！");
            return;
        }

        // 先从 根 -> 左 -> 右
        // 根
        System.out.print(arr[index] + " ");
        // 左
        if ((index * 2 + 1) < arr.length) {
            preOrder((index * 2 + 1));
        }
        // 右
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 编写一个方法完成顺序存储二叉树的中序遍历
     *
     * @param index 从根开始 下标为0
     */
    public void infixOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉数的前序遍历！");
            return;
        }

        // 先从 左 -> 根 -> 右
        // 左
        if ((index * 2 + 1) < arr.length) {
            infixOrder((index * 2 + 1));
        }
        // 根
        System.out.print(arr[index] + " ");
        // 右
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    /**
     * 编写一个方法完成顺序存储二叉树的后序遍历
     *
     * @param index 从根开始 下标为0
     */
    public void postOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉数的前序遍历！");
            return;
        }

        // 先从 左 -> 根 -> 右
        // 左
        if ((index * 2 + 1) < arr.length) {
            postOrder((index * 2 + 1));
        }
        // 右
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        // 根
        System.out.print(arr[index] + " ");

    }


}
