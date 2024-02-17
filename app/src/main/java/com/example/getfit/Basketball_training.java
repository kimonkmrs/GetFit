package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Basketball_training extends AppCompatActivity {
    private Toolbar inSeason, preseason, offSeason;
    ImageView back, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_training);
       inSeason = findViewById(R.id.toolbar_workout_in_season_basket);
        inSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Basketball_training.this, In_season_basket.class));
            }
        });
       offSeason = findViewById(R.id.toolbar_workout_off_season_basket);
        offSeason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Basketball_training.this, Off_season_basket.class));
            }
        });
       preseason = findViewById(R.id.toolbar_workout_pre_season_basket);
        preseason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Basketball_training.this, Pre_season_basket.class));
            }
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

    }
    private void showPopupMenu (View anchorView){
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Basketball_training.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Basketball_training.this, Basketball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Basketball_training.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}