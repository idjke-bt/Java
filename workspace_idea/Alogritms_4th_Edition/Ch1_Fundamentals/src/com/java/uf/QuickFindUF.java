package com.java.uf;

/**
 * 具体细节见书p140
 *
 * @author YangFeng
 * @create 2021-04-05 11:34
 */
public class QuickFindUF extends UF{

    //private int[] id;  //在QuickFind算法中，数组的索引表示对应的节点
                        //数组的值表示该节点所在的等价类

    //private int count; //统计有多少个连通分量(等价类，每成功执行一次union,count--)

    public QuickFindUF(int N){
        super(N);
    }


    @Override
    public void union(int p, int q) {
        /*
        将id数组中所有值为id[p]的换成id[q]
         */
        int pId = id[p];
        int qId = id[q];

        if(pId==qId){
            return;
        }else{
            for(int i=0; i<id.length; i++){
                if(id[i]==pId){
                    id[i] = qId;
                }
            }
            count--;
        }


    }

    @Override
    public int find(int p) {
        return id[p];
    }




}
