package com.yang.hashtable;

/**
 * 一个员工信息链表
 * @author YangFeng
 * @create 2021-09-10 23:06
 */
public class EmployeeList {
    Node head = new Node(null);

    public EmployeeList(){

    }

    //直接添加到链表后即可
    public void add(int id, String name){
        Node employee = new Node(id, name, null);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = employee;
    }

    //根据id值查找
    public void find(int id){
        Node temp = head.next;
        while (temp!=null && temp.id!=id){
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("不存在该员工");
        }else{
            System.out.println("员工的信息为："+temp.toString());
        }
    }

}
