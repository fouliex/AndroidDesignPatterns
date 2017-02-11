package com.example.di.fouliex.workingwithdagger.di.component;

import com.example.di.fouliex.workingwithdagger.CoffeeMaker;
import com.example.di.fouliex.workingwithdagger.di.module.DripCoffeeModule;

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
