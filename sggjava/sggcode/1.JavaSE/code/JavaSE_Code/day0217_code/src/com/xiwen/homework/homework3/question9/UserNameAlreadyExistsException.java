package com.xiwen.homework.homework3.question9;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-19:02
 * @Version: 1.0
 */
public class UserNameAlreadyExistsException extends Exception{

    public UserNameAlreadyExistsException() {
    }


    public UserNameAlreadyExistsException(String message) {
        super(message);
    }
}
