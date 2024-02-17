package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Micro_boxing extends AppCompatActivity {
    CardView Water_soluble,fat_soluble,macrominerals,trace_minerals;
    ImageView back, menus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_boxing);
        Water_soluble = findViewById(R.id.Water_Soluble_Vitamins);
        Water_soluble.setOnClickListener(v -> {
            Intent intent = new Intent(Micro_boxing.this, Water_soluble_vitamins_boxing.class);
            startActivity(intent);
        });
        fat_soluble = findViewById(R.id.Fat_Soluble_Vitamins);
        fat_soluble.setOnClickListener(v -> {
            Intent intent = new Intent(Micro_boxing.this, Fat_soluble_vitamins_boxing.class);
            startActivity(intent);
        });
        macrominerals = findViewById(R.id.Macrominerals);
        macrominerals.setOnClickListener(v -> {
            Intent intent = new Intent(Micro_boxing.this, Macrominerals_boxing.class);
            startActivity(intent);
        });
        trace_minerals = findViewById(R.id.Trace_Minerals);
        trace_minerals.setOnClickListener(v -> {
            Intent intent = new Intent(Micro_boxing.this, Trace_minerals_boxing.class);
            startActivity(intent);
        });
        back = findViewById(R.id.left_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity or layout
                onBackPressed();
            }
        });

        menus = findViewById(R.id.right_icon);
        menus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Micro_boxing.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Micro_boxing.this, Boxing.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Micro_boxing.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}