package com.example.di.fouliex.diwithdaggertwo.di.module;

import com.example.di.fouliex.diwithdaggertwo.di.scope.DaggerApplication;

import dagger.Module;

/**
 * Created by 212361198 on 2/10/17.
 */
@Module
public class AppModule {
    DaggerApplication app;

    public AppModule(DaggerApplication application){
        app =application;
    }



}
