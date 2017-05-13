package com.shohiebsense.myapplication;

import android.content.Context;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.shohiebsense.myapplication.models.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shohieb on 5/13/2017.
 */

public class ViewItem<V extends View> extends AbstractItem<ViewItem, ContactItem>   {


    int type;
    Contact contact;

    public ViewItem(Contact contact) {
        this.contact = contact;
    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.id_contact;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.item_contact;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ContactItem viewHolder, List payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);
        viewHolder.bind(contact);
    }

    @Override
    public ContactItem getViewHolder(View v) {
        return new ContactItem(v);
    }
}
