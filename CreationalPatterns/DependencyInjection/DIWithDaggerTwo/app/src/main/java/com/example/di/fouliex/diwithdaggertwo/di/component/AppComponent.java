package com.example.di.fouliex.diwithdaggertwo.di.component;

import com.example.di.fouliex.diwithdaggertwo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 212361198 on 2/10/17.
 */
@Singleton
@Component(modules = {AppModule.class,})
public class AppComponent {
}
