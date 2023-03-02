package com.xiwen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/1-11:23
 * @Version: 1.0
 */
public class Send {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();
        byte[] data = "你好呀".getBytes();

//        "192.168.34.61"
        byte[] bytes = {(byte) 192, (byte) 168, 34, 61};
        InetAddress ip = InetAddress.getByAddress(bytes);

        DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length
                , new InetSocketAddress(ip, 8888));

        ds.send(datagramPacket);

        ds.close();

    }
}
