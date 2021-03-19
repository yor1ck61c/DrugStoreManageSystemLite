package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");

        UserService service = new UserServiceImpl();
        boolean isRegister = service.findUsername(username);
        String message = "用户名已被使用";
        if(!isRegister)
            message = "用户名可以使用";
        PrintWriter out = response.getWriter();
        /*out.println("<response>");
        out.println("<message>" + message + "</message>");
        out.println("</response>");*/
        out.println(message);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
