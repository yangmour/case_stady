package com.xiwen.tcp.tcp1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",9000);
        Scanner keyBoardInput = new Scanner(System.in);//从键盘输入
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner serverInput = new Scanner(inputStream);

        while(true){
            System.out.print("请输入要发生的单词：");
            String word = keyBoardInput.next();

            if("stop".equalsIgnoreCase(word)){
                break;
            }
            //先发生本次的单词
            outputStream.write((word+"\n").getBytes());

            //接收本次服务器反转的结果
            String reverseResult = serverInput.nextLine();
            System.out.println("反转的结果：" + reverseResult);
            /*byte[] data = new byte[1024];
            int len;
            while((len = inputStream.read(data)) != -1){
                System.out.println(new String(data,0,len));
            }*/
        }

        serverInput.close();
        inputStream.close();
        outputStream.close();
        keyBoardInput.close();
        socket.close();
    }
}
