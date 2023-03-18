package com.xiwen.exercise;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/18 -10:11
 * @Version: 1.0
 */
public class User {
    private String user;
    private String password;
    private String age;
    private String gender;
    private String[] hobby;
    private String email;

    public User() {
    }

    public User(String user, String password, String age, String gender, String[] hobby, String email) {
        this.user = user;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", email='" + email + '\'' +
                '}';
    }
}

