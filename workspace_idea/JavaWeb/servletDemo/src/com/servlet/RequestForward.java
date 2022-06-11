package com.servlet; /**
 * @author YangFeng
 * @create 2022-04-03 15:59
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RequestForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------rf1------");
        String username = request.getParameter("username");
        System.out.println("1.请求的参数： "+username);

        request.setAttribute("key1", "rf1的章");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rf2");

        requestDispatcher.forward(request,response);
    }

}
