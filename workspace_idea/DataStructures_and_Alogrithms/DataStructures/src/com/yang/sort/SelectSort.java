package com.yang.sort;

/**
 * 实现选择排序
 *
 * @author YangFeng
 * @create 2021-08-12 22:16
 */
public class SelectSort {

    public SelectSort(){

    }

    public void sort(int[] arr){
        for(int i=0; i< arr.length-1; i++){//遍历次数
            findMin(arr, i); //每一轮遍历需要找到最小值，并放到子数组的左侧
        }
    }

    /**
     * 寻找子数组的最小值，并将其放到最左边
     * @param arr 完整的数组
     * @param left 子数组最左边的位置的索引
     */
    private void findMin(int[] arr, int left){
        //寻找最小的元素的索引
        int minIndex = left;
        for(int i=left; i<arr.length; i++){
            if(arr[i]<arr[minIndex]){
                minIndex = i;
            }
        }

        //交换位置
        swap(arr, left, minIndex);

    }

    /**
     * 交换数组中两个元素的位置
     * @param arr 数组
     * @param i 索引1
     * @param j 索引2
     */
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}
