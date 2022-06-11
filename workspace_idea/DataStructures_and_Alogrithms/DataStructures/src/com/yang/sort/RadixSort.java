package com.yang.sort;

/**
 * 实现激素排序
 *
 * @author YangFeng
 * @create 2021-08-18 22:22
 */
public class RadixSort {

    private int[][] buckets; //10个桶  10行
    private int[] count = new int[10]; //记录每个桶里面有多少个元素
    public RadixSort(){

    }

    public void sort(int[] arr){
        //创建桶
        int column = maxDigit(arr);
        buckets = new int[10][arr.length];

        int digit=0; //桶的索引
        for(int times=1, temp=1; times<=column; times++,temp*=10){ //执行的轮数：个位--十位--百位--...
            /** 将数组放入桶中 **/
            for(int index=0; index<arr.length; index++){ //每一轮都需要遍历整个数组，将数放入桶中
                digit = (arr[index]/temp) % 10;
                buckets[digit][count[digit]++] = arr[index];
            }

            /** 将桶中的元素放回数组 **/
            int k=0;
            for(int i=0; i<10; i++){
                for(int j=0; j<count[i]; j++){
                    arr[k++] = buckets[i][j];
                }
            }

            /** 将桶重置：把count数组初始化即可 **/
            for(int i=0; i<10; i++)
                count[i] = 0;
        }


    }

    /**
     * 返回数组中最大元素的位数
     * @param arr 数组
     * @return 数组中最大元素的位数
     */
    private int maxDigit(int[] arr){
        int max = arr[0];
        //求最大值
        for(int i=0; i<arr.length; i++){
            if(max<arr[i])
                max=arr[i];
        }

        String str = String.valueOf(max); //转换成字符串，返回其长度
        return str.length();
    }
}
