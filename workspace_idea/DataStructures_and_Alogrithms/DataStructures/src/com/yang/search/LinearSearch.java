package com.yang.search;

/**
 * 实现线性查找
 *
 * @author YangFeng
 * @create 2021-08-22 22:19
 */
public class LinearSearch {

    public LinearSearch(){

    }

    public int search(int[] arr, int value){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==value){
                return value;
            }
        }
        return -1;
    }
}
