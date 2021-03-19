package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBalanceServlet")
public class UpdateBalanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        User userById = service.findUserById(Integer.parseInt(id));
        request.setAttribute("userById",userById);
        request.setAttribute("id",id);
        request.getRequestDispatcher("updateUserBalance.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
