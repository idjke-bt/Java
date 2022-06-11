package com.java.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * @author YangFeng
 * @create 2021-04-05 14:21
 */
public class UFTest {

    public static void main(String[] args) {
        int N = StdIn.readInt();// 读取触点数量
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);// 初始化N个分量
        while(!StdIn.isEmpty()) {  //控制台输入ctrl+D 可以停止该循环
            int p = StdIn.readInt();
            int q = StdIn.readInt();// 读取整数对
            if (uf.connected(p, q)) continue;// 如果已经连通则忽略
            uf.union(p, q);// 归并分量
            StdOut.println(p + "---" + q);// 打印链接
        }
        StdOut.println(uf.toString());
    }

}
