package com.yang.recursion;

import java.util.Arrays;

/**
 * 八皇后问题
 * 在一个8*8的棋盘上摆放8个皇后
 * 要求： 任意两个皇后不能在同一行、同一列、或者对角线上
 * 求一共有多少种解法
 *
 * 注意：看起来是用二维数组，但实际上每个棋子都不在同一行、同一列，
 * 即每行每列都只有一个棋子，那么用一维数组就足够了
 *
 * @author YangFeng
 * @create 2021-08-09 21:55
 */
public class EightQueens {

    private final int[] arr;
    private final int max;
    private int count=0;

    /**
     * @param max 一个max*max的棋盘
     */
    public EightQueens(int max){
        this.max = max;
        arr = new int[max];
    }

    /**
     * 功能：将第n+1个棋子放到正确的位置
     * 等价的问题（如何减小规模）：排好第一个皇后后排第二个，第二个排号后排第三个。。。。。
     * 终止条件：开始摆放第9个皇后，即前8个皇后都摆放好了（以八皇后问题为例）
     *
     * 注意事项：
     *  只有合理的摆放才能进入递归，只有进入递归才能运行35行的if语句，才能输出结果
     *
     * @param n 指第n+1个棋子
     */
    private void setPos(int n){
        if(n==max){//开始摆放第9个皇后，即前8个皇后都摆放好了（以八皇后问题为例）
            count++;
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int pos=0; pos<max; pos++){
            //先将第n+1个棋子摆放到pos上
            arr[n] = pos;
            //判断是否合理
            if(judge(n)){//合理就继续摆放下一个棋子
                setPos(n+1);
            }//只有合理的摆放才能进入递归，只有进入递归才能运行35行的if语句，才能输出结果
        }

    }

    /**
     * 判断第n+1个棋子摆放的是否正确（调用之前先对数组复赋值了：arr[n]=pos）
     * @param n 第n+1个棋子
     */
    private boolean judge(int n){
        if(n!=0){ //不是放第一个棋子
            for(int i=0; i<n; i++){//只需判断是否在同一列、同一对角线即可
                if(arr[i]==arr[n] || (n-i)==Math.abs(arr[n]-arr[i])){
                    return false;
                }
            }
        }
        return true;

    }

    public void sol(){
        System.out.println("输出所有解法：");
        setPos(0);
        System.out.println("*******************************");
        System.out.println("解法有"+count+"种");
    }
}
