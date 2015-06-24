package com.example.MyContacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.MyContacts.data.Contact;

/**
 * Created by fcecursos on 23/06/2015.
 */
public class ShowContactActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_contact);
        String[] values = getContactNames();
        ListView listview = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView) view).getText().toString();
                Contact contact = ((MyContacts) getApplicationContext()).searchContactByName(name);
                Toast.makeText(getApplicationContext(),
                        getString(R.string.name_label) + getString(R.string.colon_label) + contact.getName() + getString(R.string.comma_label)
                                + getString(R.string.email_label) + getString(R.string.colon_label) + contact.getEmail() + getString(R.string.comma_label)
                                + getString(R.string.phone_label) + getString(R.string.colon_label) + contact.getPhone() + getString(R.string.comma_label)
                                + getString(R.string.address_label) + getString(R.string.colon_label) + contact.getAddress()
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    public String[] getContactNames() {
        int size = ((MyContacts) getApplicationContext()).myContacts.size();
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = ((MyContacts) getApplicationContext()).myContacts.get(i).getName();
        }
        return names;
    }
}