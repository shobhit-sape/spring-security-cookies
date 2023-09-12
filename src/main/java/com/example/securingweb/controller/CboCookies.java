package com.example.securingweb.controller;

import java.io.Serializable;

public class CboCookies implements Serializable {

    private String cookie;

    public CboCookies(String cookie) {
        this.cookie = cookie;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "CboCookies{" +
                "cookie='" + cookie + '\'' +
                '}';
    }
}
