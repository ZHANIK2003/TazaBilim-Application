package com.example.tazabilim;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ResourceActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ResourceCard> resourceCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        Toolbar toolbar = findViewById(R.id.ToolbarResource);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Resources");

        listView = findViewById(R.id.LvResource);
        initializeData();

        ResourceCardAdapter adapter = new ResourceCardAdapter(this, resourceCards);
        listView.setAdapter(adapter);
    }

    private void initializeData() {
        resourceCards = new ArrayList<>();
        resourceCards.add(new ResourceCard("Fundamentals of Database Systems", "An essential guide covering the basic principles and technologies of database management systems. Authored by Ramez Elmasri and Shamkant B. Navathe, first published in 2015.", R.drawable.fundamentals));
        resourceCards.add(new ResourceCard("Modern Android App Development", "A comprehensive resource for developers looking to master the craft of creating applications using the latest Android technologies. Written by Reto Meier, published in 2020.", R.drawable.android));
        resourceCards.add(new ResourceCard("Introduction to Machine Learning", "This book provides a detailed overview of machine learning algorithms and their practical applications. Authored by Ethem Alpaydin, initially released in 2004.", R.drawable.machine));
        resourceCards.add(new ResourceCard("Effective Java", "Best practices and advanced techniques for programming in Java, focusing on language and library features. By Joshua Bloch, first edition published in 2001.", R.drawable.effective));
        resourceCards.add(new ResourceCard("The Art of Computer Programming", "A seminal series of textbooks by Donald Knuth, detailing algorithms, data structures, and programming paradigms. First volume published in 1968.", R.drawable.art));
        resourceCards.add(new ResourceCard("Principles of Cybersecurity", "A guide to the fundamentals of cybersecurity, including strategies to protect networks and data from various threats. Authored by Kevin Redmon, published in 2015.", R.drawable.book6));
        resourceCards.add(new ResourceCard("Advanced Web Metrics with Google Analytics", "Learn how to track and analyze website performance with Google Analytics, optimizing for traffic and user engagement. Written by Brian Clifton, first published in 2008.", R.drawable.book1));
    }

    public class ResourceCard {
        private String title;
        private String description;
        private int imageResId;

        public ResourceCard(String title, String description, int imageResId) {
            this.title = title;
            this.description = description;
            this.imageResId = imageResId;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getImageResId() {
            return imageResId;
        }
    }

    public class ResourceCardAdapter extends ArrayAdapter<ResourceCard> {

        public ResourceCardAdapter(Context context, ArrayList<ResourceCard> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_single_card, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.imageViewCard);
            TextView titleView = convertView.findViewById(R.id.textViewTitle);
            TextView descriptionView = convertView.findViewById(R.id.textViewDescription);

            ResourceCard card = getItem(position);

            imageView.setImageResource(card.getImageResId());
            titleView.setText(card.getTitle());
            descriptionView.setText(card.getDescription());

            return convertView;
        }
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