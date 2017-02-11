package com.example.di.fouliex.workingwithdagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 212361198 on 2/10/17.
 */
@Singleton
@Component(modules = {DripCoffeeModule.class})
public interface Coffee {
    CoffeeMaker maker();
}
