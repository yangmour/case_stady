package com.xiwen.homework.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-20:06
 * @Version: 1.0
 */
public class Equipment {
    private Integer id;
    private String brand;
    private Double salary;
    private String name;
    private Status status;

    public Equipment() {
    }

    //            Integer.parseInt(data[i][0]), data[i][1], Double.parseDouble(data[i][3]), data[i][4], Status.getByValue(Integer.parseInt(data[i][5])));
    public Equipment(Integer id, String brand, Double salary, String name, Status status) {
        this.id = id;
        this.brand = brand;
        this.salary = salary;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
