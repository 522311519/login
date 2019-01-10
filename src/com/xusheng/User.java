package com.xusheng;
/**
 * @author xk
 * @date 2019/1/10 09:38:18
 * @description 用户
 */
public class User {
    String name;
    String key;
    String email;

    public User() {

    }

    public User(String name, String key, String email) {
        this.name = name;
        this.email = email;
        this.key = key;
    }
}
