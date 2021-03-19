package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;
import io.oicp.yorick61c.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UpdateUserInfoServlet2")
public class UpdateUserInfoServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Map<String, String[]> afterChange = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,afterChange);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        int status = service.updateUserById(user,Integer.parseInt(id));
        if (status == 1){
            request.setAttribute("userUpdateStatus","用户信息更改成功");
            request.getRequestDispatcher("userUpdateStatus.jsp").forward(request,response);
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
