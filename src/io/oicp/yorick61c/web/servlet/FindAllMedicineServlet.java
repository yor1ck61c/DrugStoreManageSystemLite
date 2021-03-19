package io.oicp.yorick61c.web.servlet;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.MedicineService;
import io.oicp.yorick61c.service.impl.MedicineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindAllMedicineServlet")
public class FindAllMedicineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        String flag = request.getParameter("flag");
        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }
        if(rows == null || rows.equals("")){
            rows = "5";
        }

        MedicineService service = new MedicineServiceImpl();
        PageBean<Medicine> medicineInfos = service.findMedicineByPage(Integer.parseInt(currentPage),Integer.parseInt(rows));

        request.setAttribute("medicineInfos",medicineInfos);
        if (flag == null){
            request.getRequestDispatcher("seeAllMedicineInfo.jsp").forward(request,response);
        }
        request.getRequestDispatcher("userSeeAllMedicineInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
