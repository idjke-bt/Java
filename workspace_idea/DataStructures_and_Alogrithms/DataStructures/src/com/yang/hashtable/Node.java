package com.yang.hashtable;

/**
 * 每个节点都是员工的个人信息
 * @author YangFeng
 * @create 2021-09-10 23:01
 */
public class Node {
    int id;
    String name;
    Node next;

    public Node(){

    }

    public Node(Node next){
        this.next = next;
    }

    public Node(int id, String name, Node next){
        this.id = id;
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name= " + name +
                '}';
    }
}
