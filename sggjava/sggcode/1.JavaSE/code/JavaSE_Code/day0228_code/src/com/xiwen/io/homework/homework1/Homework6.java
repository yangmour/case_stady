package com.xiwen.io.homework.homework1;

import org.junit.Test;

import java.io.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/28-19:20
 * @Version: 1.0
 */
public class Homework6 {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        Message msg = new Message("张三", "李四", "加工资", System.currentTimeMillis());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("message.dat"));
        objectOutputStream.writeObject(msg);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("message.dat"));
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();


    }
}

class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fromUser;
    private String toUser;
    private String content;
    private long sendTime;

    public Message(String fromUser, String toUser, String content, long sendTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}