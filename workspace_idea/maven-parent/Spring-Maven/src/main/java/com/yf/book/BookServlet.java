package com.yf.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author YangFeng
 * @create 2022-05-04 11:07
 */
@Controller
public class BookServlet {

    @Autowired
    private BookService bookService;

    public void doGet(){
        bookService.save();
    }
}
