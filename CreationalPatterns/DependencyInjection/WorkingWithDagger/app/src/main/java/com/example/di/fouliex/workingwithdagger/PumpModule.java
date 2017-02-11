package com.example.di.fouliex.workingwithdagger;

import dagger.Binds;
import dagger.Module;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module
abstract class PumpModule {
    @Binds
    abstract Pump providePump(Thermosiphon pump);
}