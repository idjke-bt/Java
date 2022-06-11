package com.yf.springDemo;

/**
 * @author YangFeng
 * @create 2022-04-15 12:21
 */
public class User {

    private int times;

    public User(){
        System.out.println("User构造器");
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "User{" +
                "times=" + times +
                '}';
    }
}
