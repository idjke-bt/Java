package com.java.getStructure;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author YangFeng
 * @create 2021-02-27 21:50
 */
public class ToGetMethods {

    Class<Person> personClass = Person.class;

    @Test
    public void toGetMethods1(){
        //getMethods():获取当前运行时类及其所有父类中声明为public访问权限的方法
        System.out.println("====================使用getMethods()==========================");
        Method[] methods = personClass.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }

        //getDeclaredMethods()：获取当前运行时类中声明的所有方法(注：不包括父类中声明的方法)
        System.out.println();
        System.out.println("====================使用getDeclaredMethods()==========================");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method method:declaredMethods){
            System.out.println(method);
        }
    }

    /*
    @Xxx(注解)
    权限修饰符  返回值类型  方法名(参数类型1 形参名1, ...) throws XxxException{}
     */
    @Test
    public void toGetMethod2(){
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method method:declaredMethods){

            //获取注解
            Annotation[] annotations = method.getAnnotations();
            System.out.println("注解为："+annotations);

            //权限修饰符
            int modifiers = method.getModifiers();
            System.out.print("权限修饰符："+ Modifier.toString(modifiers));

            //返回值类型
            Class returnType = method.getReturnType();
            System.out.print("\t返回值类型："+returnType.toString());

            //方法名
            String mName = method.getName();
            System.out.println("\t方法名："+mName);
        }
    }
}
