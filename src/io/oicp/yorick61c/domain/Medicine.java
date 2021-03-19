package io.oicp.yorick61c.domain;

import java.util.Objects;

public class Medicine {
    private Integer id;
    private String medicine_name;
    private String medicine_type;
    private String medicine_effect;
    private Double medicine_bid;
    private Double medicine_price;
    private String medicine_unit;
    private Integer medicine_num;

    public Medicine() {
    }

    public Medicine(Integer id, String medicine_name, String medicine_type, String medicine_effect, Double medicine_bid, Double medicine_price, String medicine_unit, Integer medicine_num) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.medicine_type = medicine_type;
        this.medicine_effect = medicine_effect;
        this.medicine_bid = medicine_bid;
        this.medicine_price = medicine_price;
        this.medicine_unit = medicine_unit;
        this.medicine_num = medicine_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_type() {
        return medicine_type;
    }

    public void setMedicine_type(String medicine_type) {
        this.medicine_type = medicine_type;
    }

    public String getMedicine_effect() {
        return medicine_effect;
    }

    public void setMedicine_effect(String medicine_effect) {
        this.medicine_effect = medicine_effect;
    }

    public Double getMedicine_bid() {
        return medicine_bid;
    }

    public void setMedicine_bid(Double medicine_bid) {
        this.medicine_bid = medicine_bid;
    }

    public Double getMedicine_price() {
        return medicine_price;
    }

    public void setMedicine_price(Double medicine_price) {
        this.medicine_price = medicine_price;
    }

    public String getMedicine_unit() {
        return medicine_unit;
    }

    public void setMedicine_unit(String medicine_unit) {
        this.medicine_unit = medicine_unit;
    }

    public Integer getMedicine_num() {
        return medicine_num;
    }

    public void setMedicine_num(Integer medicine_num) {
        this.medicine_num = medicine_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (!id.equals(medicine.id)) return false;
        if (!medicine_name.equals(medicine.medicine_name)) return false;
        if (!medicine_type.equals(medicine.medicine_type)) return false;
        if (!Objects.equals(medicine_effect, medicine.medicine_effect))
            return false;
        if (!medicine_bid.equals(medicine.medicine_bid)) return false;
        if (!medicine_price.equals(medicine.medicine_price)) return false;
        if (!Objects.equals(medicine_unit, medicine.medicine_unit))
            return false;
        return Objects.equals(medicine_num, medicine.medicine_num);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + medicine_name.hashCode();
        result = 31 * result + medicine_type.hashCode();
        result = 31 * result + (medicine_effect != null ? medicine_effect.hashCode() : 0);
        result = 31 * result + medicine_bid.hashCode();
        result = 31 * result + medicine_price.hashCode();
        result = 31 * result + (medicine_unit != null ? medicine_unit.hashCode() : 0);
        result = 31 * result + (medicine_num != null ? medicine_num.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicine_name='" + medicine_name + '\'' +
                ", medicine_type='" + medicine_type + '\'' +
                ", medicine_effect='" + medicine_effect + '\'' +
                ", medicine_bid=" + medicine_bid +
                ", medicine_price=" + medicine_price +
                ", medicine_unit='" + medicine_unit + '\'' +
                ", medicine_num=" + medicine_num +
                '}';
    }
}
