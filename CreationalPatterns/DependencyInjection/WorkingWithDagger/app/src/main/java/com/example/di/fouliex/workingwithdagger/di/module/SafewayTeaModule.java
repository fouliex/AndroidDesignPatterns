package com.example.di.fouliex.workingwithdagger.di.module;

import com.example.di.fouliex.workingwithdagger.ElectricHeater;
import com.example.di.fouliex.workingwithdagger.SafewayEarlGreyDrink;
import com.example.di.fouliex.workingwithdagger.StarbuckTeapot;
import com.example.di.fouliex.workingwithdagger.Teapot;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module
public class SafewayTeaModule {
    @Provides
    Teapot providesTeapot() {
        return new StarbuckTeapot(new ElectricHeater(), new SafewayEarlGreyDrink());
    }

}
