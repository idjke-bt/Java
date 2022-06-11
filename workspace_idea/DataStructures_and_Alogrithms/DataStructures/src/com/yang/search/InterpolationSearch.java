package com.yang.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现插值查找
 *
 * @author YangFeng
 * @create 2021-08-23 22:59
 */
public class InterpolationSearch {

    public InterpolationSearch(){

    }

    public static List find(int[] arr, int value){
        List<Integer> position = new ArrayList<>();

        int left = 0;
        int right = arr.length-1;
        int mid;

        while (left<=right){
           if(left==right){
               mid = left;
           }else {
               mid = left+(value-arr[left])/(arr[right]-arr[left])*(right-left);
           }
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
