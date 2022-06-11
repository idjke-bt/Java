package com.java.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author YangFeng
 * @create 2021-02-19 10:58
 */
public class InetAddressTest {

    public static void main(String[] args){

        try {
            //根据域名或者IP地址得到对应的InetAddress对象
            InetAddress inet1 = InetAddress.getByName("www.bilibili.com");
            System.out.println(inet1);
            System.out.println(inet1.getHostName());
            System.out.println(inet1.getHostAddress());

            //获取本地IP
            InetAddress inet2 = InetAddress.getLocalHost();
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("14.215.177.39");
            System.out.println("inet3:"+inet3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}