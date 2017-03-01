package com.example.adapterpattern.fouliex.listview;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by George Fouche on 2/28/17.
 */

public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener{


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Context context = view.getContext();
        TextView textView = (TextView) view.findViewById(R.id.textViewItem);


        String listItemText = textView.getText().toString();
        String listItemID = textView.getTag().toString();

        Toast.makeText(context, "Item: " + listItemText + ", Item ID: " + listItemID, Toast.LENGTH_SHORT).show();

        ((MainActivity) context).alertDialogStores.cancel();


    }


}
