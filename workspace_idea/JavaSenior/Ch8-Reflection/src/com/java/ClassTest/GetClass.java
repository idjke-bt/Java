package com.java.ClassTest;

import org.junit.Test;

/**
 * 获取Class类的实例的方式
 *
 * @author YangFeng
 * @create 2021-02-27 10:03
 */
public class GetClass {

    @Test
    public void method() throws ClassNotFoundException {
        //方式一: 调用运行时类的属性：.class
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);

        //方式二: 调用运行时类的对象
        Person person = new Person();
        Class personClass2 = person.getClass();
        System.out.println(personClass2);

        //方式三: 通过Class的静态方法：forName(String classPath)
        Class personClass3 = Class.forName("com.java.ClassTest.Person");
        System.out.println(personClass3);

        System.out.println("==============================================");
        System.out.println(personClass1 == personClass2);
        System.out.println(personClass1 == personClass3);
     }


     //方式四（了解）：使用类的加载器 Classloader
    @Test
    public void method2() throws ClassNotFoundException {
        ClassLoader classLoader = GetClass.class.getClassLoader();
        Class personClass = classLoader.loadClass("com.java.ClassTest.Person");
        System.out.println(personClass);
    }
}
