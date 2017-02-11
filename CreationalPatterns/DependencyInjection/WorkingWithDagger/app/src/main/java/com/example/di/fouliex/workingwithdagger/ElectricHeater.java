package com.example.di.fouliex.workingwithdagger;

/**
 * Created by 212361198 on 2/10/17.
 */
class ElectricHeater implements Heater {
    boolean heating;

    @Override public void on() {
        System.out.println("~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    @Override public void off() {
        this.heating = false;
    }

    @Override public boolean isHot() {
        return heating;
    }
}