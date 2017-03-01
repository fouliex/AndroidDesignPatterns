package com.example.adapterpattern.fouliex.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 212361198 on 2/28/17.
 */

public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {
    Context context;
    int layoutResourceID;
    ObjectItem data[] = null;


    public ArrayAdapterItem(Context context, int layoutResourceID, ObjectItem[] data) {
        super(context, layoutResourceID, data);

        this.layoutResourceID = layoutResourceID;
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            //inflate the layout
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceID,parent,false);
        }

        ObjectItem objectItem = data[position];

        TextView textView = (TextView) convertView.findViewById(R.id.textViewItem);
        textView.setText(objectItem.itemName);
        textView.setTag(objectItem.itemID);
        return convertView;
    }
}
