package com.request; /**
 * @author YangFeng
 * @create 2022-04-04 14:43
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BaseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
