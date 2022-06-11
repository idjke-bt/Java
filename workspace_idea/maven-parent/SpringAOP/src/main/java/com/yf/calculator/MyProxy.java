package com.yf.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YangFeng
 * @create 2022-05-12 21:23
 */
public class MyProxy {
    public static Object getProxyInstance(Object obj){//获得obj的动态代理
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new MyInvocationHandler(obj));
    }

    static class MyInvocationHandler implements InvocationHandler{
        private Object obj;
        public MyInvocationHandler(Object obj){
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("============");
            return method.invoke(obj,args);
        }
    }

}
