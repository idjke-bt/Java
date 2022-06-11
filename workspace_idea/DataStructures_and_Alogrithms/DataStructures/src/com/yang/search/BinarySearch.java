package com.yang.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现二分查找(必须为有序数组）
 * 1.使用递归
 * 2.不使用递归
 * 3.当找到的元素不只一个时，需要返回数组
 *
 * @author YangFeng
 * @create 2021-08-22 22:23
 */
public class BinarySearch {

    public BinarySearch(){

    }

    /*不使用递归的方式*/
    public static int find(int[] arr, int value){
        int left = 0;
        int right = arr.length-1;
        int mid;

        //不断和中间值进行比较
        while (left<=right){
            mid = (left+right)/2;
            if(arr[mid]<value){ //数组有序，value在arr[mid]的右侧
                left = mid+1;
            }else if(arr[mid]>value){//数组有序，value在arr[mid]的左侧
                right = mid-1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    /*使用递归的方式*/
    public static int recurseFind(int[] arr, int value){

        return recurseFind(arr, value, 0, arr.length-1);
    }

    private static int recurseFind(int[] arr, int value, int left, int right){

        if(left>right){
            return -1;
        }

        int mid=(left+right)/2;
        if(arr[mid]<value){
            return recurseFind(arr,value,mid+1, right);
        }else if(arr[mid]>value){
            return recurseFind(arr,value,left,mid-1);
        }else {
            return mid;
        }

    }

    /**
     * 当找到的元素不只一个时，需要返回数组
     * 当找到一个value后，再向两边寻找value
    */

    public static List findArr(int[] arr, int value){

        List<Integer> position = new ArrayList<>();

        int left = 0;
        int right = arr.length-1;
        int mid;

        while (left<=right){
            mid = (left+right)/2;
            if(arr[mid]<value){
                left=mid+1;
            }else if(arr[mid]>value){
                right = mid-1;
            }else {//arr[mid]==value
                position.add(mid);
                //先看左边有内有和value相同的值
                int temp = mid-1;
                while (temp>=0 && arr[temp]==value){
                    position.add(temp--);
                }
                //看右边
                temp = mid +1;
                while (temp<arr.length && arr[temp]==value){
                    position.add(temp++);
                }
                break;
            }
        }

        return position;
    }
}
