package com.shohiebsense.myapplication;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.shohiebsense.myapplication.models.Contact;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_contacts)
    RecyclerView contactRecyclerView;
    FastItemAdapter fastItemAdapter = new FastItemAdapter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    void init(){
        fastItemAdapter.withSelectable(true);
        ContactCommands contactCommands = new ContactCommands().init();
        contactCommands.addContacts();
        initRecyclerView();
        contactRecyclerView.setAdapter(fastItemAdapter);
        createItems(contactCommands.getAllContacts());
    }

    public void initRecyclerView(){
        contactRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        contactRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        contactRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void createItems(List<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            ViewItem viewItem = new ViewItem(contact);
            Log.e("shohiebsense for ","anu");
            fastItemAdapter.add(viewItem);
        }
        fastItemAdapter.notifyAdapterDataSetChanged();
    }
}
