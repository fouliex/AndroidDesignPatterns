package com.example.di.fouliex.workingwithdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module(includes = PumpModule.class)
class DripCoffeeModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
