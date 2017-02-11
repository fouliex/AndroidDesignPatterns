package com.example.di.fouliex.workingwithdagger.di.component;

import com.example.di.fouliex.workingwithdagger.service.impl.CoffeeMaker;
import com.example.di.fouliex.workingwithdagger.di.module.DripCoffeeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A dagger component can be created by annotating the class with @Component annotation.
 * In addition, we need to specify the component's associated modules which
 * a single module DripCoffeeModule.class
 * <p>
 *
 *Since we annotate our component class with @Component, Dagger will generate a builder class for our
 * our component class with the prefix Dagger,therefore DaggerCoffee from the MainActivity class.
 * Created by George Fouche on 2/10/17.
 */
@Singleton
@Component(modules = {DripCoffeeModule.class})
public interface Coffee {
    CoffeeMaker maker();
}
