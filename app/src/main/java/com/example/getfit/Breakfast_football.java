package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

public class Breakfast_football extends AppCompatActivity {
    ImageView back, menu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_football);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<item_breakfast_football> items = new ArrayList<>();
        items.add(new item_breakfast_football("Healthy Breakfast Scramble", R.drawable.breakfast_foot1,"https://www.thatfitfam.com/healthy-breakfast-scramble/"));
        items.add(new item_breakfast_football("Bacon and Egg Macro Bowl", R.drawable.breakfast_foot2,"https://www.ohsosavvymom.com/2017/04/bacon-egg-macro-bowl-recipe/"));
        items.add(new item_breakfast_football("No-Bake Breakfast Bar", R.drawable.breakfast_foot3,"https://theproteinchef.co/no-bake-healthy-breakfast-bars-recipe/"));
        items.add(new item_breakfast_football("Avocado IIFYM Breakfast Bake", R.drawable.breakfast_foot4,"https://moscatomom.com/avocado-breakfast-bakes/#mv-creation-126-jtr"));
        items.add(new item_breakfast_football("High Protein- Low Carb Sheet Pan Breakfast", R.drawable.breakfast_foot5,"https://www.thehungryelephant.ca/2019/01/22/high-protein-sheet-pan-breakfast/"));
        items.add(new item_breakfast_football("Macro Friendly High Protein-Low Fat Oatmeal Bowl", R.drawable.breakfast_foot6,"https://www.eatingbirdfood.com/protein-oatmeal/"));
        items.add(new item_breakfast_football("Sweet Potato & Chicken Sausage Scramble", R.drawable.breakfast_foot7,"https://therealisticdietitian.com/recipes/sweet-potato-and-chicken-sausage-scramble/"));
        items.add(new item_breakfast_football("Low Fat Two-Ingredient Bagels", R.drawable.breakfast_foot8,"https://www.messforless.net/2-ingredient-weight-watchers-bagels/"));

        recyclerView.setAdapter(new myAdapterFootballNutr(this, items));
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
                    Intent intent = new Intent(Breakfast_football.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Breakfast_football.this, Football.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Breakfast_football.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}