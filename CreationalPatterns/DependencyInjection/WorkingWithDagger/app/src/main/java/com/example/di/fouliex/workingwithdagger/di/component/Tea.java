package com.example.di.fouliex.workingwithdagger.di.component;

import com.example.di.fouliex.workingwithdagger.Teapot;
import com.example.di.fouliex.workingwithdagger.di.module.SafewayTeaModule;

import dagger.Component;

/**
 * Created by 212361198 on 2/10/17.
 */
@Component(modules = {SafewayTeaModule.class})
public interface Tea {
    Teapot getTeapot();
}
