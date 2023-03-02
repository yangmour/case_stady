package com.xiwen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/1-11:30
 * @Version: 1.0
 */
public class Receive {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(8888);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 0, 1024);

        ds.receive(dp);

        System.out.println("接受的消息:" + new String(dp.getData(), 0, dp.getLength()));
        ds.close();
    }
}
