package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }
        if(rows == null || rows.equals("")){
            rows = "5";
        }

        UserService service = new UserServiceImpl();
        PageBean<User> userByPage = service.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows));
        request.setAttribute("userByPage",userByPage);
        request.getRequestDispatcher("seeAllUserInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
