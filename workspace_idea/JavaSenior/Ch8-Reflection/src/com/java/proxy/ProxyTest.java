package com.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author YangFeng
 * @create 2022-05-11 17:13
 */

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "SuperMan";
    }

    @Override
    public void eat(String food) {
        System.out.println("SuperMan: "+food);
    }
}

/**
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */


/**
 * 代理类
 */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理的对象
        //获得obj所对应类的类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();
        //获得obj所实现的接口
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        //InvocationHandler接口的实现类
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        /**上面的都是作为这一行的参数（复习时先从每个参数的意义开始）**/
        return Proxy.newProxyInstance(classLoader,interfaces,handler);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object object;  //需要使用被代理类的对象进行赋值

    public void bind(Object object){
        this.object = object;
    }

    //当我们通过代理类的对象，调用方法a是，就会自动的调用如下的方法：invoke()
    //将被单例类要执行的方法a的功能声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:代理类想要调用的同名方法---->也就是被代理类想要调用的方法（问题2）
        //object:被代理类的对象
        //args:方法的参数
        System.out.println(method.getName()+"正在执行");
        Object value = method.invoke(object, args);
        System.out.println(method.getName()+"执行结束");
        return value;

    }
}


public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        /**得到superMan的代理对象**/  //强转，不转怎么调用Human接口中的方法
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        proxyInstance.eat("apple"); //此时会自动去调用MyInvocationHandler中的invoke方法
        System.out.println("--------------------------------------");
        System.out.println(proxyInstance.getBelief());

    }
}
