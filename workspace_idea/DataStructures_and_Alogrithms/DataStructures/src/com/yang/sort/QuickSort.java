package com.yang.sort;

/**
 * 实现快速排序
 *
 * @author YangFeng
 * @create 2021-08-16 23:34
 */
public class QuickSort {

    public QuickSort(){

    }

    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int low, int high){

        if(low>=high){
            return;
        }

        //1.寻找“基准”(pivot)，将数组变成{小于基准 基准 大于基准}的样子
        int pos = findPos(arr,low,high);

        //左右两部分继续
        sort(arr, low, pos-1);
        sort(arr,pos+1, high);
    }

    public int findPos(int[] arr, int low, int high){
        int pivot = arr[low];
        //第三步：重复一二两步
        while (low<high){
            //第一步：high向左移动，直到遇见比基准小的元素，并将该元素赋值给arr[low]
            while (low<high && arr[high]>=pivot){
                high--;
            }
            arr[low] = arr[high];

            //第二步：low向左移动，直到遇见比基准大的元素，并将该元素赋值给arr[high]
            while (low<high && arr[low]<=pivot){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low]=pivot;
        return low;
    }
}
