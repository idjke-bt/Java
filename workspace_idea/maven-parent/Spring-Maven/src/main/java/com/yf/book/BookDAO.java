package com.yf.book;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author YangFeng
 * @create 2022-05-04 11:06
 */
@Repository
public class BookDAO {
    public void saveBook(){
        System.out.println("保存了一本书");
    }


}
