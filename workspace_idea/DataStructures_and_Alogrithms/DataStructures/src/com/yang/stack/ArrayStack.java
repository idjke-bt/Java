package com.yang.stack;

import java.util.Arrays;

/**
 * 用数组实现栈
 *
 * @author YangFeng
 * @create 2021-08-02 9:46
 */
public class ArrayStack<E> {

    int top = -1;
    E[] arr;
    int maxSize;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        arr = (E[]) new Object[maxSize];
    }

    //入栈
    public void push(E e){
        if(isFull()){
            System.out.println("栈已满");
        }else {
            arr[++top] = e;
        }
    }

    //出栈
    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }else {
            return arr[top--];
        }
    }

    //返回栈顶部元素
    public E topOfStack(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }else {
            return arr[top];
        }
    }

    //判断栈是否已满
    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", arr=" + Arrays.toString(arr) +
                ", maxSize=" + maxSize +
                '}';
    }
}
