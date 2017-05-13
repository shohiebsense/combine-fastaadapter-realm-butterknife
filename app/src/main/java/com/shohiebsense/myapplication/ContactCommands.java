package com.shohiebsense.myapplication;

import com.shohiebsense.myapplication.models.Contact;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Shohieb on 5/13/2017.
 */

public class ContactCommands {


    Realm realm;
    ContactCommands init(){
        realm = Realm.getDefaultInstance();
        return this;
    }

    public String random(String prefix){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int randomLength = random.nextInt(7);
        char tempChar;
        for(int i =0;i<randomLength;i++){
            tempChar = (char) (random.nextInt(96) + 32);
            sb.append(prefix + tempChar);
        }
        return sb.toString();
    }

    public Contact addContact(int id){
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(random("nama "));
        contact.setEmail(random("email :"));
        contact.setPhone(random("phone : "));
        return contact;
    }

    public void addContacts(){
        realm.beginTransaction();
        realm.where(Contact.class).findAll().deleteAllFromRealm();
        for(int i = 0; i<5;i++){
            Number id = realm.where(Contact.class).max("id");
            if(id == null){
                id = 1;
            }
            else{
                id = id.intValue() + 1;
            }
            realm.copyToRealm(addContact(id.intValue()));
        }
        realm.commitTransaction();
    }

    public RealmResults<Contact> getAllContacts(){
        return realm.where(Contact.class).findAll();
    }
}
