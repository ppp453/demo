package com.example.demo.utils;

import com.example.demo.domain.TbUser;

public class LoginUtil {

    private static ThreadLocal<TbUser> threadLocal = new ThreadLocal<>();

    public static void setUser(TbUser user){
        threadLocal.set(user);
    }

    public static TbUser get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
