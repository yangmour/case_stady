package com.xiwen.homework.homework13_1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-19:29
 * @Version: 1.0
 */
public class Architect extends Designer{
    private Double stock;

    public Architect() {
    }

    public Architect(Integer id, String name, Integer age, Double salary, Double bonus, Double stock) {
        super(id, name, age, salary, bonus);
        this.stock = stock;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.getBasicInfo() +
                "stock=" + stock + ",架构师";
    }
}
