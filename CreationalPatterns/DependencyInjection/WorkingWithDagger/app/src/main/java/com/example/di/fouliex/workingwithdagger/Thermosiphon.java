package com.example.di.fouliex.workingwithdagger;

import javax.inject.Inject;

/**
 * Created by 212361198 on 2/10/17.
 */

public class Thermosiphon implements Pump {
    private final Heater heater;

    @Inject
    Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override public void pump() {
        if (heater.isHot()) {
            System.out.println("=> => pumping => =>");
        }
    }
}
