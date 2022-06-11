package com.yf.calculator;

import org.springframework.stereotype.Service;

/**
 * @author YangFeng
 * @create 2022-05-12 21:21
 */

@Service
public class MathCalculator{
    //@Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    //@Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    //@Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    //@Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
