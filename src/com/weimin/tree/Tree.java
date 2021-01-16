package com.weimin.tree;

public class Tree {
    // 根节点
    private Node root;

    public void setRoot(int data) {
        this.root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    public Tree() {

    }

    public Tree(int[] array) {

    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        add(data, root);

    }

    private void add(int data, Node root) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                add(data, root.right);
            }
        }

        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                add(data, root.left);
            }
        }

        if (height(root.right) - height(root.left) > 1) {
            leftRotate();
        }

        if (height(root.left) - height(root.right) > 1) {
            rightRotate();
        }
    }

    // 前序遍历
    public void preShow() {
        if (root == null) {
            System.out.println("the tree is empty!");
            return;
        }

        pre(root);

    }

    private void pre(Node root) {
        System.out.println(root.data);
        if (root.left != null) {
            pre(root.left);
        }
        if (root.right != null) {
            pre(root.right);
        }
    }

    // 中序遍历
    public void midShow() {
        if (root == null) {
            System.out.println("the tree is empty!");
            return;
        }
        mid(root);
    }

    private void mid(Node root) {
        if (root.left != null) {
            mid(root.left);
        }

        System.out.println(root.data);

        if (root.right != null) {
            mid(root.right);
        }
    }

    // 后序遍历
    public void behindShow() {
        if (root == null) {
            System.out.println("the tree is empty!");
            return;
        }
        behind(root);
    }

    private void behind(Node root) {
        if (root.left != null) {
            behind(root.left);
        }

        if (root.right != null) {
            behind(root.right);
        }

        System.out.println(root.data);
    }

    // 前序查找

    public Node preFind(int data) {
        if (root == null) {
            System.out.println("the tree is empty!");
            return null;
        }
        int count = 0;
        return preFind(data, root, count);
    }

    private Node preFind(int data, Node root, int count) {
        count = count + 1;
        if (root.data == data) {
            System.out.println("比较了" + count + "次");
            return root;
        }

        Node result = null;

        if (data < root.data && root.left != null) {
            result = preFind(data, root.left, count);
        }
        if (result != null) {
            return result;
        }
        if (data > root.data && root.right != null) {
            result = preFind(data, root.right, count);
        }
        return result;

    }

    // 删除一个节点，如果有子节点也删掉
    public void delete(int data) {
        if (root.data == data) {
            root = null;
            return;
        }
        delete(data, root);
    }

    private void delete(int data, Node root) {
        if (root.left != null && root.left.data == data) {
            root.left = null;
            return;
        }

        if (root.right != null && root.right.data == data) {
            root.right = null;
            return;
        }

        if (root.left != null && data < root.left.data) {
            delete(data, root.left);
        }
        if (root.right != null && data > root.right.data) {
            delete(data, root.right);
        }
    }


    // 顺序存储二叉树 的前序遍历
    public void shunxucunchu(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        shunxucunchu(array, 0);
    }

    private void shunxucunchu(int[] array, int index) {
        System.out.println(array[index]);

        if (2 * index + 1 < array.length) {
            shunxucunchu(array, 2 * index + 1);
        }

        if (2 * index + 2 < array.length) {
            shunxucunchu(array, 2 * index + 2);
        }
    }


    private Node pre = null;

    // 线索化二叉树  中序
    public void xiansuohua() {
        xiansuohua(root);
    }

    private void xiansuohua(Node root) {
        if (root == null) {
            return;
        }
        // 先左
        if (root.left != null) {
            xiansuohua(root.left);
        }

        // 当前的
        if (root.left == null) {
            // 当前节点的左指针指向前驱
            root.left = pre;
            root.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = root;
            pre.rightType = 1;
        }
        // !!
        pre = root;

        // 后右
        if (root.right != null) {
            xiansuohua(root.right);
        }
    }

    // 中序 线索化后的遍历
    public void midShowAfterXiansuohua() {
        midShowAfterXiansuohua(root);
    }

    private void midShowAfterXiansuohua(Node root) {
        Node node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node.data);

            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node.data);
            }
            node = node.right;
        }

    }


    // 返回整个树的高度
    public int height() {
        return height(root);
    }

    // 返回以这个节点为根节点的树的高度
    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.left == null ? 0 : height(root.left), root.right == null ? 0 : height(root.right)) + 1;
    }

    // 平衡二叉树 左旋
    private void leftRotate() {
        Node node = new Node(root.data);
        node.left = root.left;
        node.right = root.right.left;

        root.data = root.right.data;
        root.right = root.right.left;
        root.left = node;
    }

    // 平衡二叉树 右旋
    private void rightRotate() {
        Node node = new Node(root.data);
        node.right = root.right;
        node.left = root.left.right;

        root.data = root.left.data;
        root.left = root.left.left;
        root.right = node;
    }


    static class Node {
        private int data;
        private Node left;
        private Node right;

        // 0 表示正常的左右子树
        // 1 表示前驱或者后继
        private int leftType;
        private int rightType;


        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {

    }
}
