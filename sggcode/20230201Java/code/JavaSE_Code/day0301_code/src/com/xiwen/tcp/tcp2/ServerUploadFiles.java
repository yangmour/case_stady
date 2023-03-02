package com.xiwen.tcp.tcp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/2-13:56
 * @Version: 1.0
 */
public class ServerUploadFiles {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9000);

        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "连接成功!");
            Thread t = new MessageUpload(socket);
            t.start();
        }

    }
}

class MessageUpload extends Thread {
    private Socket socket;

    public MessageUpload(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        FileOutputStream fos = null;
        try {
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            os = socket.getOutputStream();

            String fileName = ois.readUTF();
            String ip = socket.getInetAddress().getHostAddress();
            long timeMillis = System.currentTimeMillis();

            String newFileName = ip + "_" + timeMillis + "_" + fileName;

            fos = new FileOutputStream("upload/" + newFileName);

            byte[] data = new byte[1024];
            int len;

            while ((len = ois.read(data)) != -1) {
                fos.write(data, 0, len);
            }
            //及时将数据保存到本地，重要！
            fos.flush();

            os.write((fileName + "服务器端接收文件完毕！").getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
