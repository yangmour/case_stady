package com.xiwen.homework.homework3.question9;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-19:04
 * @Version: 1.0
 */
public class UserManger {
    private static User[] arr; //存储已经注册的用户
    private static int total; //存储实际注册的用户数量

    public UserManger() {
        arr = new User[5];
    }

    public void checkUsername(String name) throws UserNameAlreadyExistsException {
        for (int i = 0; i < total; i++) {
            boolean equals = arr[i].getName().equals(name);
            if (equals) {
                throw new UserNameAlreadyExistsException("用户名已存在异常");
            }
        }

    }

    public void add(User user) {
        if (total == 5) {
            throw new RuntimeException("账号已满！");
        }
        arr[total++] = user;
    }

    public void login(User user) throws LoginFailException {
        for (int i = 0; i < total; i++) {
            boolean isName = arr[i].getName().equals(user.getName());
            boolean isPass = arr[i].getPassword().equals(user.getPassword());
            if (isName && isPass) {
                return;
            }
        }
        throw new LoginFailException("登陆失败异常！");
    }
}
