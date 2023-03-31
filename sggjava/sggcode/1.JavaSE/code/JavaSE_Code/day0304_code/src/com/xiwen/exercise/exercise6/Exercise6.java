package com.xiwen.exercise.exercise6;


import java.util.Optional;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-21:53
 * @Version: 1.0
 */
public class Exercise6 {

    public static Optional<Girl> getGirlFriend(Boy boy) {
        return Optional.ofNullable(boy.getGirl());
    }

    public static void main(String[] args) {
        Boy boy = new Boy("小明");
        Optional<Girl> girlFriend = getGirlFriend(boy);
        Girl girl = girlFriend.orElse(new Girl("嫦娥"));
        System.out.println(girl);

        System.out.println("a");
        Optional.of(boy).ifPresent(System.out::println);
    }

}
