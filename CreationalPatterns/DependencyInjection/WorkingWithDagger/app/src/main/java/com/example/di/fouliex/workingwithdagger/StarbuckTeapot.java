package com.example.di.fouliex.workingwithdagger;

import com.example.di.fouliex.workingwithdagger.service.Drink;
import com.example.di.fouliex.workingwithdagger.service.api.Heater;

import javax.inject.Inject;

/**
 * Created by 212361198 on 2/10/17.
 */
public class StarbuckTeapot implements Teapot {
    Heater heater;
    Drink drink;

    @Inject
    public StarbuckTeapot(Heater heater, Drink drink) {
        this.heater = heater;
        this.drink = drink;
    }

    @Override
    public Drink brew() {
        return drink;
    }

}
