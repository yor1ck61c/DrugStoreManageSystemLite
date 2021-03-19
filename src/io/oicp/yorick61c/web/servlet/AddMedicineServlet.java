package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/AddMedicineServlet")
public class AddMedicineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> medicineInfo = request.getParameterMap();
        Medicine medicine = new Medicine();
        try {
            BeanUtils.populate(medicine,medicineInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        MedicineService service = new MedicineServiceImpl();
        int status = service.addMedicine(medicine);
        if (status == 1){
            request.setAttribute("addStatus","已成功添加" + medicine.getMedicine_name());
            request.getRequestDispatcher("addStatus.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
