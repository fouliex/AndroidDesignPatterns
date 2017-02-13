package com.example.singleton.fouli.loginactivity;

/**
 * Created by 212361198 on 2/13/17.
 */

public class SingletonSession {
    private static SingletonSession instance;
    private String username;

    // no class can initialize this class's object
    private SingletonSession() {

    }

    public static SingletonSession Instance() {
        // If no instance is initialized yet then create new instance
        if (instance == null) {
            instance = new SingletonSession();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
