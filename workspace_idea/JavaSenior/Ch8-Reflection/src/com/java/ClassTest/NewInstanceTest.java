package com.java.ClassTest;

import org.junit.Test;

/**
 * 通过反射创建运行时类的对象
 *
 * @author YangFeng
 * @create 2021-02-27 11:55
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class personClass = Person.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器

        要想此方法正常的创建运行时类的对象，要求：
            1.运行时类必须提供空参的构造器
            2.空参的构造器的访问权限得够。通常，设置为public
         */
        Person person = (Person)personClass.newInstance();
        System.out.println(person);
    }
}
