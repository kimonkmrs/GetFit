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

public class Recoverymeals_volley extends AppCompatActivity {
    ImageView back, menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoverymeals_volley);
       RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<item_recovery_volley> items = new ArrayList<>();
        items.add(new item_recovery_volley("Homemade Pizza Rolls with Ham and Cheese", R.drawable.recov_1,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Homemade+pizzas+with+ham%2c+cheese+%2b+veggies&imgurl=https://bing.com/th?id=OSK.bbee07866e0dac36ebb419e59045053c&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.mangiabedda.com%2fhomemade-pizza-rolls-with-ham-and-cheese%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
                items.add(new item_recovery_volley("Chicken & Vegetable Risotto", R.drawable.recov_2,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Chicken+and+vegetable+risotto&imgurl=https://bing.com/th?id=OSK.b011a08cc753adc3ffc6df0a56ab4215&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.onelovelylife.com%2fchicken-vegetable-risotto%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
                        items.add(new item_recovery_volley("Simple Grilled Salmon & Vegetables", R.drawable.recov_3,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Simple+Grilled+Salmon+%26+Vegetables&imgurl=https://bing.com/th?id=OSK.9f0c5c6294e5b42e55a6e105de737e9f&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.eatingwell.com%2frecipe%2f266353%2fsimple-grilled-salmon-vegetables%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        recyclerView.setAdapter(new RecoveryVolleyAdapter(this, items));
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
                    Intent intent = new Intent(Recoverymeals_volley.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Recoverymeals_volley.this, Volleyball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Recoverymeals_volley.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }


}