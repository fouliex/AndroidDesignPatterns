package com.example.singleton.fouli.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * The LoginActivity class has an instance of SingleSession class.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final EditText editUsername = (EditText) findViewById(R.id.editUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // On Loging button click, store our username into the Singleton class.
                SingletonSession.Instance().setUsername(editUsername.getText().toString());

                Intent welcomeActivity = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(welcomeActivity);
            }
        });
    }
}
