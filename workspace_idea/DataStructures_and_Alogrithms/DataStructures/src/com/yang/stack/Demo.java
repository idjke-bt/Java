package com.yang.stack;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2021-08-02 10:03
 */
public class Demo {

    @Test
    public void stackTest(){
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(1);
        as.push(2);
        System.out.println(as.toString());
        as.pop();
        as.pop();
        as.pop();
        System.out.println(as.toString());
    }

    @Test
    public void calTest(){
        Calculator cal = new Calculator("311+2*16-2-2*13");
        cal.answer();
    }

    @Test
    public void polandTest(){
        String s = "4 5 * 8 - 60 + 8 2 / +";
        Poland poland = new Poland(s);
        poland.answer();
    }

    @Test
    public void parseTest(){
        String str = "1+(22+3*4)-5";
        InfixToSuffix its = new InfixToSuffix(str);
        its.answer();
    }
}
