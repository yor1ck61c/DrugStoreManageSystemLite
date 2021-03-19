package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.Manager;
import io.oicp.yorick61c.domain.ManagerOrder;
import io.oicp.yorick61c.domain.PageBean;

public interface ManagerService {

    Manager findManagerByUP(Manager manager);

    void addOrderById(Integer user_id);

    PageBean<ManagerOrder> findAllOrder();

    void deleteOrderById(int id);

    void deleteOrderByOrderId(int id);
}
