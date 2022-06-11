package com.yang.sort;

/**
 * 实现归并排序
 *注：归并排序需要额外的空间
 * @author YangFeng
 * @create 2021-08-17 21:43
 */
public class MergeSort {


    int[] temp;
    public MergeSort(){

    }

    public void sort(int[] arr){
        temp = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    /**
     * 分和治两部分：先分割，再合并
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     */
    private void sort(int[] arr, int left, int right){
        //只要left<right 就需要继续分
        int mid = (left+right)/2;
        if(left<right){
            sort(arr,left,mid); //将左边序列完成分割再合并
            sort(arr,mid+1,right); //将右边序列完成分割再合并
            //递归会调用最上层的栈，也就是说，当分割到只有每个分组都一个元素时，才会开始下面的合并操作
            merge(arr,left,right);
        }
    }

    /**
     *  治的部分，将左右两个有序数组合并
     *  左序列:[left, mid]  右序列:[mid+1, right]
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     */
    private void merge(int[] arr, int left, int right){
        int mid = (left+right)/2;
        int pLeft = left; //左边序列的指针
        int pRight = mid+1; //右边序列的指针

        int k=left; //作为temp数组的索引
        while (pLeft<=mid && pRight<=right){//每次移动一次指针
            //先看右边的序列：把小的数放进序列
            if(arr[pRight]<=arr[pLeft]){
                temp[k] = arr[pRight];
                pRight++;
            }else if(arr[pLeft]<=arr[pRight]){//左边序列：把小的数放进序列
                temp[k] = arr[pLeft];
                pLeft++;
            }
            k++;

        }

        //当有一个序列的指针到达尾端时，上面的循环就会结束
        //结束之后，就将另一个数组的所有元素放入数组
        while (pLeft<=mid){ //左序列还有元素没在temp数组中
            temp[k] = arr[pLeft];
            pLeft++;
            k++;
        }
        while (pRight<=right){ //左序列还有元素没在temp数组中
            temp[k] = arr[pRight];
            pRight++;
            k++;
        }

        //将temp中的元素复制到原数组中
        for(int i=left; i<=right; i++){
            arr[i] = temp[i];
        }

    }


}
