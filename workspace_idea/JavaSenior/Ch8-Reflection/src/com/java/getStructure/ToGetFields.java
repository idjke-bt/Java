package com.java.getStructure;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 运用反射获取运行时类的属性结构
 *
 * @author YangFeng
 * @create 2021-02-27 21:21
 */
public class ToGetFields {

    Class<Person> personClass = Person.class;

    //获取属性结构
    @Test
    public void toGetFields() {
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        System.out.println("====================使用getFields()==========================");
        Field[] fields = personClass.getFields();
        for(Field f:fields){
            System.out.println(f);
        }

        //getDeclaredFields()：获取当前运行时类中声明的所有属性(注：不包括父类中声明的属性)
        System.out.println();
        System.out.println("====================使用getDeclaredFields()==========================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }
    }


    //获取属性的 权限修饰符， 数据类型， 变量名
    @Test
    public void toGetFields2(){
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print("\t修饰符: "+ Modifier.toString(modifiers));

            //数据类型
            Class type = f.getType();
            System.out.print("\t数据类型: "+type.getName());

            //变量名
            String fName = f.getName();
            System.out.println("\t变量名: "+fName);
            System.out.println();
        }
    }
}
