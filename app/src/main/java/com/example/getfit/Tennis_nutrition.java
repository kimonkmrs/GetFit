package com.example.getfit;

import static com.example.getfit.R.id.toolbar_macro_tennis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Tennis_nutrition extends AppCompatActivity {
    private Toolbar toolbar_t,toolbar_t2,toolbar_t3;
    ImageView back, menus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis_nutrition);

        Toolbar toolbar_t = findViewById(toolbar_macro_tennis);
        setSupportActionBar(toolbar_t);
        Toolbar toolbar_t2=findViewById(R.id.toolbar_micro_tennis);
        Toolbar toolbar_t3=findViewById(R.id.toolbar_electrolytes_tennis);
        toolbar_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Tennis_nutrition.this, Micro_Tennis.class));
            }
        });
        toolbar_t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toolbar click here
                startActivity(new Intent(Tennis_nutrition.this, Fluids_electrolytes_tennis.class));
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
                Intent intent = new Intent(Tennis_nutrition.this, Fat_tennis.class);
                startActivity(intent);
                return true;
            case R.id.Protein:
                Intent intent2 = new Intent(Tennis_nutrition.this, Protein_tennis.class);
                startActivity(intent2);
                return true;
            case R.id.Carbohydrate:
                Intent intent3 = new Intent(Tennis_nutrition.this, Carbo_tennis.class);
                startActivity(intent3);
                return true;
            case R.id.Menu_plans:
                Intent intent4 = new Intent(Tennis_nutrition.this, Menuplans_tennis.class);
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
                    Intent intent = new Intent(Tennis_nutrition.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Tennis_nutrition.this, Tennis.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Tennis_nutrition.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}