package com.xiwen.base;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/25 -22:42
 * @Version: 1.0
 */
public class User {
    private String username;
    private String password;
    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
