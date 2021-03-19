package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.dao.ManagerDao;
import io.oicp.yorick61c.dao.UserDao;
import io.oicp.yorick61c.dao.impl.ManagerDaoImpl;
import io.oicp.yorick61c.dao.impl.UserDaoImpl;
import io.oicp.yorick61c.domain.Manager;
import io.oicp.yorick61c.domain.ManagerOrder;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.UserOrder;
import io.oicp.yorick61c.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao dao = new ManagerDaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public Manager findManagerByUP(Manager manager) {
        return dao.findManagerByUP(manager.getManagerName(),manager.getPassword());
    }

    @Override
    public void addOrderById(Integer user_id) {
        List<UserOrder> allOrder = userDao.findAllOrderById(user_id);
        for (UserOrder o: allOrder) {
            ManagerOrder managerOrder = new ManagerOrder();
            managerOrder.setMedicine_name(o.getName());
            managerOrder.setMedicine_num(1);
            managerOrder.setAddress(userDao.findUserById(user_id).getAddress());
            managerOrder.setPhoneNum(userDao.findUserById(user_id).getPhoneNum());
            managerOrder.setUsername(userDao.findUserById(user_id).getUsername());
            dao.insertManagerOrder(managerOrder);
        }
    }

    @Override
    public PageBean<ManagerOrder> findAllOrder() {
        PageBean<ManagerOrder> managerOrderPageBean = new PageBean<>();
        managerOrderPageBean.setItems(dao.findAllOrder());
        return managerOrderPageBean;
    }

    @Override
    public void deleteOrderById(int id) {
        dao.deleteOrderById(id);
    }

    @Override
    public void deleteOrderByOrderId(int id) {
        dao.deleteOrderByOrderId(id);
    }
}
