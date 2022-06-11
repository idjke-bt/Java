package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author YangFeng
 * @create 2022-03-26 15:59
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
//        System.out.println("constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        System.out.println("init");
        //1.获取Servlet程序的别名servlet-name
        System.out.println("servlet-name: "+servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("username: "+servletConfig.getInitParameter("username"));
        System.out.println("url: "+servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("service");

        //强转是为了调用getMethod方法，即得知是get请求还是post请求
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        String method = hsr.getMethod();
        if(method.equals("GET")){
            doGet();
        }else{
            doPost();
        }
    }

    private void doGet(){
        System.out.println("get request");
    }
    private void doPost(){
        System.out.println("post request");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
