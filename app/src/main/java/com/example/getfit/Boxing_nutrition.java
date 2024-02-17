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

public class Boxing_nutrition extends AppCompatActivity {
    private Toolbar toolbar,toolbar2,toolbar3;
    ImageView back, menus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing_nutrition);
        toolbar = findViewById(R.id.toolbar_macro_boxing);
        setSupportActionBar(toolbar);
        toolbar2=findViewById(R.id.toolbar_micro_boxing);
        toolbar3=findViewById(R.id.toolbar_electrolytes_boxing);
        toolbar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Boxing_nutrition.this, Micro_boxing.class));
            }
        });
        toolbar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Boxing_nutrition.this, Fluid_Electolytes_boxing.class));
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
                Intent intent = new Intent(Boxing_nutrition.this, Fat_boxing.class);
                startActivity(intent);
                return true;
            case R.id.Protein:
                Intent intent2 = new Intent(Boxing_nutrition.this, Protein_boxing.class);
                startActivity(intent2);
                return true;
            case R.id.Carbohydrate:
                Intent intent3 = new Intent(Boxing_nutrition.this, Carbo_boxing.class);
                startActivity(intent3);
                return true;
            case R.id.Menu_plans:
                Intent intent4 = new Intent(Boxing_nutrition.this, Menuplans_boxing.class);
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
                    Intent intent = new Intent(Boxing_nutrition.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Boxing_nutrition.this, Boxing.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Boxing_nutrition.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}