package io.oicp.yorick61c.dao;

import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;

import java.util.List;

public interface UserDao {

    User findUserByUsername(String username);

    int insertUser(User user);

    User findUserByUP(String username, String password);

    User findUserById(int id);

    int updateUser(User user);

    int updateUserById(User user, int id);

    List<User> findUserList(int start,int end);

    int countUser();

    int addOrder(UserOrder userOrder);

    List<UserOrder> findAllOrderById(int id);

    int deleteOrderById(int id);

    void deleteOrderByUserId(Integer userId);
}
