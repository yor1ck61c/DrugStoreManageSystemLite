package io.oicp.yorick61c.service.impl;

import io.oicp.yorick61c.dao.MedicineDao;
import io.oicp.yorick61c.dao.UserDao;
import io.oicp.yorick61c.dao.impl.MedicineDaoImpl;
import io.oicp.yorick61c.dao.impl.UserDaoImpl;
import io.oicp.yorick61c.domain.Medicine;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;
import io.oicp.yorick61c.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    MedicineDao medicineDao = new MedicineDaoImpl();

    @Override
    public boolean findUsername(String username) {
        return dao.findUserByUsername(username) != null;
    }

    @Override
    public int userRegister(User user) {
        return dao.insertUser(user);
    }

    @Override
    public User findUserByUP(String username, String password) {
        return dao.findUserByUP(username,password);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public int updateUserById(User user, int id) {
        return dao.updateUserById(user,id);
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows) {
        PageBean<User> userPageBean = new PageBean<>();
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);
        userPageBean.setItems(dao.findUserList((currentPage-1) * rows,rows));
        int quantity = dao.countUser();
        userPageBean.setTotalItems(quantity);
        int totalPage = quantity % rows == 0 ? quantity / rows : (quantity / rows) +1;
        userPageBean.setTotalPages(totalPage);
        return userPageBean;
    }

    @Override
    public int addOrder(int user_id, int medicine_id) {
        UserOrder userOrder = new UserOrder();
        Medicine medicineById = medicineDao.findMedicineById(medicine_id);

        userOrder.setName(medicineById.getMedicine_name());
        userOrder.setPrice(medicineById.getMedicine_price());
        userOrder.setMedicine_id(medicine_id);
        userOrder.setUser_id(user_id);
        userOrder.setNum(1);
        return dao.addOrder(userOrder);
    }

    @Override
    public PageBean<UserOrder> getAllUserOrderById(int id) {
        PageBean<UserOrder> pageBean = new PageBean<UserOrder>();
        pageBean.setItems(dao.findAllOrderById(id));
        return pageBean;
    }

    @Override
    public int deleteOrderById(int id) {
        return dao.deleteOrderById(id);
    }

    @Override
    public void buyMedicineById(Integer user_id, double totalPrice) {
        User userById = dao.findUserById(user_id);
        Double balance = (userById.getBalance() - totalPrice);
        userById.setBalance(balance);
        dao.updateUserById(userById,user_id);
    }

    @Override
    public void deleteOrderByUserId(Integer userId) {
        dao.deleteOrderByUserId(userId);
    }
}
