package com.example.di.fouliex.workingwithdagger.service.impl;

import com.example.di.fouliex.workingwithdagger.service.Drink;

/**
 * Created by 212361198 on 2/10/17.
 */
public class SafewayEarlGreyDrink implements Drink {
    @Override
    public String getFlavor() {
        return "Earl Grey";
    }
}
