package com.example.di.fouliex.workingwithdagger.di.module;

import com.example.di.fouliex.workingwithdagger.Pump;
import com.example.di.fouliex.workingwithdagger.Thermosiphon;

import dagger.Binds;
import dagger.Module;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module
public abstract class PumpModule {
    @Binds
    abstract Pump providePump(Thermosiphon pump);
}