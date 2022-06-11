package com.java.Test1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射可以做什么？
 * //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
 * //建议：直接new的方式
 * //什么时候会使用反射的方式：动态性（反射的特性）
 *
 * //疑问2：反射机制与面向对象中的封装性是不是矛盾？ 如何看待两个技术？
 *不矛盾
 *
 * @author YangFeng
 * @create 2021-02-21 20:30
 */
public class ReflectionTest {

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //1.通过反射创建Person类的对象
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        //com.java.Test1.Person person = constructor.newInstance("Tom", 12);
        Person person = constructor.newInstance("Tom", 12);
        System.out.println(person);

        //2.通过反射调用对象指定的属性、方法
            //调用属性
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 10);
        System.out.println(person);

            //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        //通过反射，可以调用Person类的私有结构，如：私有构造器，属性，方法
            //调用私有构造器
        Constructor<Person> personCons = personClass.getDeclaredConstructor(String.class);
        personCons.setAccessible(true);
        Person person = personCons.newInstance("Merry");
        System.out.println("1.调用私有构造器: "+person.toString());

            //调用私有属性
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 10000);
        System.out.println("1.调用私有属性: "+person.toString());

            //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(person, "China");
    }
    
}
