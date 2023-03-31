package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:21
 * @Version: 1.0
 */
public class InvalidValueException extends Exception{

    public InvalidValueException() {
    }

    public InvalidValueException(String message) {
        super(message);
    }
}
