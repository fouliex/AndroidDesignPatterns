package com.example.di.fouliex.workingwithdagger.di.module;

import com.example.di.fouliex.workingwithdagger.service.impl.ElectricHeater;
import com.example.di.fouliex.workingwithdagger.service.impl.SafewayEarlGreyDrink;
import com.example.di.fouliex.workingwithdagger.service.impl.StarbuckTeapot;
import com.example.di.fouliex.workingwithdagger.service.api.Teapot;

import dagger.Module;
import dagger.Provides;

/**
 * Created by George Fouche on 2/10/17.
 */
@Module
public class SafewayTeaModule {
    @Provides
    Teapot providesTeapot() {
        return new StarbuckTeapot(new ElectricHeater(), new SafewayEarlGreyDrink());
    }

}
