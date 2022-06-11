package com.generics.serivce;

import com.generics.bean.Book;
import com.generics.dao.BaseDao;
import com.generics.dao.BookDao;
import com.yf.book.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangFeng
 * @create 2022-05-07 16:16
 */
@Service
public class BookService extends BaseService<Book>{

}
