package com.example.tazabilim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;

public class DayDetail extends AppCompatActivity {

    private ListView listView;
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
    }

    private void setupListView(){
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

        String select_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null);

        if(select_day.equalsIgnoreCase("Monday")){
            PreferredDay = Monday;
            PreferredTime = time1;
        }else if(select_day.equalsIgnoreCase("Tuesday")){
            PreferredDay = Tuesday;
            PreferredTime = time2;
        }else if(select_day.equalsIgnoreCase("Wednesday")){
            PreferredDay = Wednesday;
            PreferredTime = time3;
        }else if(select_day.equalsIgnoreCase("Thursday")){
            PreferredDay = Thursday;
            PreferredTime = time4;
        }else if(select_day.equalsIgnoreCase("Friday")){
            PreferredDay = Friday;
            PreferredTime = time5;
        }else{
            PreferredDay = Saturday;
            PreferredTime = time6;
        }
    }
}