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
public class evening_meal_tennis extends AppCompatActivity {
    ImageView back, menus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening_meal_tennis);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<item_evening_tennis> items = new ArrayList<>();
        items.add(new item_evening_tennis(" Spaghetti with Red Sauce and Shrimp, Chicken, or Lean Beef", R.drawable.evening_1,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Spaghetti+with+Red+Sauce+and+Shrimp%2c+Chicken%2c+or+Lean+Beef&imgurl=https://bing.com/th?id=OSK.6140f1e8748ce6f92ed271023e14ac58&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.allrecipes.com%2frecipe%2f263413%2fshrimp-spaghetti-with-tomato-sauce%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis("Grilled Chicken or Fish with Sweet Potatoes and Other Veggies", R.drawable.evening_2,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Grilled+Chicken+or+Fish+with+Sweet+Potatoes+and+Other+Veggies&imgurl=https://bing.com/th?id=OSK.4ff6017ae74ffb13f916dc69691b0b0d&idpbck=1&sim=4&pageurl=https%3a%2f%2fcookpad.com%2fpt%2freceitas%2f7959931-grilled-chicken-with-fried-sweet-potato-and-veggies&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis("Rice Bowl with Salmon and Veggies", R.drawable.evening_3,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Rice+Bowl+with+Salmon+and+Veggies&imgurl=https://bing.com/th?id=OSK.2a1146be60f8f07e007d95aa9febadcc&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.americastestkitchen.com%2frecipes%2f11312-brown-rice-bowl-with-vegetables-and-salmon&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis("Turkey or Ham Sandwich", R.drawable.evening_4,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Turkey+or+Ham+Sandwich&imgurl=https://bing.com/th?id=OSK.1028b5e7c252da06c6a12080af4a2c4e&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.myrecipes.com%2frecipe%2fgrilled-turkey-ham-sandwiches-0&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis("Lean Sushi Rolls (with no sauces or cream cheese)", R.drawable.evening_5,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Lean+Sushi+Rolls+(with+no+sauces+or+cream+cheese)&imgurl=https://bing.com/th?id=OSK.255b66ebda26a2dea15a675d0363d719&idpbck=1&sim=4&pageurl=https%3a%2f%2ftastycraze.com%2frecipes%2fr-36408-Homemade_Sushi_with_Cream_Cheese&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis("Chicken & Mushroom Risotto (no cheese)", R.drawable.evening_7,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Chicken+%26+Mushroom+Risotto+(no+cheese)&imgurl=https://bing.com/th?id=OSK.bd1723ad0fbc6062f1cde598994c93aa&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.recipetineats.com%2fchicken-and-mushroom-risotto%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_evening_tennis(" Poke-Bowl with no heavy meats or sauces", R.drawable.evening_8,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Poke+Bowl+Recipe+(with+Sriracha+Mayo)&imgurl=https://bing.com/th?id=OSK.7f7139f995c300f484647af56b090de0&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.kitchensanctuary.com%2fseared-steak-poke-bowl%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));

        recyclerView.setAdapter(new Evening_meal_tennis_Adapter(this, items));
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
                    Intent intent = new Intent(evening_meal_tennis.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(evening_meal_tennis.this, Tennis.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(evening_meal_tennis.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}

