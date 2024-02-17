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

public class Breakfast_tennis extends AppCompatActivity {
    ImageView back, menus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_tennis);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<item_breakfast_tennis> items = new ArrayList<>();
        items.add(new item_breakfast_tennis("Pancakes with a Side of Egg Whites", R.drawable.breakfast1,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Pancakes+with+a+side+of+egg+whites&imgurl=https://bing.com/th?id=OSK.4405c7965f2c32d987a093a726221df6&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.bbcgoodfood.com%2frecipes%2feggs-benedict-pancakes&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Cooked Oatmeal with Honey + Yogurt", R.drawable.breakfast_2,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Cooked+Oatmeal+with+Honey+%2b+Yogurt&imgurl=https://bing.com/th?id=OSK.f364c0f14b993c12a916b3ebe2f65018&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.chiquita.com%2frecipes%2fbreakfast%2fbanana-oatmeal-with-honey-walnuts-and-cinnamon%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Waffles with Fresh Fruit", R.drawable.breakfast_3,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Waffles+with+fresh+fruit&imgurl=https://bing.com/th?id=OSK.5621caf5fb7154db90aef636dea897d9&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.kachen.lu%2fbreakfast-waffles-with-fresh-fruit%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Bagel with Peanut Butter and Side of Scrambled Eggs", R.drawable.breakfast_4,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Bagel+with+peanut+butter+and+side+of+scrambled+eggs&imgurl=https://bing.com/th?id=OSK.91599ae8f456a21b38ba92609aca0827&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.bhg.com%2frecipe%2fsheet-pan-egg-stuffed-bagels%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Oatmeal, Banana, and Peanut Butter", R.drawable.breakfast_5,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Oatmeal%2c+Banana%2c+and+Peanut+Butter&imgurl=https://bing.com/th?id=OSK.341fc879c670cc7c45453ef71fff4f80&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.eatingbirdfood.com%2fpeanut-butter-banana-oatmeal%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Toast with Turkey and Low-fat Cheese", R.drawable.breakfast_6,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Toast+with+Turkey+and+Low-fat+Cheese&imgurl=https://bing.com/th?id=OSK.865c5ac838cbca2cf85bdaf87c6d73e0&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.tasteofhome.com%2frecipes%2fgrilled-cheese-with-turkey%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_tennis("Egg-White Omelet with a Side of Toast and Jam", R.drawable.breakfast_7,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Egg-White+Omelet+with+a+Side+of+Toast+and+Jam&imgurl=https://bing.com/th?id=OSK.92933e7f4d77199b67584a0054d1b1af&idpbck=1&sim=4&pageurl=https%3a%2f%2fhealthyrecipesblogs.com%2fegg-white-omelet-recipe%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        recyclerView.setAdapter(new BreakfastTennisAdapter(this, items));
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
                    Intent intent = new Intent(Breakfast_tennis.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Breakfast_tennis.this, Tennis.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Breakfast_tennis.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }

}