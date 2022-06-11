package com.yang.queue;

/**
 * @author YangFeng
 * @create 2021-07-28 10:49
 */
public class CircleQueue {

    int maxSize; //有一个位置不放元素
    private int  front = 0; //指向首元素
    private int  rear = 0; //指向最后一个元素的下一个位置
    private int size = 0;
    private int[] arr;

    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为空
    private boolean isEmpty(){
        return front==rear;
    }

    //判断队列是否已满
    private boolean isFull(){
        return size==maxSize-1;
    }

    //入队
    public void addQueue(int val){
        //1.判断队列是否还能添加元素
        if(isFull()){
            System.out.println("队列已满，无法添加元素！");
            return;
        }

        arr[rear] = val;
        rear = (rear+1)%maxSize;
        size++;
    }

    //出队
    public void deQueue(){
        //1.判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空，无法删除元素！");
        }

        System.out.println("删除元素"+arr[front]);
        front = (front+1)%maxSize;
        size--;

    }

    //遍历所有元素
    public void show(){
        for(int i=front; i!=rear; i=(i+1)%maxSize){
            System.out.println(arr[i]);
        }
    }
}
