package io.oicp.yorick61c.dao.impl;

import io.oicp.yorick61c.dao.MedicineDao;
import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.druidUtils.druidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MedicineDaoImpl implements MedicineDao {
    JdbcTemplate template = new JdbcTemplate(druidUtils.getDataSource());

    @Override
    public int addMedicine(Medicine medicine) {

        String name = medicine.getMedicine_name();
        String type = medicine.getMedicine_type();
        String effect = medicine.getMedicine_effect();
        Double bid = medicine.getMedicine_bid();
        Double price = medicine.getMedicine_price();
        String unit = medicine.getMedicine_unit();
        Integer num = medicine.getMedicine_num();

        String sql = "insert into medicine values(?,?,?,?,?,?,?,?)";
        return template.update(sql,null,name,type,effect,bid,price,unit,num);
    }

    @Override
    public List<Medicine> findMedicineList(int start, int quantity) {
        String sql = "select * from medicine limit ?,?";
        try {
            return template.query(sql,new BeanPropertyRowMapper<Medicine>(Medicine.class),start,quantity);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int countMedicine() {
        String sql = "select count(*) from medicine";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public void deleteMedicineById(int id) {
        String sql = "delete from medicine where id = ?";
        template.update(sql,id);
    }

    @Override
    public Medicine findMedicineById(int id) {
        String sql = "select * from medicine where id = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<Medicine>(Medicine.class),id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateMedicine(Medicine medicine) {
        Integer id = medicine.getId();
        String name = medicine.getMedicine_name();
        String type = medicine.getMedicine_type();
        String effect = medicine.getMedicine_effect();
        Double bid = medicine.getMedicine_bid();
        Double price = medicine.getMedicine_price();
        String unit = medicine.getMedicine_unit();
        Integer num = medicine.getMedicine_num();

        String sql = "update medicine set medicine_name = ?, medicine_type = ?, medicine_effect = ?, medicine_bid = ?, medicine_price = ?, medicine_unit = ?, medicine_num = ? where id = ?";
        return template.update(sql,name,type,effect,bid,price,unit,num,id);
    }

    @Override
    public void declineMedicineById(int medicine_id, int quantity) {
        String sql = "update medicine set medicine_num = ? where id = ?";
        template.update(sql,quantity,medicine_id);
    }
}
