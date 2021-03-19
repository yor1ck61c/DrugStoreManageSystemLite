package io.oicp.yorick61c.dao.impl;

import io.oicp.yorick61c.dao.ManagerDao;
import io.oicp.yorick61c.domain.Manager;
import io.oicp.yorick61c.domain.ManagerOrder;
import io.oicp.yorick61c.druidUtils.druidUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
    JdbcTemplate template = new JdbcTemplate(druidUtils.getDataSource());
    @Override
    public Manager findManagerByUP(String managerName, String password) {
        String sql = "select * from manager where managerName = ? and password = ?";
        try{
            return template.queryForObject(sql,new BeanPropertyRowMapper<Manager>(Manager.class),managerName,password);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertManagerOrder(ManagerOrder managerOrder) {
        String address = managerOrder.getAddress();
        String medicine_name = managerOrder.getMedicine_name();
        Integer medicine_num = managerOrder.getMedicine_num();
        String phoneNum = managerOrder.getPhoneNum();
        String username = managerOrder.getUsername();

        String sql = "insert into manager_order values(?,?,?,?,?,?)";
        template.update(sql,null,username,medicine_name,medicine_num,phoneNum,address);
    }

    @Override
    public List<ManagerOrder> findAllOrder() {
        String sql = "select * from manager_order";
        try {
            return template.query(sql,new BeanPropertyRowMapper<ManagerOrder>(ManagerOrder.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void deleteOrderById(int id) {
        String sql = "delete from manager_order where id = ?";
        template.update(sql,id);
    }

    @Override
    public void deleteOrderByOrderId(int id) {
        String sql = "delete from manager_order where id = ?";
        template.update(sql,id);
    }
}
