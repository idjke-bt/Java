package com.yf.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangFeng
 * @create 2022-05-04 11:06
 */
@Service
public class BookService {
    @Autowired  //自动为这个属性赋值
    private BookDAO bookDao;

    public void save(){
        System.out.println("正在调用Dao保存图书.....");
        bookDao.saveBook();
    }

}
