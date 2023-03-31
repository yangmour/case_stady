package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:15
 * @Version: 1.0
 */

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class Homework12 {
    public static void main(String[] args) {

        User[] users = new User[3];
        users[0] = new User("aaa", "bbb");
        users[1] = new User("ccc", "aaa");
        users[2] = new User("ddd", "fffff");


        boolean flag = false;
        User login = new User("aaa", "bbb");
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(login.getName()) && users[i].getPassword().equals(login.getPassword())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("登陆失败");
        } else {
            System.out.println("验证成功！");

        }

    }
}
