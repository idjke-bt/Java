package com.yang.queue;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-07-28 10:25
 */
public class Demo {

    @Test
    public void arrayQueueDemo(){
        ArrayQueue aq = new ArrayQueue(2);

        aq.show();
        aq.addQueue(1);
        aq.addQueue(2);
        aq.addQueue(3);

        aq.show();

        aq.deQueue();
        aq.deQueue();
        aq.deQueue();


    }

    @Test
    public void circleQueueDemo(){
        CircleQueue cq = new CircleQueue(3);
        cq.addQueue(5);
        cq.addQueue(3);
        cq.addQueue(11);
        cq.addQueue(22);

        cq.show();

        cq.deQueue();
        cq.deQueue();

        cq.addQueue(22);
        cq.show();
    }
}
