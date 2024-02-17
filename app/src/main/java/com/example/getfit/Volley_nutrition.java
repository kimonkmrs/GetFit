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

public class Volley_nutrition extends AppCompatActivity {
    ImageView back, menus;
    private Toolbar toolbar,toolbar2,toolbar3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_nutrition);
        toolbar = findViewById(R.id.toolbar_macro_volley);
        setSupportActionBar(toolbar);
        toolbar2=findViewById(R.id.toolbar_micro_volley);
        toolbar3=findViewById(R.id.toolbar_electrolytes_volley);
        toolbar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Volley_nutrition.this, Micro_volley.class));
            }
        });
        toolbar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Volley_nutrition.this, Electrolytes_volley.class));
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
        inflater.inflate(R.menu.macros, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Fat:
                Intent intent = new Intent(Volley_nutrition.this, Fat_volley.class);
                startActivity(intent);
                return true;
            case R.id.Protein:
                Intent intent2 = new Intent(Volley_nutrition.this, Protein_volley.class);
                startActivity(intent2);
                return true;
            case R.id.Carbohydrate:
                Intent intent3 = new Intent(Volley_nutrition.this, Carbo_volley.class);
                startActivity(intent3);
                return true;
            case R.id.Menu_plans:
                Intent intent4 = new Intent(Volley_nutrition.this, Menuplans_volley.class);
                startActivity(intent4);
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
                    Intent intent = new Intent(Volley_nutrition.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Volley_nutrition.this, Volleyball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Volley_nutrition.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}