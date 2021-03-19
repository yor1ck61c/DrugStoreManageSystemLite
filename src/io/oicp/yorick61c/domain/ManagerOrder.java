package io.oicp.yorick61c.domain;

public class ManagerOrder {
    private Integer id;
    private String username;
    private String medicine_name;
    private Integer medicine_num;
    private String phoneNum;
    private String address;

    public ManagerOrder() {
    }

    public ManagerOrder(Integer id, String username, String medicine_name, Integer medicine_num, String phoneNum, String address) {
        this.id = id;
        this.username = username;
        this.medicine_name = medicine_name;
        this.medicine_num = medicine_num;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public Integer getMedicine_num() {
        return medicine_num;
    }

    public void setMedicine_num(Integer medicine_num) {
        this.medicine_num = medicine_num;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerOrder that = (ManagerOrder) o;

        if (!id.equals(that.id)) return false;
        if (!username.equals(that.username)) return false;
        if (!medicine_name.equals(that.medicine_name)) return false;
        if (!medicine_num.equals(that.medicine_num)) return false;
        if (!phoneNum.equals(that.phoneNum)) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + medicine_name.hashCode();
        result = 31 * result + medicine_num.hashCode();
        result = 31 * result + phoneNum.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ManagerOrder{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", medicine_name='" + medicine_name + '\'' +
                ", medicine_num='" + medicine_num + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
