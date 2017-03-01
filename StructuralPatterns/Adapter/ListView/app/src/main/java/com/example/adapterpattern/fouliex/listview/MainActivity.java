package com.example.adapterpattern.fouliex.listview;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 *MainActivity  shows  the main layout where a button is located in the center of the
 * screen. When clicking the button a pop up Listview is shown.
 */
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

        //Sample items
        ObjectItem[] objectItemData = new ObjectItem[20];
        objectItemData[0] = new ObjectItem(91, "Mercury");
        objectItemData[1] = new ObjectItem(92, "Watson");
        objectItemData[2] = new ObjectItem(93, "Nissan");
        objectItemData[3] = new ObjectItem(94, "Puregold");
        objectItemData[4] = new ObjectItem(95, "SM");
        objectItemData[5] = new ObjectItem(96, "7 Eleven");
        objectItemData[6] = new ObjectItem(97, "Ministop");
        objectItemData[7] = new ObjectItem(98, "Fat Chicken");
        objectItemData[8] = new ObjectItem(99, "Master Siomai");
        objectItemData[9] = new ObjectItem(100, "Mang Inasal");
        objectItemData[10] = new ObjectItem(101, "Mercury 2");
        objectItemData[11] = new ObjectItem(102, "Watson 2");
        objectItemData[12] = new ObjectItem(103, "Nissan 2");
        objectItemData[13] = new ObjectItem(104, "Puregold 2");
        objectItemData[14] = new ObjectItem(105, "SM 2");
        objectItemData[15] = new ObjectItem(106, "7 Eleven 2");
        objectItemData[16] = new ObjectItem(107, "Ministop 2");
        objectItemData[17] = new ObjectItem(108, "Fat Chicken 2");
        objectItemData[18] = new ObjectItem(109, "Master Siomai 2");
        objectItemData[19] = new ObjectItem(110, "Mang Inasal 2");

        // The adapter instance
        ArrayAdapter adapter = new ArrayAdapterItem(this,R.layout.list_view_row_item,objectItemData);

        //Create a new ListView and setting the adapter and item click listener
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListenerListViewItem());

        //pup the ListView into aw pop up
        alertDialogStores = new AlertDialog.Builder(MainActivity.this)
                .setView(listView)
                .setTitle("Stores")
                .show();

    }
}
