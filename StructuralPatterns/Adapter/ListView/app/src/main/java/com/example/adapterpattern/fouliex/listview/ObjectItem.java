package com.example.adapterpattern.fouliex.listview;

/**
 * Each item in the list is considered as an object with a name and ID.
 * Created by George Erol Fouche on 2/28/17.
 */
public class ObjectItem {

    public int itemID;
    public String itemName;

    public ObjectItem(int itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }


}
