package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.Calendar;

public class TrackAndField_schedule extends AppCompatActivity {
    private CalendarView calendarView;
    private Calendar startDate; // Variable to hold the start date
    private static final int TOTAL_DAYS = 7; // Total days in your schedule
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String START_DATE = "startDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_and_field_schedule); // Set your layout here

        calendarView = findViewById(R.id.calendarView);

        startDate = Calendar.getInstance(); // Set the start date as today
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        long savedStartDate = settings.getLong(START_DATE, 0);

        if (savedStartDate == 0) {
            // First time app is used, store the current date as the start date
            startDate = Calendar.getInstance();
            SharedPreferences.Editor editor = settings.edit();
            editor.putLong(START_DATE, startDate.getTimeInMillis());
            editor.apply();
        } else {
            startDate = Calendar.getInstance();
            startDate.setTimeInMillis(savedStartDate);
        }


        // Set a date change listener for the CalendarView
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth);

            long diff = selectedDate.getTimeInMillis() - startDate.getTimeInMillis();
            int dayCount = (int) (diff / (24 * 60 * 60 * 1000));

            int currentDay = (dayCount % TOTAL_DAYS) + 1;

            // Navigate to the corresponding fragment based on the current day
            switch (currentDay) {
                case 1:
                    loadFragment(new Day1_trackandfield());
                    break;
                case 2:
                    loadFragment(new Day2_trackandfield());
                    break;
                case 3:
                    loadFragment(new Day3_trackandfield());
                    break;
                case 4:
                    loadFragment(new Day4_trackandfield());
                    break;
                case 5:
                    loadFragment(new Day5_trackandfield());
                    break;
                case 6:

                    // Handle other days similarly
                case 7:
                    loadFragment(new RestDayFragment());
                    break;
                default:
                    // Handle other cases or loop back to the beginning
                    break;
            }
        });
        ImageView back = findViewById(R.id.left_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Handle menu button click
        ImageView menu = findViewById(R.id.right_icon);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    // Method to load the selected fragment
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.calendars, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(TrackAndField_schedule.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(TrackAndField_schedule.this, Calendar_schedule.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(TrackAndField_schedule.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}
