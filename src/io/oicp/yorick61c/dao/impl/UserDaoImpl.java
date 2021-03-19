package io.oicp.yorick61c.dao.impl;

import io.oicp.yorick61c.dao.UserDao;
import io.oicp.yorick61c.domain.User;
import io.oicp.yorick61c.domain.UserOrder;
import io.oicp.yorick61c.druidUtils.druidUtils;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private double radius;
    JdbcTemplate template = new JdbcTemplate(druidUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (EmptyResultDataAccessException e){
            System.out.println(username + "不存在!");
            return null;
        }
    }

    @Override
    public int insertUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phoneNum = user.getPhoneNum();
        String address = user.getAddress();
        String sql = "insert into user values(?,?,?,?,?,?)";
        return template.update(sql,null,username,password,phoneNum,0,address);
    }

    @Override
    public User findUserByUP(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (EmptyResultDataAccessException e){
            System.out.println(username + "用户名或密码错误/该用户不存在");
            return null;
        }
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where userId = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(id + "id不存在");
            return null;
        }
    }

    @Override
    public int updateUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phoneNum = user.getPhoneNum();
        String sql = "update user set username = ?, password = ?, phoneNum = ? where userId = ?";
        return template.update(sql,username,password,phoneNum,user.getUserId());
    }

    @Override
    public int updateUserById(User user, int id) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phoneNum = user.getPhoneNum();
        String address = user.getAddress();
        Double balance = user.getBalance();
        if (balance == null){
            balance = 0.0;
        }
        String sql = "update user set username = ?, password = ?, phoneNum = ?,balance = ?,address = ? where userId = ?";
        return template.update(sql,username,password,phoneNum,balance,address,id);
    }

    @Override
    public List<User> findUserList(int start, int end) {
        String sql = "select * from user limit ?,?";
        try {
            return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,end);
        }catch (EmptyResultDataAccessException e){
            System.out.println("无用户");
            return null;
        }
    }

    @Override
    public int countUser() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public int addOrder(UserOrder userOrder) {
        String name = userOrder.getName();
        Double price = userOrder.getPrice();
        Integer num = userOrder.getNum();
        Integer user_id = userOrder.getUser_id();
        Integer medicine_id = userOrder.getMedicine_id();
        String sql = "insert into user_order values(?,?,?,?,?,?)";
        return template.update(sql,null,name,price,num,user_id,medicine_id);
    }

    @Override
    public List<UserOrder> findAllOrderById(int id) {
        String sql = "select * from user_order where user_id = ?";
        try {
            return template.query(sql,new BeanPropertyRowMapper<UserOrder>(UserOrder.class),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int deleteOrderById(int id) {
        String sql = "delete from user_order where id = ?";
        return template.update(sql,id);
    }

    @Override
    public void deleteOrderByUserId(Integer userId) {
        String sql = "delete from user_order where user_id = ?";
        template.update(sql,userId);
    }

    public String toString(){
        return "radius = " + radius;
    }
}
