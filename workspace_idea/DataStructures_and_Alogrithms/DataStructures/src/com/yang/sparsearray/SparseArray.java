package com.yang.sparsearray;

/**
 * 将一个二维数组转换为稀疏数组
 *
 * @author YangFeng
 * @create 2021-07-27 11:28
 */
public class SparseArray {

    int[][] sparseArray = null;

    public SparseArray(){

    }

    //在构造器中，将输入数组转换为稀疏数组
    public SparseArray(int[][] originalArray){
        this.toSparseArray(originalArray);
    }

    public void toSparseArray(int[][] originalArray){
        //1.遍历数组，得到非0元素的个数
        int sum = 0;
        for(int i=0; i<originalArray.length;i++){
            for(int j=0; j<originalArray[i].length; j++){
                if(originalArray[i][j] != 0){
                    sum++;
                }
            }
        }

        //2.初始化稀疏数组
        sparseArray = new int[sum+1][3];
        sparseArray[0][0] = originalArray.length;
        sparseArray[0][1] = originalArray[0].length;
        sparseArray[0][2] = sum;

        //3.为稀疏矩阵赋值
        int k=1;
        for(int i=0; i<originalArray.length;i++){
            for(int j=0; j<originalArray[i].length; j++){
                if(originalArray[i][j] != 0){
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = originalArray[i][j];

                    k++;
                }
            }
        }
    }






}
