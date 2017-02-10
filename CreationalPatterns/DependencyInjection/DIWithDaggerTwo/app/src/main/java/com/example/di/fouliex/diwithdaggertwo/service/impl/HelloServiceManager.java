package com.example.di.fouliex.diwithdaggertwo.service.impl;

import com.example.di.fouliex.diwithdaggertwo.service.api.HelloService;

/**
 * Created by 212361198 on 2/9/17.
 */

public class HelloServiceManager  implements HelloService{
    @Override
    public String greet(String username) {
        return "Hello " + username + "!";
    }
}
