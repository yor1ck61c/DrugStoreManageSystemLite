package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.PageBean;

import java.util.ArrayList;
import java.util.List;

public interface MedicineService {
    int addMedicine(Medicine medicine);


    PageBean<Medicine> findMedicineByPage(int currentPage, int rows);

    void deleteMedicineById(int id);

    Medicine findMedicineById(int id);

    int updateMedicine(Medicine medicine);

    void declineMedicineById(ArrayList<Integer> id);
}
