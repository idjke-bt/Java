package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YangFeng
 * @create 2022-03-26 20:00
 */
public class HelloHttpServlet extends HttpServlet {
    /**
     * doGet方法：在get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String namespace = context.getInitParameter("namespace");
        System.out.println(namespace);

        String contextPath = context.getContextPath();
        System.out.println("当前的“工程路径”为: "+contextPath);

        /**
         * getRealPath:把浏览器中输入的地址对应到实际硬盘中的地址
         * / 斜杠被服务器解析地址为:http://ip:port/工程名/ 映射到IDEA 代码的web 目录
         */
        String realPath = context.getRealPath("/");
        System.out.println("“工程路径”所对应的磁盘上的绝对路径为: "+realPath);
    }

    /**
     * 在post请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post request");
    }
}
