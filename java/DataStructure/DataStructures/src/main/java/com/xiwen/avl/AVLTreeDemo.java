package com.xiwen.avl;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/19 -14:18
 * @Version: 1.0
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};

        AVLTree avlTree = new AVLTree();
        for (int num : arr) {
            avlTree.add(new Node(num));
        }

        avlTree.fixOrder();
        System.out.println("当前数的高度:" + avlTree.getRoot().height());
        System.out.println("左子树的高度" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度" + avlTree.getRoot().rightHeight());

    }

}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 找到父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 找出右子树中最小的节点返回并删除
     *
     * @param node
     * @return
     */
    public int delRightMin(Node node) {
        Node temp = node;
        if (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 找出右子树中最小的节点返回并删除
     *
     * @param node
     * @return
     */
    public int delLeftMax(Node node) {
        Node temp = node;
        if (temp.right != null) {
            temp = temp.right;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 删除节点
     *
     * @param value 值
     */
    public void delNode(int value) {
        //分为三种情况

        if (root == null) {
            return;
        } else {
            Node targetSearch = search(value);
            if (targetSearch == null) {
                return;
            }
            //只有根节点情况
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找targetNode的父节点
            Node searchParent = searchParent(value);
            //情况一删除叶子节点
            if (targetSearch.left == null && targetSearch.right == null) {
                if (searchParent.left != null && searchParent.left.value == value) {
                    searchParent.left = null;
                } else if (searchParent.right != null && searchParent.right.value == value) {
                    searchParent.right = null;
                }
            } else if (targetSearch.left != null && targetSearch.right != null) { //有两颗子树节点
//                int i = delRightMin(targetSearch.right);
//                targetSearch.value = i;


                int i1 = delLeftMax(targetSearch.left);
                targetSearch.value = i1;
            } else { //有一颗子树节点
                if (targetSearch.left != null) {
                    if (searchParent.left.value == value) {
                        searchParent.left = targetSearch.left;
                    } else {
                        searchParent.right = targetSearch.left;
                    }
                } else {
                    if (searchParent.left.value == value) {
                        searchParent.left = targetSearch.right;
                    } else {
                        searchParent.right = targetSearch.right;
                    }
                }

            }
        }
    }


    public void fixOrder() {
        if (root == null) {
            System.out.println("没有根节点");
        }
        root.fixOrder();
    }
}

//二叉树节点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 左旋转
     */
    public void leftRotate() {
        //创建一个新节点
        Node newNode = new Node(value);
        //新节点的左节点等于当前节点的左节点
        newNode.left = left;
        //当前节点的值等于当前节点的右节点的值
        value = this.right.value;
        //当前右节点等于右节点的右节点
        right = right.right;
        //当前节点的值等于左节点
        this.left = newNode;
    }

    public void rightRotate() {
        //创建一个新节点
        Node newNode = new Node(value);
        //新节点的左节点等于当前节点的左节点
        newNode.right = right;
        //将当前节点的值等于当前节点的左节点的值
        value = left.value;
        //将当前左节点节点赋值为左节点的左节点
        left = left.left;
        //将当前右节点的值等于右节点
        right = newNode;
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }

        // 小于放左边
        if (node.value < this.value) {
            if (left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else { //大于等于的都放右边
            if (right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 双旋转
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate(); // 先右旋转
            }
            //在左旋转
            leftRotate();
        } else if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate(); //先左旋转
            }
            //在右旋转
            rightRotate();
        }


    }

    //查找要删除的节点
    public Node search(int value) {
        //1.考虑只有叶子节点
        if (value == this.value) {
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {

        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else return null;
        }
    }


    public void fixOrder() {

        if (left != null) {
            left.fixOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.fixOrder();
        }

    }
}