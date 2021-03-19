package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateMedicineInfoServlet")
public class UpdateMedicineInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        MedicineService service = new MedicineServiceImpl();
        Medicine beforeUpdate = service.findMedicineById(Integer.parseInt(id));
        request.setAttribute("beforeUpdate",beforeUpdate);
        request.setAttribute("id",id);
        request.getRequestDispatcher("updateMedicine.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
