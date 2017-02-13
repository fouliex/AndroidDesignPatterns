package com.example.singleton.fouli.loginactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView textWelcome = (TextView) findViewById(R.id.txtWelcome);

        //Displaying the username using the Singleton class
        textWelcome.setText("Welcome\n" + SingletonSession.Instance().getUsername());
    }

}
