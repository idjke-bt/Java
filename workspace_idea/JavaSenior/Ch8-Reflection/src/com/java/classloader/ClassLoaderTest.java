package com.java.classloader;

import org.junit.Test;

/**
 *
 *
 * @author YangFeng
 * @create 2021-11-17 22:32
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        //获取ClassLoaderTest类的加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent():获取扩展类的加载器
        ClassLoader loaderParent = classLoader.getParent();
        System.out.println(loaderParent);

        //调用扩展类加载器的getParent():无法获取引导类的加载器
        ClassLoader classLoader1 = loaderParent.getParent();
        System.out.println(classLoader1);

    }
}
