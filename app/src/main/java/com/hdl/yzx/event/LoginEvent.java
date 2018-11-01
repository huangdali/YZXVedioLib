package com.hdl.yzx.event;

/**
 * 登录的事件
 * Created by HDL on 2018/10/31.
 */

public class LoginEvent {
    private String token;

    public LoginEvent() {
    }

    public LoginEvent(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "token='" + token + '\'' +
                '}';
    }
}
