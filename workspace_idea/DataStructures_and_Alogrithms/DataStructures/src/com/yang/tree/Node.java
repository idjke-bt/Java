package com.yang.tree;

/**
 * 二叉树节点
 * @author YangFeng
 * @create 2021-09-11 11:39
 */
public class Node {
    int data;

    Node left;
    Node right;

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
