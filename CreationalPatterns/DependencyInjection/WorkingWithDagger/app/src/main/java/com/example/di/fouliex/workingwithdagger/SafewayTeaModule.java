package com.example.di.fouliex.workingwithdagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module
public class SafewayTeaModule {
    @Provides Teapot providesTeapot() {
        return new StarbuckTeapot(new ElectricHeater(), new SafewayEarlGreyDrink());
    }

}
