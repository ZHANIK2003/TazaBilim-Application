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
import com.example.tazabilim.R;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация Toolbar
        Toolbar toolbar = findViewById(R.id.ToolbarMain);
        setSupportActionBar(toolbar);

        // Получение ActionBar и установка заголовка
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("TazaBilim");
        }

        // Инициализация ListView и настройка адаптера
        listView = findViewById(R.id.LvMain);
        setupListView();
    }

    private void setupListView() {

        String[] titles = getResources().getStringArray(R.array.Main);
        String[] descriptions = getResources().getStringArray(R.array.Description);

        // Установка адаптера для ListView
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, titles, descriptions);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7: {
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private String[] titleArray;
        private String[] descriptionArray;

        public SimpleAdapter(Context context, String[] titles, String[] descriptions) {
            mContext = context;
            titleArray = titles;
            descriptionArray = descriptions;
            layoutInflater = LayoutInflater.from(context);
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
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, null);
            }
            TextView title = convertView.findViewById(R.id.TvMain);
            TextView description = convertView.findViewById(R.id.TvDescription);
            ImageView imageView = convertView.findViewById(R.id.IvMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            // Установка изображений в зависимости от заголовка
            if (titleArray[position].equalsIgnoreCase("Time Table")) {
                imageView.setImageResource(R.drawable.timetable);
            } else if (titleArray[position].equalsIgnoreCase("Articles")) {
                imageView.setImageResource(R.drawable.articles);
            } else if (titleArray[position].equalsIgnoreCase("App Policy")) {
                imageView.setImageResource(R.drawable.apppolicy);
            } else if (titleArray[position].equalsIgnoreCase("Events")){
                imageView.setImageResource(R.drawable.event);
            }else if (titleArray[position].equalsIgnoreCase("News")) {
                imageView.setImageResource(R.drawable.news);
            }else if (titleArray[position].equalsIgnoreCase("Study Tools")) {
                imageView.setImageResource(R.drawable.study);
            }else if (titleArray[position].equalsIgnoreCase("Resource Library")) {
                imageView.setImageResource(R.drawable.books);
            }else{
                imageView.setImageResource(R.drawable.contacts);
            }
            return convertView;
        }
    }
}
