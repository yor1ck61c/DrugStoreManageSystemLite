package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        User beforeUpdate = service.findUserById(Integer.parseInt(id));
        request.setAttribute("UserBeforeUpdate",beforeUpdate);
        request.setAttribute("id",id);
        request.getRequestDispatcher("updateUser.jsp").forward(request,response);

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
