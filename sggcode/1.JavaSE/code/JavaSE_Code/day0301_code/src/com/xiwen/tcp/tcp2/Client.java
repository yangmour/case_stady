package com.xiwen.tcp.tcp2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/2-14:27
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9000);

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要上传的文件路径:");
        String nextLine = scanner.nextLine();

        OutputStream os = null;
        ObjectOutputStream oos = null;
        BufferedReader br = null;
        FileInputStream fis = null;
        try {
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            File file = new File(nextLine);
            String fileName = file.getName();

            oos.writeUTF(fileName);

            fis = new FileInputStream(file);

            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                oos.write(data, 0, len);
                System.out.println(len);
            }
            oos.flush();
            socket.shutdownInput();

            String result;
            while ((result = br.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fis.close();
            br.close();
            oos.close();
            os.close();
        }


    }
}
