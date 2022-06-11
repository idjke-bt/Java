package com.yang.linkedlist;

/**
 * @author YangFeng
 * @create 2021-07-30 11:08
 */
public class Node {

    int id; //排名
    String name; //名字
    Node next; //下一个元素的地址

    public Node(Node next){
        this.next = next;
    }



    public Node(int id, String name, Node next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
