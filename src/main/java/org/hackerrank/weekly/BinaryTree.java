package org.hackerrank.weekly;

public class BinaryTree {

    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }

    public static void preOrder(Node node) {
        if(node == null)
            return;

        System.out.println(node.data);

        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.data);
    }

    public static void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);

        System.out.println(node.data);

        inOrder(node.right);
    }

    public static void rightToLeftPreOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.data);

        rightToLeftPreOrder(node.right);
        rightToLeftPreOrder(node.left);
    }

}
