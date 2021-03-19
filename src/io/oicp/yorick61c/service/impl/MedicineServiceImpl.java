package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.dao.MedicineDao;
import io.oicp.yorick61c.dao.impl.MedicineDaoImpl;
import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.MedicineService;

import java.util.ArrayList;

public class MedicineServiceImpl implements MedicineService {
    MedicineDao dao = new MedicineDaoImpl();
    @Override
    public int addMedicine(Medicine medicine) {
        return dao.addMedicine(medicine);
    }

    @Override
    public PageBean<Medicine> findMedicineByPage(int currentPage, int rows) {
        PageBean<Medicine> medicinePageBean = new PageBean<>();
        medicinePageBean.setCurrentPage(currentPage);
        medicinePageBean.setRows(rows);
        medicinePageBean.setItems(dao.findMedicineList((currentPage - 1) * rows ,rows));
        int totalCount = dao.countMedicine();
        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        medicinePageBean.setTotalItems(totalCount);
        medicinePageBean.setTotalPages(totalPage);
        return medicinePageBean;
    }

    @Override
    public void deleteMedicineById(int id) {
        dao.deleteMedicineById(id);
    }

    @Override
    public Medicine findMedicineById(int id) {
        return dao.findMedicineById(id);
    }

    @Override
    public int updateMedicine(Medicine medicine) {
        return dao.updateMedicine(medicine);
    }

    @Override
    public void declineMedicineById(ArrayList<Integer> id) {
        for (int medicine_id:id) {
            int quantity = (dao.findMedicineById(medicine_id).getMedicine_num() - 1);
            dao.declineMedicineById(medicine_id,quantity);
        }
    }


}
