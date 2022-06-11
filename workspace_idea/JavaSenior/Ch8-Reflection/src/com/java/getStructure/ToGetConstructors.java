package com.java.getStructure;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 获取构造器
 *
 * @author YangFeng
 * @create 2021-02-28 16:02
 */
public class ToGetConstructors {

    Class<Person> personClass = Person.class;

    @Test
    public void toGetConstructor1(){
        //getConstructors():获取当前运行时类中声明为public的构造器（不包括父类）
        Constructor[] constructors = personClass.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }

        //getDeclaredConstructors()
    }

}
