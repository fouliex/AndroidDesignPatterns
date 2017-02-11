package com.example.di.fouliex.workingwithdagger.di.module;

import com.example.di.fouliex.workingwithdagger.service.api.Pump;
import com.example.di.fouliex.workingwithdagger.service.impl.Thermosiphon;

import dagger.Binds;
import dagger.Module;

/**
 * Created by George Fouche on 2/10/17.
 */
@Module
public abstract class PumpModule {
    @Binds
    abstract Pump providePump(Thermosiphon pump);
}