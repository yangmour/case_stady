package com.xiwen.io.exercise;

import org.junit.Test;

import java.io.*;


public class AccountTest {


    @Test
    public void test1() throws IOException {
        Account.setRate(0.0035);
        Account account = new Account("1111", 1000);
        System.out.println(account);

        FileOutputStream fileOutputStream = new FileOutputStream("iotest/bank.bat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(account);

        objectOutputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        Account.setRate(0.03);
        Account account2 = new Account("22222", 2000);

        FileInputStream fileInputStream = new FileInputStream("iotest/bank.bat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

        System.out.println(o);
        System.out.println(account2);

        Account account1 = null;
        if (o instanceof Account) {
            account1 = (Account) o;
        }

        FileOutputStream fileOutputStream = new FileOutputStream("iotest/bank.bat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(account1);
        objectOutputStream.writeObject(account2);

        objectOutputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void test3() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("iotest/bank.bat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o1 = objectInputStream.readObject();
        Object o2 = objectInputStream.readObject();

        System.out.println(o1);
        System.out.println(o2);


        objectInputStream.close();
        fileInputStream.close();

    }
}

class Account implements Serializable {
    public static final long serialVersionUID = 1L;
    private static double rate;
    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        Account.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double annualInterest() {
        return balance * rate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ",年利息=" + annualInterest() +
                '}';
    }
}
