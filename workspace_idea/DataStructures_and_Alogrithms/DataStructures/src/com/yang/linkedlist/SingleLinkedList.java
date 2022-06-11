package com.yang.linkedlist;

/**
 * 实现单链表：
 * 1.增：1)直接添加到末端   2)按照排名顺序添加元素
 * 2.改：根据id值修改其他属性
 * 3.删：根据id值删除某个节点
 * 4.查：查找倒数第n个节点的信息
 * 遍历
 *
 * @author YangFeng
 * @create 2021-07-30 11:07
 */
public class SingleLinkedList {
    Node head = new Node(null); //头节点

    public SingleLinkedList(){

    }


    //添加到链表尾端
    public void addNode(int id, String name){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = new Node(id, name, null);

    }

    //有序插入
    public void addNodeByOrder(int id, String name){
        Node left = head;
        Node right = left.next;

        while(right!=null && right.id<=id){
            left = left.next;
            right = right.next;
        }

        left.next = new Node(id, name, right);

    }

    //根据id值修改其他属性
    public void update(int id, String newName){
        Node temp = head.next;
        while(temp!=null){
            if(temp.id == id){
                break;
            }else {
                temp = temp.next;
            }
        }
        if(temp==null){
            System.out.println("没有id为："+id+"的元素");
        }else{
            temp.name = newName;
        }
    }

    //根据id值删除某个节点
    public void delete(int id){
       Node left = head;
       Node right = left.next;

       while (right!=null && right.id!=id){
           left = left.next;
           right = right.next;
       }

       if(right==null){
           System.out.println("没有id为："+id+"的元素");
       }else {
           left.next = right.next;
       }
    }

    //查找倒数第n个节点的信息
    public void findLastIndexNode(int index){
        /*一前一后双指针，中间相差index个位置
        * 最终right会指向null
        * */
        Node left = head;
        Node right = head.next;

        int distance = 1; //表示left和right之间的距离
        while (right!=null && distance<index){
            right = right.next;
            distance++;
        }
        if(right==null && distance<index){
            System.out.println("不存在该节点！");
        }else {
            while (right!=null){
                left = left.next;
                right = right.next;
            }
            System.out.println(left.toString());
        }

    }

    //遍历
    public void show(){
        Node temp = head.next;
        System.out.println("***************");
        while(temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
        System.out.println("***************");
    }
}
