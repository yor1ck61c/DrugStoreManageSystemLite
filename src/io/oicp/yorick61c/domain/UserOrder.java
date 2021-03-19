package io.oicp.yorick61c.domain;

public class UserOrder {
    private Integer id;
    private String name;
    private Double price;
    private Integer num;
    private Integer user_id;
    private Integer medicine_id;

    public UserOrder() {
    }

    public UserOrder(Integer id, String name, Double price, Integer num, Integer user_id, Integer medicine_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.user_id = user_id;
        this.medicine_id = medicine_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(Integer medicine_id) {
        this.medicine_id = medicine_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOrder userOrder = (UserOrder) o;

        if (!id.equals(userOrder.id)) return false;
        if (!name.equals(userOrder.name)) return false;
        if (!price.equals(userOrder.price)) return false;
        if (!num.equals(userOrder.num)) return false;
        if (!user_id.equals(userOrder.user_id)) return false;
        return medicine_id.equals(userOrder.medicine_id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + num.hashCode();
        result = 31 * result + user_id.hashCode();
        result = 31 * result + medicine_id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", user_id=" + user_id +
                ", medicine_id=" + medicine_id +
                '}';
    }
}
