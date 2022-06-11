package com.yf.factory;

/**
 * 实例工厂
 * @author YangFeng
 * @create 2022-04-30 15:39
 */
public class InstanceFactory {

    /**
     * 创建实例：
     * InstanceFactory factory = new InstanceFactory();
     * factory.getInstance();
     */
    public AirPlane getInstance(String captain){
        System.out.println("===InstanceFactory===");
        AirPlane airPlane = new AirPlane();
        airPlane.setCapacity(300);
        airPlane.setCaptain(captain);
        airPlane.setEngine("太行");
        return  airPlane;
    }
}
