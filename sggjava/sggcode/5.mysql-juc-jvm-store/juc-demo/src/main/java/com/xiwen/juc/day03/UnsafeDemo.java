package com.xiwen.juc.day03;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {

    private int number = 0;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * CAS：Compare and Swap。比较并交换的意思。
         * CAS操作有3个基本参数：内存地址A，旧值B，新值C。
         * 它的作用是将指定内存地址A的内容与所给的旧值B相比，如果相等，则将其内容替换为指令中提供的新值C；
         * 如果不等，则更新失败。类似于修改登陆密码的过程。
         * 当用户输入的原密码和数据库中存储的原密码相同，才可以将原密码更新为新密码，否则就不能更新。
         */
        UnsafeDemo unsafeDemo = new UnsafeDemo();
        System.out.println(unsafeDemo.number);// 修改前 0
        unsafeDemo.compareAndSwap(0, 30);
        System.out.println(unsafeDemo.number);// 修改后 30
    }

    public void compareAndSwap(int oldValue, int newValue) {
        try {
            // 通过反射获取Unsafe类中的theUnsafe对象
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true); // 设置为可见
            Unsafe unsafe = (Unsafe) theUnsafe.get(null); // 获取Unsafe对象
            // 获取number的偏移量
            long offset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("number"));
            // cas操作
            unsafe.compareAndSwapInt(this, offset, oldValue, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}