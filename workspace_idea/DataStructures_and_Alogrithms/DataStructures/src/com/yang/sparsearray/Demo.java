package com.yang.sparsearray;

import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-07-27 12:00
 */
public class Demo {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        SparseArray sa = new SparseArray(arr);
        for(int i=0; i<sa.sparseArray.length; i++){
            for(int j=0; j<sa.sparseArray[i].length; j++){
                System.out.print(sa.sparseArray[i][j]+" ");
            }
            System.out.println();
        }

    }
}
