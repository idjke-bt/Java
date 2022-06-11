package com.yang.sort;

/**
 * 实现插入排序
 *
 * @author YangFeng
 * @create 2021-08-12 22:42
 */
public class InsertSort {

    public InsertSort(){

    }

    public void sort(int[] arr){
        for(int i=0; i<arr.length-1; i++){ //执行插入的次数
            insert(arr,i);
        }
    }

    /**
     * 将无序序列中索引为(right+1)的元素插入有序序列
     * 注意利用有序数组的有序性
     * @param arr 原数组
     * @param right 子数组（有序序列）的右边界的索引
     *
     */
    private void insert(int[] arr, int right){
        int num = arr[right+1]; //需要插入的元素
        int i=right;
        while(i>=0 && arr[i]>num){//如果比num大，则将序列中的元素右移，将位置空出来
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = num;
    }
}
