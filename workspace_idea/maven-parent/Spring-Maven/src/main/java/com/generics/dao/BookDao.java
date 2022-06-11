package com.generics.dao;

import com.generics.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author YangFeng
 * @create 2022-05-07 16:14
 */
@Repository
public class BookDao extends BaseDao<Book>{
    @Override
    public void save() {
        System.out.println("BookDao:保存图书....");
    }
}
