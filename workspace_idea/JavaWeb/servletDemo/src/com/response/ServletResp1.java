package com.response; /**
 * @author YangFeng
 * @create 2022-04-04 19:03
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class ServletResp1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------response1------");

        //设置响应码302，表示请求重定向
        response.setStatus(302);
        //设置响应头，说明新的地址
        response.setHeader("Location", "http://localhost:8080/servletDemo/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
