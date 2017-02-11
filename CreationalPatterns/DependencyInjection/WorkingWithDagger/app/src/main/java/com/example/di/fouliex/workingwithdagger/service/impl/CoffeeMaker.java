package com.example.di.fouliex.workingwithdagger.service.impl;

import android.util.Log;

import com.example.di.fouliex.workingwithdagger.service.api.Heater;
import com.example.di.fouliex.workingwithdagger.service.api.Pump;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by George Fouche on 2/10/17.
 */

public class CoffeeMaker {
    private static final String TAG = CoffeeMaker.class.getName();
    private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.
    private final Pump pump;

    @Inject
    CoffeeMaker(Lazy<Heater> heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.get().on();
        pump.pump();
        Log.d(TAG," [_]P coffee! [_]P ");
        heater.get().off();
    }
}
