package com.example.tazabilim;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ContactsCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_card);

        Toolbar toolbar = findViewById(R.id.ContToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Contacts");
        }

        ListView listView = findViewById(R.id.contacts_list_view);
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Baizharassov Zhanibek", R.drawable.zhanik, "SIS-2126", "zhako120313@gmail.com", "+7-700-261-36-24"));
        contacts.add(new Contact("Karimzhanov Islambek", R.drawable.islam, "SIS-2126", "islam2003@gmail.com", "+7-707-403-10-03"));
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        listView.setAdapter(adapter);
    }

    public class ContactsAdapter extends ArrayAdapter<Contact> {
        public ContactsAdapter(ContactsCardActivity context, List<Contact> contacts) {
            super(context, 0, contacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Contact contact = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item_card, parent, false);
            }
            TextView contactName = convertView.findViewById(R.id.contact_name);
            TextView contactGroup = convertView.findViewById(R.id.contact_group);
            ImageView contactPhoto = convertView.findViewById(R.id.contact_photo);
            TextView contactEmail = convertView.findViewById(R.id.contact_email);
            TextView contactPhone = convertView.findViewById(R.id.contact_phone);

            contactName.setText(contact.getName());
            contactGroup.setText(contact.getGroup());
            contactPhoto.setImageResource(contact.getPhotoId());
            contactEmail.setText(contact.getEmail());
            contactPhone.setText(contact.getPhone());

            return convertView;
        }
    }

    public class Contact {
        private String name;
        private int photoId;
        private String group;
        private String email;
        private String phone;

        public Contact(String name, int photoId, String group, String email, String phone) {
            this.name = name;
            this.photoId = photoId;
            this.group = group;
            this.email = email;
            this.phone = phone;
        }
        public String getName() { return name; }
        public int getPhotoId() { return photoId; }
        public String getGroup() { return group; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
