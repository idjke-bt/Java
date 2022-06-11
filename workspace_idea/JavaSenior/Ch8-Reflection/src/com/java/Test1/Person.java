package com.java.Test1;

/**
 * @author YangFeng
 * @create 2021-02-21 20:28
 */
public class Person {

    private String name;
    private int age;

    public Person() {

    }

    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void show(){
        System.out.println("this method is show");
    }

    private void showNation(String nation){
        System.out.println(name + " is coming from "+nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
