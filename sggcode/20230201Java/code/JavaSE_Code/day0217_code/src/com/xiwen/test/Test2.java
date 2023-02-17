package com.xiwen.test;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-11:25
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Father2 f = new Father2();
        Son s = new Son();
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo());//atguigu
        s.setInfo("尚硅谷");
        System.out.println(f.getInfo());//atguigu
        System.out.println(s.getInfo());//尚硅谷
    }
}
class Father2{
    private String info = "atguigu";

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }
}
class Son extends Father2{

}