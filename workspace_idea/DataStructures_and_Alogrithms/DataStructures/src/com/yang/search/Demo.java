package com.yang.search;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-08-22 23:06
 */
public class Demo {

    @Test
    public void binaryTest(){
        int[] arr = new int[]{1,8,89,1000,1000,1000,1000,1234};
//        System.out.println(BinarySearch.find(arr, 1000));
//        System.out.println(BinarySearch.recurseFind(arr,1000));
        System.out.println(BinarySearch.findArr(arr,1000));
    }

    @Test
    public void interpolationTest(){
        int[] arr = new int[]{1,8,89,1000,1000,1000,1000,1234};
        System.out.println(InterpolationSearch.find(arr,1000));
    }

    @Test
    public void FibonacciTest(){
        int[] arr = new int[]{1,8,89,1000,1234};
        int pos = FibonacciSearch.sort(arr, 1000);
        System.out.println(pos);
    }
}
