package com.example.getfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Matches extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ImageView back, menu;
    private static final String MATCH_DAYS_PREF = "match_days_pref";

    private ListView matchListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> matchDaysList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        sharedPreferences = getSharedPreferences(MATCH_DAYS_PREF, MODE_PRIVATE);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth; // Form the date in a string format

            // Retrieve saved match days
            String savedMatchDays = sharedPreferences.getString("match_days", "");

            if (savedMatchDays.contains(selectedDate)) {

                savedMatchDays = savedMatchDays.replace(selectedDate + ",", "");
                Toast.makeText(getApplicationContext(), "Match day removed: " + selectedDate, Toast.LENGTH_SHORT).show();
            } else {

                savedMatchDays = savedMatchDays + selectedDate + ",";
                Toast.makeText(getApplicationContext(), "Match day added: " + selectedDate, Toast.LENGTH_SHORT).show();
            }

            // Save the updated match days in SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("match_days", savedMatchDays);
            editor.apply();
            // Saving match days in the Matches class
            updateMatchDaysList();


        });
        back = findViewById(R.id.left_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity or layout
                onBackPressed();
            }
        });

        menu = findViewById(R.id.right_icon);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
        matchListView = findViewById(R.id.matchListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matchDaysList);
        matchListView.setAdapter(adapter);

        // Populate the list with saved match days
        /*String savedMatchDays = sharedPreferences.getString("match_days", "");
        if (!savedMatchDays.isEmpty()) {
            String[] matchDaysArray = savedMatchDays.split(",");
            matchDaysList.addAll(Arrays.asList(matchDaysArray));
            adapter.notifyDataSetChanged();
        }*/


    }
    @Override
    protected void onResume() {
        super.onResume();//To refresh the match days in real time
        updateMatchDaysList();
    }

    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_sportsquiz, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Matches.this, MainActivity.class);
                    startActivity(intent);

                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Matches.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }

   /* private void updateMatchDaysList() {
        String savedMatchDays = sharedPreferences.getString("match_days", "");
        if (!savedMatchDays.isEmpty()) {
            String[] matchDaysArray = savedMatchDays.split(",");
            matchDaysList.clear(); // Clear existing list to avoid duplicates on refresh

            // Add the match days to the ArrayList
            matchDaysList.addAll(Arrays.asList(matchDaysArray));

            // Sort the list in ascending order (assuming date format is "YYYY-MM-DD")
            Collections.sort(matchDaysList);

            adapter.notifyDataSetChanged();
        }
    }*/
   private void updateMatchDaysList() {
       String savedMatchDays = sharedPreferences.getString("match_days", "");
       if (!savedMatchDays.isEmpty()) {
           String[] matchDaysArray = savedMatchDays.split(",");
           matchDaysList.clear(); // Clear existing list to avoid duplicates on refresh

           // Add the match days to the ArrayList
           matchDaysList.addAll(Arrays.asList(matchDaysArray));

           // Custom comparator for sorting in descending order
           Comparator<String> descendingDateComparator = (date1, date2) -> date2.compareTo(date1);

           // Sort the list using the custom comparator
           Collections.sort(matchDaysList, descendingDateComparator);

           adapter.notifyDataSetChanged();
       }
   }

}