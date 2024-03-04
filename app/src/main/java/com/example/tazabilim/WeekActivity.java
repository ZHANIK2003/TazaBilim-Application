package com.example.tazabilim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class WeekActivity extends AppCompatActivity {

    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        Toolbar toolbar = findViewById(R.id.ToolbarWeek);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Week");
        }

        listView = findViewById(R.id.LvWeek);
        setupListView();
        sharedPreferences = getSharedPreferences("MY_DAY", MODE_PRIVATE);
    }


    private void setupListView() {
        String[] week = getResources().getStringArray(R.array.week);

        WeekAdapter adapter = new WeekAdapter(this, R.layout.week_single_item, week);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:{
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY,"Monday").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Tuesday").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Wednesday").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Thursday").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Friday").apply();
                        break;
                    }
                    case 5: {
                        startActivity(new Intent(WeekActivity.this,DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Saturday").apply();
                        break;
                    }
                    default: break;
                }
            }
        });
    }

    public class WeekAdapter extends ArrayAdapter<String> {
        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week;
        private int[] images = {
                R.drawable.monday,
                R.drawable.tuesday,
                R.drawable.wednesday,
                R.drawable.thursday,
                R.drawable.friday,
                R.drawable.saturday
        };

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, parent, false);
                holder.ivLogo = convertView.findViewById(R.id.IvDay);
                holder.tvWeek = convertView.findViewById(R.id.TvDay);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvWeek.setText(getItem(position));
            if (position >= 0 && position < images.length) {
                holder.ivLogo.setImageResource(images[position]); // Set the image for the current day
            }

            return convertView;
        }

         class ViewHolder {
            ImageView ivLogo;
            TextView tvWeek;
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