package com.xiwen.jvm;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/29 -16:25
 * @Version: 1.0
 */
public class JvmTest {

    public static void main(String[] args) {
        System.out.print("最大堆大小：");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("当前堆大小：");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
        System.out.println("==================================================");

        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }
}
