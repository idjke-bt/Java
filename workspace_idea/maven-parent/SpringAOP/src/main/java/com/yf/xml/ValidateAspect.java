package com.yf.xml;

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

public class ValidateAspect {

    public void validStart(JoinPoint point){
        System.out.println("[valid-before]"+point.getSignature().getName()+"开始验证");
    }

    public void validEnd(JoinPoint point){
        System.out.println("[valid-after]"+point.getSignature().getName()+"结束验证");
    }

}
