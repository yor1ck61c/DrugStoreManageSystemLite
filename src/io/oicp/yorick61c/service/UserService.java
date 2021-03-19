package io.oicp.yorick61c.service;

import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;

public interface UserService {
    boolean findUsername(String username);

    int userRegister(User user);

    User findUserByUP(String username, String password);

    User findUserById(int id);

    int updateUserById(User user, int id);

    PageBean<User> findUserByPage(int currentPage, int rows);

    int addOrder(int user_id, int medicine_id);

    PageBean<UserOrder> getAllUserOrderById(int id);

    int deleteOrderById(int id);

    void buyMedicineById(Integer user_id, double totalPrice);

    void deleteOrderByUserId(Integer userId);
}
