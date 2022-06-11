package com.yang.linkedlist;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-07-30 11:53
 */
public class Demo {

    @Test
    public void singleTest(){
        SingleLinkedList sll = new SingleLinkedList();
        sll.addNodeByOrder(1,"a");
        sll.addNodeByOrder(5,"v");
        sll.addNodeByOrder(3,"s");
        sll.addNodeByOrder(4,"f");
        sll.addNodeByOrder(9,"fw");
        sll.addNodeByOrder(0,"kkl");
        sll.show();

        sll.findLastIndexNode(6);
    }

    @Test
    public void circleTest(){
        JosephuCircle jc = new JosephuCircle(125,10,20);
        jc.game();
    }
}
