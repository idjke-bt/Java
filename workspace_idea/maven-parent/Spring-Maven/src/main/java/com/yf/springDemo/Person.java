package com.yf.springDemo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author YangFeng
 * @create 2022-04-22 9:47
 */
public class Person {
    //基本数据类型
    //<property name="name" value="candy"></property>自动进行转换
    private String name;
    private int age;
    private String gender;

    private User user;
    private List<Book> books;
    private Map<String, Object>map;
    private Properties pros;

    public Person(){
        System.out.println("Person构造器");
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", user=" + user +
                ", books=" + books +
                ", map=" + map +
                '}';
    }
}
