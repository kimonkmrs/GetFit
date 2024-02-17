package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Menuplans_trackandfield extends AppCompatActivity {
    ImageView back, menus;
    private Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuplans_trackandfield);
        Toolbar toolbar = findViewById(R.id.toolbar_track);
        setSupportActionBar(toolbar);
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.track, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Endurance:
                Intent intent = new Intent(Menuplans_trackandfield.this, Endurance.class);
                startActivity(intent);
                return true;
            case R.id.Sprinters_Jumpers:
                Intent intent2 = new Intent(Menuplans_trackandfield.this, Sprinters.class);
                startActivity(intent2);
                return true;
            case R.id.Throwers:
                Intent intent3 = new Intent(Menuplans_trackandfield.this, Throwers.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Menuplans_trackandfield.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Menuplans_trackandfield.this, TrackAndField.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Menuplans_trackandfield.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}