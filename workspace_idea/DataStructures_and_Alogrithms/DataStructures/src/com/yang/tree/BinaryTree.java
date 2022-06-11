package com.yang.tree;

/**
 * 1.实现二叉树的三种遍历
 *
 * @author YangFeng
 * @create 2021-09-11 11:35
 */
public class BinaryTree {
    Node root;

    public BinaryTree(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root = node1;
        node1.left = node2;
        node1.right = node3;

        node2.left = node5;
        node2.right = node6;

    }

    //先序遍历
    public void preTraverse(){
        System.out.println("先序遍历的结果为：");
        preTraverse(root);
    }

    private void preTraverse(Node root){
        Node temp = root;
        if(temp == null){
            System.out.println("二叉树为空！");
        }

        System.out.print(temp.toString()+"  ");
        if(temp.left!=null){
            preTraverse(temp.left);
        }

        if(temp.right!=null){
            preTraverse(temp.right);
        }
    }

    //中序遍历
    public void inTraverse(){
        System.out.println("中序遍历的结果为：");
        inTraverse(root);
    }

    private void inTraverse(Node root){
        Node temp = root;
        if(temp == null){
            System.out.println("二叉树为空！");
        }

        if(temp.left!=null){
            inTraverse(temp.left);
        }
        System.out.print(temp.toString()+"  ");
        if(temp.right!=null){
            inTraverse(temp.right);
        }
    }

    //后续遍历
    public void postTraverse(){
        System.out.println("后续遍历的结果为：");
        postTraverse(root);
    }

    private void postTraverse(Node root){
        Node temp = root;
        if(temp == null){
            System.out.println("二叉树为空！");
        }

        if(temp.left!=null){
            postTraverse(temp.left);
        }

        if(temp.right!=null){
            postTraverse(temp.right);
        }
        System.out.print(temp.toString()+"  ");
    }

}
