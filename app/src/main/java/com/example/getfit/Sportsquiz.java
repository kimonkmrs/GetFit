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

import soup.neumorphism.NeumorphCardView;

public class Sportsquiz extends AppCompatActivity {
    CardView football,basketball,tennis,track_field,boxing,volleyball;
    private ImageView back, menu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportsquiz);
        football=findViewById(R.id.Football1);
        basketball=findViewById(R.id.Basket);
        tennis=findViewById(R.id.Tenniscard);
        volleyball=findViewById(R.id.Volleycard);
        boxing=findViewById(R.id.Boxcard);
        track_field=findViewById(R.id.Runcard);
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Sportsquiz.this,Football.class);
                startActivity(intent);
            }
        });
        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Sportsquiz.this,Basketball.class);
                startActivity(intent);
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Sportsquiz.this,Tennis.class);
                startActivity(intent);
            }
        });
        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Sportsquiz.this,Volleyball.class);
                startActivity(intent);
            }
        });
        boxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sportsquiz.this,Boxing.class);
                startActivity(intent);
            }
        });
        track_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sportsquiz.this,TrackAndField.class);
                startActivity(intent);
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
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_sportsquiz, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Sportsquiz.this, MainActivity.class);
                    startActivity(intent);

                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Sportsquiz.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}