package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CheckUserOrderServlet")
public class CheckUserOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User)request.getSession().getAttribute("userInfo");
        UserService service = new UserServiceImpl();
        PageBean<UserOrder> userOrderInfo = service.getAllUserOrderById(user.getUserId());
        List<UserOrder> list = userOrderInfo.getItems();
        double sum = 0.0;
        for (UserOrder userOrder : list) {
            sum += userOrder.getPrice() * userOrder.getNum();
        }

        Double balance = service.findUserById(user.getUserId()).getBalance();
        request.setAttribute("balance",balance);
        request.getSession().setAttribute("userOrderInfo",userOrderInfo);
        request.getSession().setAttribute("totalPrice",sum);
        request.getRequestDispatcher("seeAllUserOrder.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
