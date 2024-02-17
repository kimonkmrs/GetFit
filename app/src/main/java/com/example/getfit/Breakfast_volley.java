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

public class Breakfast_volley extends AppCompatActivity {
    ImageView back, menus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_volley);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<item_breakfast_volley> items = new ArrayList<>();
        items.add(new item_breakfast_volley("2 eggs scrambled with added vegetables, 2 pieces of fruit, and 1 piece of whole wheat toast with natural peanut butter.\n", R.drawable.break_1,"https://www.bing.com/images/search?view=detailV2&ccid=ONDnF9QB&id=9C4286D7A2493241E54CA5BBA1B990974E2E4EBC&thid=OIP.ONDnF9QBhJuqI72tRcsaygAAAA&mediaurl=https%3a%2f%2fwww.tasteofhome.com%2fwp-content%2fuploads%2f2018%2f01%2fVegetable-Scrambled-Eggs_EXPS_FT20_5557_F_0310_1.jpg&cdnurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.38d0e717d401849baa23bdad45cb1aca%3frik%3dvE4uTpeQuaG7pQ%26pid%3dImgRaw%26r%3d0&exph=474&expw=474&q=2+eggs+scrambled+with+added+vegetables%2c+2+pieces+of+fruit%2c+and+1+piece+of+whole+wheat+toast+with+natural+peanut+butter.&simid=608046358951954227&FORM=IRPRST&ck=136F87203017BA28481AF5B275ECB243&selectedIndex=3&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_volley("Plain cooked oatmeal with added blue berries, mixed nuts, greek yogurt, and a scoop of whey protein powder\n", R.drawable.break_2,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Plain+cooked+oatmeal+with+added+blue+berries%2c+mixed+nuts%2c+greek+yogurt%2c+and+a+scoop+of+whey+protein+powder&imgurl=https://bing.com/th?id=OSK.71e4dc1ac82fc40e8c949b0481f8bb82&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.forksoverknives.com%2frecipes%2fvegan-breakfast%2ffruit-and-nut-healthy-oatmeal%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));
        items.add(new item_breakfast_volley("A high fiber low sugar cereal with added berries and nuts", R.drawable.break_3,"https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=A+high+fiber+low+sugar+cereal+with+added+berries+and+nuts+recipe&imgurl=https://bing.com/th?id=OSK.0cbe58207d61051ad0fd8370f94f67a6&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.keepingthepeas.com%2fhomemade-granola%2f&idpp=recipe&ajaxhist=0&ajaxserp=0"));

        recyclerView.setAdapter(new BreakfastVolleyAdapter(this, items));
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
                    Intent intent = new Intent(Breakfast_volley.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Breakfast_volley.this, Volleyball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Breakfast_volley.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}