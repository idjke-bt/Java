package com.java.uf;

/**
 *
 * 具体细节见书p140
 *
 * @author YangFeng
 * @create 2021-04-05 17:01
 */
public class QuickUnionUF extends UF{

    //private int[] id;  //在QuickUnion算法中，数组的索引表示对应的节点
                        //数组的值表示该节点的父节点

    //private int count; //统计有多少个连通分量(等价类，每成功执行一次union,count--)

    public QuickUnionUF(int N){
        super(N);
    }

    @Override
    public void union(int p, int q) {
        /*
        将节点p的根节点改为节点q的根节点
         */
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }else{
            id[pRoot] = qRoot;
            count--;
        }
    }

    @Override
    public int find(int p) {
        /*
        寻找p的根节点:若q是根节点，则id[q] = q
         */
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }


}
