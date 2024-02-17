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

public class In_season_tennis_schedule extends AppCompatActivity {
    CardView workout,nutrition,matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_season_tennis_schedule); // Set your layout here
        workout=findViewById(R.id.Workout);
        workout.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),In_season_tennis.class)));
        nutrition=findViewById(R.id.Nutritiontips);
        nutrition.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Tennis_nutrition.class)));
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
                    Intent intent = new Intent(In_season_tennis_schedule.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(In_season_tennis_schedule.this, Calendar_schedule.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(In_season_tennis_schedule.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}
