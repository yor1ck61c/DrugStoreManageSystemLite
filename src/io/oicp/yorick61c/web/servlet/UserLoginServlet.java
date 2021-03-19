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
import java.util.Date;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserServiceImpl();
        User userByUP = service.findUserByUP(username, password);

        if (userByUP != null){
            int time = new Date().getHours();
            if (time >= 6 && time <= 8){
                request.getSession().setAttribute("userTime", "早上好");
            }
            if (time >= 9 && time <= 11){
                request.getSession().setAttribute("userTime", "上午好");
            }
            if (time >= 12 && time < 14){
                request.getSession().setAttribute("userTime", "中午好");
            }
            if (time >= 14 && time <= 18){
                request.getSession().setAttribute("userTime", "下午好");
            }
            if (time >= 19 && time <= 24){
                request.getSession().setAttribute("userTime", "晚上好");
            }
            if (time >= 0 && time <= 5){
                request.getSession().setAttribute("userTime", "夜深了");
            }
            Double balance = service.findUserById(userByUP.getUserId()).getBalance();
            request.setAttribute("balance",balance);
            request.getSession().setAttribute("userInfo",userByUP);
            request.getRequestDispatcher("userSuccessLogin.jsp").forward(request,response);
        }else {
            request.setAttribute("loginMsg","用户名或密码错误");
            request.getRequestDispatcher("userLogin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
