package com.servlet; /**
 * @author YangFeng
 * @create 2022-04-02 14:08
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;


public class HttpServletRequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("URI: "+request.getRequestURI());
//        System.out.println("URL: "+request.getRequestURL());
//        System.out.println("客户端的ip地址: "+request.getRemoteHost());
//        System.out.println("head: "+request.getHeader("Accept"));
//        System.out.println("method: "+request.getMethod());
        System.out.println("username: "+request.getParameter("username"));
        System.out.println("hobbies: "+ Arrays.toString(request.getParameterValues("hobby")));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post请求会出现中文乱码的问题，故需要先设置字符集
        request.setCharacterEncoding("UTF-8");

        System.out.println("-------doPost()------");
        System.out.println("username: "+request.getParameter("username"));
        System.out.println("hobbies: "+ Arrays.toString(request.getParameterValues("hobby")));
    }
}
