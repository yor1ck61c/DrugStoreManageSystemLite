package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String InputCheckCode = request.getParameter("verifyCode");
        HttpSession session = request.getSession();
        String formedCheckCode =(String) session.getAttribute("checkCode");
        if(!formedCheckCode.equalsIgnoreCase(InputCheckCode)){
            Map<String, String[]> userInfo = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,userInfo);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            request.setAttribute("userRegisterInfo",user);
            request.setAttribute("registerMsg","验证码错误");
            request.getRequestDispatcher("userRegister.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> userInfo = request.getParameterMap();
        /*for (Map.Entry<String, String[]> entry : userInfo.entrySet()) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }*/
        User user = new User();
        try {
            BeanUtils.populate(user,userInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        if(service.userRegister(user) == 1){
            request.setAttribute("RegisterStatus", "注册成功");
        }else {
            request.setAttribute("RegisterStatus", "注册失败");
        }
        request.getRequestDispatcher("registerStatus.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
