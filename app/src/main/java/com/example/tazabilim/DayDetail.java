package com.example.tazabilim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DayDetail extends AppCompatActivity {

    private ListView listView;

    // Предполагается, что значения для этих массивов будут инициализированы в методе setupListView()
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] time1;
    public static String[] time2;
    public static String[] time3;
    public static String[] time4;
    public static String[] time5;
    public static String[] time6;
    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.ToolbarDayDetail);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null));
        }

        listView = findViewById(R.id.LvDayDetail);
        setupListView();
    }

    private void setupListView() {
        Monday = getResources().getStringArray(R.array.Monday);
        Tuesday = getResources().getStringArray(R.array.Tuesday);
        Wednesday = getResources().getStringArray(R.array.Wednesday);
        Thursday = getResources().getStringArray(R.array.Thursday);
        Friday = getResources().getStringArray(R.array.Friday);
        Saturday = getResources().getStringArray(R.array.Saturday);

        time1 = getResources().getStringArray(R.array.time1);
        time2 = getResources().getStringArray(R.array.time2);
        time3 = getResources().getStringArray(R.array.time3);
        time4 = getResources().getStringArray(R.array.time4);
        time5 = getResources().getStringArray(R.array.time5);
        time6 = getResources().getStringArray(R.array.time6);

        SimpleAdapter adapter = new SimpleAdapter(this, PreferredDay, PreferredTime);
        listView.setAdapter(adapter);
    }

    public class SimpleAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private String[] subjectArray;
        private String[] timeArray;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray) {
            this.mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, parent, false);
                holder = new ViewHolder();
                holder.subject = convertView.findViewById(R.id.TvDayDetails);
                holder.time = convertView.findViewById(R.id.tvTimeDayDetail);
                holder.imageView = convertView.findViewById(R.id.IvDayDetails); // Инициализация ImageView
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.subject.setText(subjectArray[position]);
            holder.time.setText(timeArray[position]);

            if (subjectArray[position].equalsIgnoreCase("Programming Fundamentals")) {
                holder.imageView.setImageResource(R.drawable.programming);
            } else if(subjectArray[position].equalsIgnoreCase("Cybersecurity")){
                holder.imageView.setImageResource(R.drawable.cybersecurity);
            }else if(subjectArray[position].equalsIgnoreCase("Data Structures and Algorithms")){
                holder.imageView.setImageResource(R.drawable.diagram);
            }else if(subjectArray[position].equalsIgnoreCase("Database Management")){
                holder.imageView.setImageResource(R.drawable.database);
            }else if(subjectArray[position].equalsIgnoreCase("Web Development")){
                holder.imageView.setImageResource(R.drawable.web);
            }else{
                holder.imageView.setImageResource(R.drawable.pause);
            }
            return convertView;
        }

        private class ViewHolder {
            TextView subject;
            TextView time;
            ImageView imageView;
        }
    }
}