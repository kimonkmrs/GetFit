package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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

public class Competition_phase_schedule extends AppCompatActivity {
    CardView workout,nutrition,matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_phase_schedule); // Set your layout here
        workout=findViewById(R.id.Workout);
        workout.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Competition_phase_box.class)));
        nutrition=findViewById(R.id.Nutritiontips);
        nutrition.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Boxing_nutrition.class)));
        matches=findViewById(R.id.Events);
        matches.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Matches.class)));
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



    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.calendars, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Competition_phase_schedule.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Competition_phase_schedule.this, Calendar_schedule.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Competition_phase_schedule.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}
