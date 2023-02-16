package com.xiwen.homework.homework13_1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-18:30
 * @Version: 1.0
 */
public class Designer extends Programmer {
    private Double bonus;

    public Designer() {
    }

    public Designer(Integer id, String name, Integer age, Double salary, Double bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.getBasicInfo() +
                "bonus=" + bonus + ",职业:设计师";
    }
}

