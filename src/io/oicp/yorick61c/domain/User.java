package io.oicp.yorick61c.domain;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private String phoneNum;
    private Double balance;
    private String address;

    public User() {
    }

    public User(Integer userId, String username, String password, String phoneNum, Double balance, String address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.balance = balance;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!phoneNum.equals(user.phoneNum)) return false;
        if (!balance.equals(user.balance)) return false;
        return address.equals(user.address);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + phoneNum.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                '}';
    }
}
