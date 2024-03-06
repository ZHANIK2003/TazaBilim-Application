package com.example.tazabilim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.ToolbarMain);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Taza Bilim");
        }

        listView = findViewById(R.id.LvMain);
        setupListView();
    }

    private void setupListView() {
        String[] titles = getResources().getStringArray(R.array.Main);
        String[] descriptions = getResources().getStringArray(R.array.Description);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, titles, descriptions);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 1){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 2){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 3){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 4){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 5){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            } else if(position == 6){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }else if(position == 7){
                startActivity(new Intent(MainActivity.this, WeekActivity.class));
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {
        private final Context mContext;
        private final LayoutInflater layoutInflater;
        private final String[] titleArray;
        private final String[] descriptionArray;
        private final Map<String, Integer> imageMap;

        public SimpleAdapter(Context context, String[] titles, String[] descriptions) {
            this.mContext = context;
            this.titleArray = titles;
            this.descriptionArray = descriptions;
            this.layoutInflater = LayoutInflater.from(context);
            this.imageMap = initializeImageMap();
        }

        private Map<String, Integer> initializeImageMap() {
            Map<String, Integer> map = new HashMap<>();
            map.put("Schedule", R.drawable.timetable);
            map.put("Articles", R.drawable.articles);
            map.put("App Policy", R.drawable.apppolicy);
            map.put("Events", R.drawable.event);
            map.put("News", R.drawable.news);
            map.put("Study Tools", R.drawable.study);
            map.put("Resource Library", R.drawable.books);
            map.put("Contacts", R.drawable.contacts);
            return map;
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, parent, false);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.TvMain);
                holder.description = convertView.findViewById(R.id.TvDescription);
                holder.imageView = convertView.findViewById(R.id.IvMain);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            String title = titleArray[position];
            holder.title.setText(title);
            holder.description.setText(descriptionArray[position]);
            Integer imageResId = imageMap.get(title);
            if (imageResId != null) {
                holder.imageView.setImageResource(imageResId);
                holder.imageView.setVisibility(View.VISIBLE);
            } else {
                holder.imageView.setVisibility(View.GONE); // Or set a default image
            }

            return convertView;
        }

        class ViewHolder {
            TextView title;
            TextView description;
            ImageView imageView;
        }
    }
}
