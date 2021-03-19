package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Manager;
import io.oicp.yorick61c.service.ManagerService;
import io.oicp.yorick61c.service.impl.ManagerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> managerInfo = request.getParameterMap();
        Manager manager = new Manager();
        try {
            BeanUtils.populate(manager,managerInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        ManagerService service = new ManagerServiceImpl();
        if ((manager = service.findManagerByUP(manager)) != null){
            int time = new Date().getHours();
            if (time >= 6 && time <= 8){
                request.getSession().setAttribute("time", "早上好");
            }
            if (time >= 9 && time <= 11){
                request.getSession().setAttribute("time", "上午好");
            }
            if (time >= 12 && time < 14){
                request.getSession().setAttribute("time", "中午好");
            }
            if (time >= 14 && time <= 18){
                request.getSession().setAttribute("time", "下午好");
            }
            if (time >= 19 && time <= 24){
                request.getSession().setAttribute("time", "晚上好");
            }
            if (time >= 0 && time <= 5){
                request.getSession().setAttribute("time", "夜深了");
            }
            request.getSession().setAttribute("managerInfo",manager);
            request.getRequestDispatcher("managerSuccessLogin.jsp").forward(request,response);
        }else {
            request.setAttribute("managerLoginMsg","用户名或密码错误");
            request.getRequestDispatcher("managerLogin.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
