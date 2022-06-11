package com.yf.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author YangFeng
 * @create 2022-04-30 16:28
 */
public class AirPlaneFactoryBean implements FactoryBean<AirPlane> {

    //getObject()：工厂方法，Spring自动调用
    //返回创建的对象
    @Override
    public AirPlane getObject() throws Exception {
        System.out.println("===FactoryBean===");
        AirPlane airPlane = new AirPlane();
        airPlane.setCapacity(1000);
        return airPlane;
    }

    //返回创建类型类型，Spring自动调用确认创建对象是什么类型
    @Override
    public Class<?> getObjectType() {
        return AirPlane.class;
    }

    //isSingleton：是单例吗？
    //false：不是单例
    //true：是单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
