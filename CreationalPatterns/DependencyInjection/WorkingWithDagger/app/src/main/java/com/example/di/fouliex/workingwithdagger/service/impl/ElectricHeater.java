package com.example.di.fouliex.workingwithdagger.service.impl;

import android.util.Log;

import com.example.di.fouliex.workingwithdagger.service.api.Heater;

/**
 * Created by George Fouche on 2/10/17.
 */
public class ElectricHeater implements Heater {
    private static final String TAG = ElectricHeater.class.getName();
    boolean heating;

    @Override
    public void on() {
        Log.d(TAG, "~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}