package com.servlet; /**
 * @author YangFeng
 * @create 2022-04-03 16:00
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class RequestForward2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------rf2------");

        String password = request.getParameter("password");
        System.out.println("password: "+password);

        System.out.println("key1: "+request.getAttribute("key1"));
        System.out.println("work!");
    }

}
