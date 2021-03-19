package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        String medicine_id = request.getParameter("medicine_id");
        UserService service = new UserServiceImpl();
        int status = service.addOrder(Integer.parseInt(user_id),Integer.parseInt(medicine_id));
        if (status == 1){
            request.setAttribute("addOrderStatus","添加成功!");
            request.getRequestDispatcher("FindAllMedicineServlet?flag=user").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
