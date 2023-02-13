package com.xiwen.homeword.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:57
 * @Version: 1.0
 */
public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }


    public Designer(int id, String name, int age, double salary, String occupation, double bonus) {
        super(id, name, age, salary, occupation);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                "bonus=" + bonus;
    }
}
