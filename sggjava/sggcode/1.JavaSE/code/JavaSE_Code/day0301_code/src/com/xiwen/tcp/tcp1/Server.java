package com.xiwen.tcp.tcp1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/1-11:57
 * @Version: 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serve = new ServerSocket(9000);

        while (true) {
            Socket socket = serve.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "连接成功！");

            MessageHandler messageHandler = new MessageHandler(socket);
            messageHandler.start();

        }


    }
}


class MessageHandler extends Thread {

    private Socket socket;

    public MessageHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
                Scanner scanner = new Scanner(socket.getInputStream());
                PrintStream ps = new PrintStream(socket.getOutputStream());) {
            while (scanner.hasNextLine()) {
                //收单词
                String line = scanner.nextLine();

                //单词反转
                String result = new StringBuilder(line).reverse().toString();
                //返回
                ps.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

