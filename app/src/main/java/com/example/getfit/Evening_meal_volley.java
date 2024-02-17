package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

public class Evening_meal_volley extends AppCompatActivity {
    ImageView back, menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening_meal_volley);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<item_evening_volley> items = new ArrayList<>();
        items.add(new item_evening_volley("Marinated Grilled Pork Tenderloin", R.drawable.evening_vol1,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Grilled+marinated+pork+tenderloin&imgurl=https://bing.com/th?id=OSK.1d0fe90d1b38367f365ae27e494f5b43&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.allrecipes.com%2frecipe%2f228266%2fmarinated-grilled-pork-tenderloin%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_volley("Italian Rice Pilaf", R.drawable.evening_vol2,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=brown+rice+pilaf&imgurl=https://bing.com/th?id=OSK.4a284f06fc18c9391e414b61a40b92d4&idpbck=1&sim=4&pageurl=https%3a%2f%2fgr.pinterest.com%2fpin%2f209910032613096760%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_volley("Grilled zucchini", R.drawable.evening_vol3,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=grilled+zucchini&imgurl=https://bing.com/th?id=OSK.493865eeb4c0f7d38fe82d5e65cf48ad&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.skinnytaste.com%2fgrilled-zucchini%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_volley("Mixed greens with garbanzo beans, cucumber, tomato, onion, carrots and reduced-fat dressing", R.drawable.evening_vol4,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=mixed+greens+with+garbanzo+beans%2c+cucumber%2c+tomato%2c+onion%2c+carrots+and+reduced-fat+dressing%3b+apple+sauce&imgurl=https://bing.com/th?id=OSK.aff54414ad71a03d68085002a416f452&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.myrecipes.com%2frecipe%2fgarbanzo-beans-greens&idpp=recipe&ajaxhist=0&ajaxserp=0"));

        recyclerView.setAdapter(new EveningVolleyAdapter(this, items));
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
                    Intent intent = new Intent(Evening_meal_volley.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Evening_meal_volley.this, Volleyball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Evening_meal_volley.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }


}