package com.yf.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 *
 * @author YangFeng
 * @create 2022-05-12 21:37
 */
@Aspect
@Component
public class LogUtils {

    @Pointcut("execution(public int com.yf.calculator.MathCalculator.*(int ,int ))")
    public void myPoint(){
    }

    /**
     * 告诉Spring每个方法都什么时候运行
     */
    //希望在目标方法执行之前运行
    @Before("myPoint()")
    public static void logStart(JoinPoint joinPoint){
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("[LogUtils-before]【"+name+"】方法执行了，参数为【"+Arrays.toString(args)+ "】");
    }

    //想在目标方法正常执行return之后执行
    //returning属性：告诉Spring使用什么变量来接收返回值
    @AfterReturning(value = "execution(public int com.yf.calculator.MathCalculator.*(int ,int ))", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-AfterReturning]【"+ signature.getName() +"】方法执行完成，他的返回值是："+result);
    }

    //想在目标方法出现异常的时候执行
    //throwing：告诉Spring使用什么变量来接收异常信息
    @AfterThrowing(value = "execution(public * com.yf.calculator.MathCalculator.*(*,*))", throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-AfterThrowing]【"+ signature.getName() +"】方法出现了异常，异常为： "+e);
    }

    //想在目标方法结束的时候执行
    @After("execution(public * com.yf.calculator.MathCalculator.*(*,*))")
    public static void logEnd(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("[LogUtils-After]【"+ signature.getName() +"】方法执行最终完成");
    }

//    @Around("myPoint()") //相当于写动态代理的简化版
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

