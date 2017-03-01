package com.example.adapterpattern.fouliex.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by George Fouche on 2/28/17.
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

    /**
     * @param position
     * @param convertView - id a "ScrapView". It will have a non-null value when
     *                    the ListView is asking us to recycle the row layout.
     *                    When convertView is not null, we updated its content instead
     *                    of inflating a new row layout.
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //inflate the layout
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceID, parent, false);
        }

        ObjectItem objectItem = data[position];

        TextView textView = (TextView) convertView.findViewById(R.id.textViewItem);
        textView.setText(objectItem.itemName);
        textView.setTag(objectItem.itemID);
        return convertView;
    }
}
