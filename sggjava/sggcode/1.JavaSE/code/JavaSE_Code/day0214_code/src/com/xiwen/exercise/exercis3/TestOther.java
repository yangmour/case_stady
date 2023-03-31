package com.xiwen.exercise.exercis3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:10
 * @Version: 1.0
 */
public class TestOther {
    public static void main(String[] args) {
        Other o = new Other();
        new TestOther().addOne(o);
        System.out.println(o.i); //1
    }

    public void addOne(final Other o) {
        o.i++;
    }
}

class Other {
    public int i;
}
