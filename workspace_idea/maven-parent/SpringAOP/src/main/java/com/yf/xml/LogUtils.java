package com.yf.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogUtils {
    public static void logStart(JoinPoint joinPoint){
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("[LogUtils-before]【"+name+"】方法执行了，参数为【"+Arrays.toString(args)+ "】");
    }

     public static void logReturn(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-AfterReturning]【"+ signature.getName() +"】方法执行完成，他的返回值是："+result);
    }

    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-AfterThrowing]【"+ signature.getName() +"】方法出现了异常，异常为： "+e);
    }

    public static void logEnd(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-After]【"+ signature.getName() +"】方法执行最终完成");
    }


    public Object myAround(ProceedingJoinPoint point) throws Throwable {
        Object proceed = null;
        Object[] args = point.getArgs();
        String name = point.getSignature().getName();
        try {
            //这个位置相当于执行@Before
            System.out.println("【环绕前置】"+name);
            //利用反射调用目标方法，相当于动态代理中的method.invoke(obj,args);
            proceed = point.proceed(args);
            //@AfterReturning
            System.out.println("【环绕返回】"+proceed);
        } catch (Exception e) {
            //@AfterThrowing
            System.out.println("【环绕异常】"+e);
        }finally {
            //@After
            System.out.println("【环绕后置】"+name);
        }
        //将反射调用和的返回值返回
        return proceed;

    }

}

