package com.yang.linkedlist;

/**
 * 约瑟夫问题
 * 一共Nums个节点，从Start开始报数，报数到M的人出局
 *
 * @author YangFeng
 * @create 2021-08-01 9:44
 */
public class JosephuCircle {

    CircleNode head = new CircleNode(1,null);
    int nums;
    int start;
    int m;

    //一共Nums个节点，从Start开始报数，报数到M的人出局
    public JosephuCircle(int nums, int start, int m){
        CircleNode temp = head;
        for(int i = 2; i<= nums; i++){
            temp.next = new CircleNode(i, null);
            temp = temp.next;
        }
        temp.next = head;

        this.nums = nums;
        this.start = start;
        this.m = m;
    }

    //一共Nums个节点，从Start开始报数，报数到M的人出局
    public void game(){
        //1.选定开始节点
        CircleNode temp = head;
        for(int i=1; i<start; i++){
            temp = temp.next;
        }

        int count = 1; //报数
        while (nums > 1){ //只要链表中的元素数量大于1，循环就继续
            temp = temp.next;
            count++;

            if(count==m){
                this.delete(temp);
                System.out.println(temp.toString());
                temp = temp.next;
                count = 1;
            }
        }

        System.out.println("最后的节点为："+ temp.toString());


    }

    //删除节点
    public void delete(CircleNode node){
        CircleNode temp = head;
        int cnt = 0;
        for(int i = 0; i< nums; i++){
            if(temp.next.equals(node)){
                temp.next = temp.next.next;
                cnt = 1;
                break;
            }
            temp = temp.next;
        }

        if(cnt==0){
            System.out.println("链表中没有该节点！");
        }else {
            //如果删除的是第一个节点
            if(head.equals(node)){
                head = head.next;
            }
            nums--;
        }
    }

    //遍历
    public void show(){
        CircleNode temp = head;
        for(int i = 0; i< nums; i++){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

}

