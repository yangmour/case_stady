package com.xiwen.bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -15:15
 * @Version: 1.0
 */
public class Computer {
    private Integer id;
    private String brand;
    private Double price;

    public Computer() {
    }

    public Computer(Integer id, String brand, Double price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
