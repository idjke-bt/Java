package com.yf.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 另一个切面类
 * @author YangFeng
 * @create 2022-05-14 15:32
 */
@Aspect
@Component
public class ValidateAspect {

    @Before(value = "execution(public * com.yf.calculator.MathCalculator.*(int,int))")
    public void validStart(JoinPoint point){
        System.out.println("[valid-before]"+point.getSignature().getName()+"开始验证");
    }

    @After(value = "execution(public * com.yf.calculator.MathCalculator.*(int,int))")
    public void validEnd(JoinPoint point){
        System.out.println("[valid-after]"+point.getSignature().getName()+"结束验证");
    }

}
