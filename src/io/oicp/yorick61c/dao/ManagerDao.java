package io.oicp.yorick61c.dao;

import io.oicp.yorick61c.domain.Manager;
import io.oicp.yorick61c.domain.ManagerOrder;

import java.util.List;

public interface ManagerDao {
    Manager findManagerByUP(String managerName, String password);

    void insertManagerOrder(ManagerOrder managerOrder);

    List<ManagerOrder> findAllOrder();

    void deleteOrderById(int id);

    void deleteOrderByOrderId(int id);
}
