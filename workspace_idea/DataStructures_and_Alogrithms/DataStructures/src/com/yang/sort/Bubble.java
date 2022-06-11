package com.yang.sort;

/**
 * 实现冒泡排序
 * 优化操作：
 *      如果在一次大循环中，没有发生交换，这表明已经有序
 *
 * @author YangFeng
 * @create 2021-08-10 22:15
 */
public class Bubble {

    public Bubble(){

    }

    public void bubbleSort(int[] arr){

        int temp;
        for(int i=0; i<arr.length-1; i++){
            boolean flag = true;//在循环结束前，数组是否已经有序了
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(flag==true) {
                System.out.println(i);
                break;
            }
        }
    }
}
