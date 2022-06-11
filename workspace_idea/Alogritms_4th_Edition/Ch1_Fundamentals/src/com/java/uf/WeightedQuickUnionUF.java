package com.java.uf;

import java.util.Arrays;

/**
 * 见书P144
 *
 * @author YangFeng
 * @create 2021-04-05 17:23
 */
public class WeightedQuickUnionUF extends QuickUnionUF{

    int[] weights; //用于记录每个节点的权重

    public WeightedQuickUnionUF(int N) {
        super(N);
        weights = new int[N];
        for(int i=0; i<N; i++){
            weights[i] = 1;
        }
    }


    @Override
    public void union(int p, int q) {

        int pRoot = find(p);
        int pRootWeight = weight(pRoot);

        int qRoot = find(q);
        int qRootWeight = weight(qRoot);

        if(pRoot == qRoot){
            return;
        }else{
            if(pRootWeight < qRootWeight){
                id[pRoot] = qRoot;
                weights[qRoot] += pRootWeight;
            }else{
                id[qRoot] = pRoot;
                weights[pRoot] += qRootWeight;
            }

            count--;
        }
    }

    private int weight(int p) {
        return weights[p];
    }

    @Override
    public String toString() {
        return "WeightedQuickUnionUF{" +
                "weights=" + Arrays.toString(weights) +
                ", id=" + Arrays.toString(id) +
                ", count=" + count +
                '}';
    }
}
