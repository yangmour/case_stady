package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:13
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        Father2 f = new Father2();
        Son2 s = new Son2();
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo());//尚硅谷
        s.test();//尚硅谷
        //atguigu
        System.out.println("-----------------");
        s.setInfo("大硅谷");
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo());//大硅谷
        s.test();//大硅谷
                 //atguigu
    }
}

class Father2 {
    private String info = "atguigu";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Son2 extends Father2 {
    private String info = "尚硅谷";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
}