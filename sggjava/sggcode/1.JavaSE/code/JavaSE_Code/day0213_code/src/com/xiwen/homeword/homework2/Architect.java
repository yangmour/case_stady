package com.xiwen.homeword.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:59
 * @Version: 1.0
 */
public class Architect extends Designer {
    private double stocks;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, String occupation, double bonus, double stocks) {
        super(id, name, age, salary, occupation, bonus);
        this.stocks = stocks;
    }

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return super.toString() +
                "stocks=" + stocks;
    }
}
