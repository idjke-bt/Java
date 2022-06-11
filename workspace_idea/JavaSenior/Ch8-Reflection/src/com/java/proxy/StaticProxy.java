package com.java.proxy;

/**
 * 静态代理的实例
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 *
 * @author YangFeng
 * @create 2022-05-11 16:56
 */
interface ClothFactory{
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    //构造器的参数就是被代理类的对象
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("===代理类开始工作===");
        factory.produceCloth();
        System.out.println("===代理类结束工作===");
    }
}

/**
 * 被代理类
 */
class HelloClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("===被代理类的produceCloth方法===");
    }
}


public class StaticProxy {
    public static void main(String[] args) {
        //被代理类的对象
        ClothFactory hello = new HelloClothFactory();

        //代理类的对象
        ClothFactory helloProxy = new ProxyClothFactory(hello);

        helloProxy.produceCloth();
    }
}
