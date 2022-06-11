package com.yang.tree;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-09-11 12:00
 */
public class Demo {

    @Test
    public void traverseTest(){
        BinaryTree bt = new BinaryTree();
        bt.preTraverse();
        System.out.println();
        bt.inTraverse();
        System.out.println();
        bt.postTraverse();
    }
}
