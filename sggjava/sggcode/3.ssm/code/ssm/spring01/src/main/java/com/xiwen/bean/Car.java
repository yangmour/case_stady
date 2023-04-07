package com.xiwen.bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -09:49
 * @Version: 1.0
 */
public class Car {
    private String name;
    private String colour;
    private Double price;

    public Car() {
    }

    public Car(String name, String colour, Double price) {
        this.name = name;
        this.colour = colour;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }
}
