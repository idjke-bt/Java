package com.yang.search;

import com.sun.tools.javac.Main;

/**
 *实现斐波那契查找算法
 *
 * @author YangFeng
 * @create 2021-09-06 23:02
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int a = FibonacciSearch.fibonacci(4);
        System.out.println(a);
    }

    public FibonacciSearch(){

    }

    public static int sort(int[] arr, int value){
        //寻找和length相当的fibonacci[k]的值
        int k=0;
        while (arr.length>fibonacci(k)-1){
            k++;
        }

        //扩展数组，用原数组的最后一位数填充数组
        int[] new_arr = new int[fibonacci(k)];
        for(int i=0; i<arr.length; i++){
            new_arr[i] = arr[i];
        }
        for(int i=arr.length; i<new_arr.length; i++){
            new_arr[i] = arr[arr.length-1];
        }

        int low = 0;
        int high = new_arr.length-1;
        int mid;

        //查找过程，和插值类似
        while (low<=high && k>0){ //倘若数组只有一个数也应该执行才是
            mid = low+fibonacci(k-1)-1;

            if(new_arr[mid]==value){
                if(mid < arr.length){
                    return mid;
                }else{
                    return arr.length-1;
                }
            }else if(new_arr[mid] > value){ //value在左半部分
                high = mid - 1;
                k = k-1;
            }else{ //value在右半部分
                low = mid + 1;
                k = k-2;
            }
        }
        return -1;

    }


    private static int fibonacci(int k){//返回第k项斐波那契数列的值
        if(k==0 || k==1){
            return 1;
        }else{
            return fibonacci(k-1)+fibonacci(k-2);
        }
    }
}
