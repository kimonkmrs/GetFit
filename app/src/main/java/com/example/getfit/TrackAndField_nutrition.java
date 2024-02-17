package com.example.getfit;

import static com.example.getfit.R.id.toolbar_macro_tennis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class TrackAndField_nutrition extends AppCompatActivity {
    ImageView back, menus;
    private Toolbar toolbar_t,toolbar_t2,toolbar_t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_and_field_nutrition);
        Toolbar toolbar_t = findViewById(R.id.toolbar_macro_trackandfield);
        setSupportActionBar(toolbar_t);
        Toolbar toolbar_t2=findViewById(R.id.toolbar_micro_trackandfield);
        Toolbar toolbar_t3=findViewById(R.id.toolbar_electrolytes_trackandfield);
        toolbar_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(TrackAndField_nutrition.this, Micro_trackandfield.class));
            }
        });
        toolbar_t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(TrackAndField_nutrition.this, Fluids_electrolytes_trackandfiels.class));
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
                Intent intent = new Intent(TrackAndField_nutrition.this, Fat_trackandfield.class);
                startActivity(intent);
                return true;
            case R.id.Protein:
                Intent intent2 = new Intent(TrackAndField_nutrition.this, Protein_trackandfield.class);
                startActivity(intent2);
                return true;
            case R.id.Carbohydrate:
                Intent intent3 = new Intent(TrackAndField_nutrition.this, Carbo_trackandfield.class);
                startActivity(intent3);
                return true;
            case R.id.Menu_plans:
                Intent intent4 = new Intent(TrackAndField_nutrition.this, Menuplans_trackandfield.class);
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
                    Intent intent = new Intent(TrackAndField_nutrition.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(TrackAndField_nutrition.this, TrackAndField.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(TrackAndField_nutrition.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}