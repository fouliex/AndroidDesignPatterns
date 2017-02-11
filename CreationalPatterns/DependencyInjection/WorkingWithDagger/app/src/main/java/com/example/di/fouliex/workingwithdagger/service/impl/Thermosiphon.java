package com.example.di.fouliex.workingwithdagger.service.impl;

import android.util.Log;

import com.example.di.fouliex.workingwithdagger.service.api.Pump;
import com.example.di.fouliex.workingwithdagger.service.api.Heater;

import javax.inject.Inject;

/**
 * Created by George Fouche on 2/10/17.
 */

public class Thermosiphon implements Pump {
    private static final String TAG = Thermosiphon.class.getName();
    private final Heater heater;

    @Inject
    Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            Log.d(TAG, "=> => pumping => =>");
        }
    }
}
