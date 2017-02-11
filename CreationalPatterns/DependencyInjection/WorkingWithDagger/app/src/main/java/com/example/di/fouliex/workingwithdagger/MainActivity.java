package com.example.di.fouliex.workingwithdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        Coffee coffee = DaggerCoffee.builder().build();
        coffee.maker().brew();


        Tea tea = DaggerTea.builder().build();
        Teapot teapot = tea.getTeapot();
        Drink drink  = teapot.brew();
        Log.d(getClass().getName(),"Our drink is flavored " + drink.getFlavor());


        setContentView(R.layout.activity_main);
    }
}
