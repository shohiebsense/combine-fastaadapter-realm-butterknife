package com.shohiebsense.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shohiebsense.myapplication.models.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shohieb on 5/13/2017.
 */

public class ContactItem extends RecyclerView.ViewHolder {
    private static Context context;
    @BindView(R.id.textview_name)
    TextView nameTextView;

    @BindView(R.id.textview_email)
    TextView emailTextView;

    @BindView(R.id.textview_phone)
    TextView phoneTextView;


    public ContactItem(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    void bind(Contact contact){
        nameTextView.setText(contact.getName());
        emailTextView.setText(contact.getEmail());
        phoneTextView.setText(contact.getPhone());

    }


}
