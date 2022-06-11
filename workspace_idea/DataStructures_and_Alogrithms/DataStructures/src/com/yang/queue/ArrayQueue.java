package com.yang.queue;

/**
 * 用数组实现队列
 *
 * @author YangFeng
 * @create 2021-07-28 10:02
 */
public class ArrayQueue {

    int maxSize;
    private int  front = -1; //指向首元素的前一个位置
    private int  rear = -1; //指向最后一个元素
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为空
    private boolean isEmpty(){
        return front==rear;
    }

    //判断队列是否已满
    private boolean isFull(){
        return rear==maxSize-1;
    }

    //入队
    public void addQueue(int val){
        //1.判断队列是否还能添加元素
        if(isFull()){
            System.out.println("队列已满，无法添加元素！");
            return;
        }

        arr[++rear] = val;
    }

    //出队
    public int deQueue() throws RuntimeException{
        //1.判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空，无法删除元素！");
            throw new RuntimeException("队列为空，无法删除元素！");
        }

        System.out.println("删除成功");
        return arr[++front];

    }

    //遍历所有元素
    public void show(){
        for(int i=front+1; i<=rear; i++){
            System.out.println(arr[i]);
        }
    }
}
