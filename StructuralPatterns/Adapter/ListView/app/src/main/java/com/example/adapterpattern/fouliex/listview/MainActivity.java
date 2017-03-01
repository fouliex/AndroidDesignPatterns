package com.example.adapterpattern.fouliex.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AlertDialog alertDialogStores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        View.OnClickListener handler = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonShowPopUp:
                        showPopUp();
                        break;
                }
            }
        };

        findViewById(R.id.buttonShowPopUp).setOnClickListener(handler);
    }

    private void showPopUp() {
        ObjectItem objectItemData;
    }
}
