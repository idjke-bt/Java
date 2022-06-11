package com.yang.hashtable;

import org.junit.Test;

/**
 * @author YangFeng
 * @create 2021-09-10 23:24
 */
public class Demo {

    @Test
    public void test(){
        HashTable ht = new HashTable();
        ht.add(123,"baidu");
        ht.add(41,"jingdong");
        ht.add(12,"bilibili");
        ht.add(67,"acfun");
        ht.add(867,"w3cshool");
        ht.add(445,"ac");
        ht.add(32,"grossly");

        ht.show();
        System.out.println("**********************");
        ht.find(32222);
    }
}
