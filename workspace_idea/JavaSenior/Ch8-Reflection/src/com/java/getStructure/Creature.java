package com.java.getStructure;

/**
 * @author YangFeng
 * @create 2021-02-27 21:04
 */
public class Creature<E> {

    private String gender;
    public double weight;
    E e;

    public Creature(){
        System.out.println("==================Creature()==================");
    }

    private Creature(String gender, double weight){
        this.gender = gender;
        this.weight = weight;
    }

    E getE(E e){
        return e;
    }
}
