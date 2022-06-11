package com.yf.springDemo;

/**
 * @author YangFeng
 * @create 2022-04-22 15:20
 */
public class Book {
    private String name;
    private String author;

    public Book(){
        System.out.println("Book构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
