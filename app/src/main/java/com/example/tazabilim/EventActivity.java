package com.example.tazabilim;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EventActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private Map<String, String> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = findViewById(R.id.ToolbarEvent);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Event Calendar");

        // Инициализация списка праздников
        initializeHolidays();

        // Настройка CalendarView
        calendarView = findViewById(R.id.calendarView);
        calendarView.setMinDate(getTimeInMillis(2024, 0, 1)); // Установка начала календаря на 1 января 2024 года
        calendarView.setMaxDate(getTimeInMillis(2024, 11, 31)); // Установка конца календаря на 31 декабря 2024 года

        // Добавление слушателя изменения даты в календаре
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String key = dayOfMonth + "-" + (month + 1); // Формирование ключа "день-месяц"
                if (holidays.containsKey(key)) {
                    Toast.makeText(EventActivity.this, "Holiday: " + holidays.get(key), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EventActivity.this, "No holiday on this day", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initializeHolidays() {
        holidays = new HashMap<>();
        // Заполнение карты праздниками Казахстана
        holidays.put("1-1", "New Year's Day");
        holidays.put("8-3", "International Women's Day");
        holidays.put("21-3", "Nauryz");
        holidays.put("1-5", "Unity Day");
        holidays.put("7-5", "Defender of the Fatherland Day");
        holidays.put("9-5", "Victory Day");
        holidays.put("6-7", "Capital City Day");
        holidays.put("30-8", "Constitution Day");
        holidays.put("25-10", "Republic Day");
        holidays.put("1-12", "First President Day");
        holidays.put("16-12", "Independence Day");
    }

    private long getTimeInMillis(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTimeInMillis();
    }
}