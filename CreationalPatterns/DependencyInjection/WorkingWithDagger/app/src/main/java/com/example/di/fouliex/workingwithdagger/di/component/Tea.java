package com.example.di.fouliex.workingwithdagger.di.component;

import com.example.di.fouliex.workingwithdagger.service.api.Teapot;
import com.example.di.fouliex.workingwithdagger.di.module.SafewayTeaModule;

import dagger.Component;

/**
 * A dagger component can be create by annotating the class with @Component annotation.
 * In addition, we need to specify the component's associated modules which a single module
 * SafewayTeaModule.class
 *
 * Since we annotate our component class with @Component, Dagger will generate a builder class for
 * our component class with the prefix Dagger,therefore  DaggerTea from the MainActivity class.
 * Created by George Fouche on 2/10/17.
 */
@Component(modules = {SafewayTeaModule.class})
public interface Tea {
    Teapot getTeapot();
}
