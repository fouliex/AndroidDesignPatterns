package com.example.di.fouliex.workingwithdagger.di.module;

import com.example.di.fouliex.workingwithdagger.ElectricHeater;
import com.example.di.fouliex.workingwithdagger.Heater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module(includes = PumpModule.class)
public class DripCoffeeModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
