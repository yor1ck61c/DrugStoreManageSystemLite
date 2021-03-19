package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;
import io.oicp.yorick61c.service.ManagerService;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.UserService;
import io.oicp.yorick61c.service.impl.ManagerServiceImpl;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;
import io.oicp.yorick61c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SubmitUserOrderServlet")
public class SubmitUserOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double totalPrice = (double)request.getSession().getAttribute("totalPrice");
        String id = request.getParameter("id");
        User user = (User)request.getSession().getAttribute("userInfo");
        PageBean<UserOrder> userOrderInfo = (PageBean<UserOrder>)request.getSession().getAttribute("userOrderInfo");
        List<UserOrder> list = userOrderInfo.getItems();
        ArrayList<Integer> medicine_ids = new ArrayList<>();
        for (UserOrder userOrder:list) {
            medicine_ids.add(userOrder.getMedicine_id());
        }
        UserService service = new UserServiceImpl();
        MedicineService medicineService = new MedicineServiceImpl();
        ManagerService managerService = new ManagerServiceImpl();
        managerService.addOrderById(user.getUserId());
        service.buyMedicineById(Integer.parseInt(id),totalPrice);
        medicineService.declineMedicineById(medicine_ids);
        service.deleteOrderByUserId(user.getUserId());
        Double balance = service.findUserById(user.getUserId()).getBalance();
        request.setAttribute("balance",balance);
        request.getRequestDispatcher("successPayoff.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
