package com.example.di.fouliex.workingwithdagger;

import dagger.Component;

/**
 * Created by 212361198 on 2/10/17.
 */
@Component(modules = {SafewayTeaModule.class})
public interface Tea {
    Teapot getTeapot();
}
