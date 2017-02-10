package com.test.xyz.daggersample.view.fragment.weather;

import com.test.xyz.daggersample.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = {WeatherFragmentModule.class}
)
public interface WeatherFragmentComponent {
    void inject(WeatherFragment mainFragment);
}

