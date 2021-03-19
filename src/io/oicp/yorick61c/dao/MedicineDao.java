package io.oicp.yorick61c.dao;

import io.oicp.yorick61c.domain.Medicine;

import java.util.List;

public interface MedicineDao {
    int addMedicine(Medicine medicine);

    List<Medicine> findMedicineList(int start, int quantity);

    int countMedicine();

    void deleteMedicineById(int id);

    Medicine findMedicineById(int id);

    int updateMedicine(Medicine medicine);

    void declineMedicineById(int medicine_id, int quantity);
}
