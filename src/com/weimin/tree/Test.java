package com.weimin.tree;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();

        /*tree.setRoot(5);
        tree.add(4);
        tree.add(7);
        tree.add(6);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(1);
        tree.add(10);
        tree.add(9);*/

        tree.setRoot(10);
        tree.add(11);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        System.out.println(tree.height());

        //tree.midShow();
        //tree.delete(7);

        //tree.midShow();

        //tree.xiansuohua();

        //tree.midShowAfterXiansuohua();


        /*Tree.Node left1 = tree.getRoot().getLeft().getLeft().getLeft().getLeft();
        System.out.println(left1.getRight());
        System.out.println(left1.getRightType());*/


    }
}
