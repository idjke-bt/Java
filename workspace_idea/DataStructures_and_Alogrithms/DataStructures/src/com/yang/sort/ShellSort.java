package com.yang.sort;

/**
 * 实现希尔排序
 *
 * @author YangFeng
 * @create 2021-08-14 22:00
 */
public class ShellSort {

    public ShellSort(){

    }

    public void sort(int[] arr){
        int temp;
        for(int gap=arr.length/2; gap>0; gap/=2){//gap=1时执行最后一次插入排序即可完成排序
            //arr[gap]及之后的数据都需要使用插入排序
            for(int i=gap; i<arr.length;i++){
                //将arr[i]插入对应的分组
                temp = arr[i];
                int j=i-gap;
                while (j>=0 && temp<=arr[j]){
                    //arr[j]向右移动
                    arr[j+gap]=arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }

        }

    }

    //实现插入排序
    private void insertSort(int[] arr){
        for(int right=0; right<arr.length-1; right++){
            int temp = arr[right+1];
            for(int j=right; j>0; j--){
                if(temp<=arr[j]){
                    arr[j+1] = arr[j];//左移
                }
            }
        }

    }
}
