package com.example.di.fouliex.workingwithdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.di.fouliex.workingwithdagger.di.component.Coffee;
import com.example.di.fouliex.workingwithdagger.di.component.DaggerCoffee;
import com.example.di.fouliex.workingwithdagger.di.component.DaggerTea;
import com.example.di.fouliex.workingwithdagger.di.component.Tea;
import com.example.di.fouliex.workingwithdagger.service.Drink;

/**
 * Dagger  2 is a dependency injection framework that is build on the
 * standard javax.inject annotations (JSR 330).
 * <p>
 * Dependency injection is a software design pattern that implements inversion
 * of control for resolving dependencies.By implementing it properly in our application,
 * It allows us to have:
 *  1. Testable classes.
 *  2. Re-usable and interchangeable components.
 *
 *
 * Module
 * A dagger module provides the way that constructs the objects which will be injected.
 * In order to define a dagger module, create a class and annotate it with @Module annotation
 * and define the provider methods that return the instances.Provider methods have to be annotaged
 * by @Provider annotation as shown from this project module classes from the module package.
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Coffee coffee = DaggerCoffee.builder().build();
        coffee.maker().brew();


        Tea tea = DaggerTea.builder().build();
        Teapot teapot = tea.getTeapot();
        Drink drink = teapot.brew();
        Log.d(getClass().getName(), "Our drink is flavored " + drink.getFlavor());


        setContentView(R.layout.activity_main);
    }
}
