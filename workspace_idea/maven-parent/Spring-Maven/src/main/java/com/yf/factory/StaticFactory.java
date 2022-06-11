package com.yf.factory;

/**
 * 静态工厂
 * @author YangFeng
 * @create 2022-04-30 15:40
 */
public class StaticFactory {

    //创建对象：StaticFactory.getInstance();
    public static AirPlane getInstance(String captain){
        System.out.println("===StaticFactory===");
        AirPlane airPlane = new AirPlane();
        airPlane.setCapacity(300);
        airPlane.setCaptain(captain);
        airPlane.setEngine("太行");
        return  airPlane;
    }
}
