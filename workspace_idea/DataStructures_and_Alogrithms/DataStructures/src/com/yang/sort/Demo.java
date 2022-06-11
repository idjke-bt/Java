package com.yang.sort;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-08-10 22:21
 */
public class Demo {

    @Test
    public void bubbleTest(){
        Bubble bubble = new Bubble();
        int[] arr = new int[]{3,9,-1,10,20};
        bubble.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectTest(){
        SelectSort ss  = new SelectSort();
        int[] arr = new int[]{101,34,119,1};
        ss.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertTest(){
        InsertSort is = new InsertSort();
        int[] arr = new int[]{17,3,14,20,9};
        is.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void shellTest(){
        ShellSort ss = new ShellSort();
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        ss.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void quickTest(){
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{2,3,5,4,6,0};
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void MergeSort(){
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void RadixSort(){
        int[] arr = new int[]{190, 1, 52, 43, 89};
        RadixSort rs = new RadixSort();
        rs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
