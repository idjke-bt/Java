package com.yang.hashtable;

import java.util.List;

/**
 * 实现hashTable
 *
 * @author YangFeng
 * @create 2021-09-10 22:59
 */
public class HashTable {

    static EmployeeList[] ListArr = new EmployeeList[8];

    public HashTable(){
        for(int i=0; i<ListArr.length; i++){
            ListArr[i] = new EmployeeList();
        }
    }

    //直接添加到对应列表的尾端
    public void add(int id, String name){
        int index = hash(id);
        ListArr[index].add(id,name);
    }

    //根据id值查找
    public void find(int id){
        int index = hash(id);
        ListArr[index].find(id);
    }

    //散列函数
    private int hash(int id){
        return id % ListArr.length;
    }

    //遍历
    public void show(){
        for(int i=0; i<ListArr.length; i++){
            for(Node n=ListArr[i].head.next; n!=null; n=n.next){
                System.out.print(n.toString()+"@@@");
            }
            System.out.println();
        }
    }

}
