package com.java.uf;

import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-04-04 20:41
 */
public abstract class UF {

    public UF(){

    }

    int[] id;

    int count; //统计有多少个连通分量(等价类，每成功执行一次union,count--)

    public UF(int N){
        id = new int[N];
        count = N;
        for(int i=0; i<id.length; i++){
            id[i] = i;  //表示初始化时各个节点互不相连
        }
    }

    public abstract void union(int p, int q);

    public abstract int find(int p);

    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }

    public int count() {
        return count;
    }

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "id=" + Arrays.toString(id) +
                ", count=" + count +
                '}';
    }

}
