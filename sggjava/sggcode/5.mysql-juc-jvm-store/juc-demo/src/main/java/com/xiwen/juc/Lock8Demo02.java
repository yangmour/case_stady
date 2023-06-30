package com.xiwen.juc;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/30 -18:17
 * @Version: 1.0
 */

class Phone {

    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
//        Thread.sleep(3000);
        System.out.println("发送短信!");
    }

    public synchronized void sendEmail(){
        System.out.println("发送邮箱!");
    }

    public void sayHello(){
        System.out.println("hello！");
    }

}

public class Lock8Demo02 {

    /**
     * 多线程的8个问题：
     * 1. 标准访问，先打印短信还是邮件
     * 2. 停4秒在短信方法内，先打印短信还是邮件
     * 3. 普通的hello方法，是先打短信还是hello
     * 4. 现在有两部手机，先打印短信还是邮件
     * 5. 两个静态同步方法，1部手机，先打印短信还是邮件
     * 6. 两个静态同步方法，2部手机，先打印短信还是邮件
     * 7. 1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件
     * 8. 1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件
     * 总结：
     * synchronized实现同步的基础：Java中的每一个对象都可以作为锁。具体表现为以下3种形式：
     * 1. 对于普通同步方法，锁是当前实例对象。
     * 2. 对于静态同步方法，锁是当前类的Class对象。
     * 3. 对于同步方法块，锁是Synchonized括号里配置的对象
     */

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();


        new Thread(() -> {
            try {
                phone.sendEmail();
                //phone.getHello();
                //phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();

    }

}
