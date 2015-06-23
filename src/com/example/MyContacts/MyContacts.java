package com.example.MyContacts;

import android.app.Application;
import com.example.MyContacts.data.Contact;
import java.util.ArrayList;

/**
 * Created by fcecursos on 23/06/2015.
 */
public class MyContacts extends Application {
    public ArrayList<Contact> myContacts;

    public MyContacts() {
        myContacts = new ArrayList<Contact>();
    }

    public Contact serachContactByName(String name){
        Contact mycontact = null;
        for(Contact contact: myContacts){
            if(contact.getName()==name){
                mycontact = contact;
                break;
            }
        }
        return mycontact;
    }
}
