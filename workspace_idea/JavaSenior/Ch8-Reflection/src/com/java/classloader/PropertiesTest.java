package com.java.classloader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 使用ClassLoader加载配置文件
 *
 * @author YangFeng
 * @create 2021-11-17 22:51
 */
public class PropertiesTest {
    /**
     * 读取配置文件方式一
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        /**
         * properties 用来读取配置文件
         */

        Properties pros = new Properties();
        //File file = new File(".\\src\\jdbc.properties");  //这一行可以省略
        //默认相对路径是相对与当前module
        FileInputStream fis = new FileInputStream(".\\src\\jdbc.properties");
        pros.load(fis);  //加载文件流

        //properties是键值对的形式，"user=李华"  user是key  李华是value
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user="+user+", password="+password);
    }

    /**
     * 读取配置文件方式二：使用Classloader
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        /**
         * properties 用来读取配置文件
         */

        Properties pros = new Properties();
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        //默认相对路径是相对与当前module\\src
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");  //以流的形式获取资源

        pros.load(is); //加载文件流
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user="+user+", password="+password);
    }
}
