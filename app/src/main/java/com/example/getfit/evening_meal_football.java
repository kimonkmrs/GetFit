package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class evening_meal_football extends AppCompatActivity {
    ImageView back, menu;
    TextView urlTextView1,urlTextView2,urlTextView3,urlTextView4,urlTextView5,urlTextView6,urlTextView7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening_meal_football);

        // Initialize the TextView after calling setContentView()
        urlTextView1 = findViewById(R.id.first1);
        urlTextView2 = findViewById(R.id.second2);
        urlTextView3 = findViewById(R.id.third3);
        urlTextView4 = findViewById(R.id.fourth4);
        urlTextView5 = findViewById(R.id.fifth5);
        urlTextView6 = findViewById(R.id.sixth6);
        urlTextView7 = findViewById(R.id.seventh7);
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


        String hyperlinkText = "Minestone soup with smoked bacon (Click here for recipe)";
        SpannableString spannableString = new SpannableString(hyperlinkText);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url = "https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=minestone+soup+with+bacon&imgurl=https://bing.com/th?id=OSK.3ed5082081769544fb6766ba55a78b56&idpbck=1&sim=4&pageurl=https%3a%2f%2fablossominglife.com%2fminestrone-soup-with-bacon%2f&idpp=recipe&ajaxhist=0&ajaxserp=0";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, 0, hyperlinkText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView1.setText(spannableString);
        urlTextView1.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText2 = "Salmon and cauliflower bake (Click to see the recipe)";
        SpannableString spannableString2 = new SpannableString(hyperlinkText2);
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url2 = "https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=almon+and+cauliflower+bake&imgurl=https://bing.com/th?id=OSK.435ba38d47f4a133bb6b4256c5d95a01&idpbck=1&sim=4&pageurl=https%3a%2f%2frecipes.sparkpeople.com%2frecipe-detail.asp%3frecipe%3d628015&idpp=recipe&ajaxhist=0&ajaxserp=0";
                Intent intent2= new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent2);
            }
        };
        spannableString2.setSpan(clickableSpan2, 0, hyperlinkText2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView2.setText(spannableString2);
        urlTextView2.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText3 = "Thai green chicken curry (Click to see the recipe)";
        SpannableString spannableString3 = new SpannableString(hyperlinkText3);
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url3 = "https://www.bbc.co.uk/food/recipes/thaigreenchickencurr_92440";
                Intent intent3= new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                startActivity(intent3);
            }
        };
        spannableString3.setSpan(clickableSpan3, 0, hyperlinkText3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView3.setText(spannableString3);
        urlTextView3.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText4 = "Honey roasted vegetables with pesto and pine nuts (Click to see the recipe)";
        SpannableString spannableString4 = new SpannableString(hyperlinkText4);
        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url4="https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Honey+roasted+vegetables+with+pesto+and+pine+nuts+(Click+to+see+the+recipe)&imgurl=https://bing.com/th?id=OSK.7e6449c2d78b0b50640427fe6993a124&idpbck=1&sim=4&pageurl=https%3a%2f%2fkeviniscooking.com%2feasy-roasted-vegetables-with-honey-and-balsamic-syrup%2f&idpp=recipe&ajaxhist=0&ajaxserp=0";
                Intent intent4= new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
                startActivity(intent4);
            }
        };
        spannableString4.setSpan(clickableSpan4, 0, hyperlinkText4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView4.setText(spannableString4);
        urlTextView4.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText5 = "Sweet potato mash (Click to see the recipe)";
        SpannableString spannableString5 = new SpannableString(hyperlinkText5);
        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url5 = "https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Sweet+potato+mash+(Click+to+see+the+recipe)&imgurl=https://bing.com/th?id=OSK.6caa0852c0e554d55be579d59e1e9833&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.allrecipes.com%2frecipe%2f21220%2fmashed-sweet-potatoes%2f&idpp=recipe&ajaxhist=0&ajaxserp=0";
                Intent intent5= new Intent(Intent.ACTION_VIEW, Uri.parse(url5));
                startActivity(intent5);
            }
        };
        spannableString5.setSpan(clickableSpan5, 0, hyperlinkText5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView5.setText(spannableString5);
        urlTextView5.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText6 = "Asparagus, green peas and carrots (Click to see the recipe)";
        SpannableString spannableString6 = new SpannableString(hyperlinkText6);
        ClickableSpan clickableSpan6 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url6 = "https://www.bing.com/images/search?view=detailv2&iss=sbi&FORM=recidp&sbisrc=ImgDropper&q=Asparagus%2c+green+peas+and+carrots+(Click+to+see+the+recipe)&imgurl=https://bing.com/th?id=OSK.1df194de4dcfac390ab4b1573e2b617d&idpbck=1&sim=4&pageurl=https%3a%2f%2fwww.foodnetwork.com%2frecipes%2free-drummond%2froasted-asparagus-and-peas-2507090&idpp=recipe&ajaxhist=0&ajaxserp=0";
                Intent intent6= new Intent(Intent.ACTION_VIEW, Uri.parse(url6));
                startActivity(intent6);
            }
        };
        spannableString6.setSpan(clickableSpan6, 0, hyperlinkText6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView6.setText(spannableString6);
        urlTextView6.setMovementMethod(LinkMovementMethod.getInstance());

        String hyperlinkText7 = "Fresh fruit salad (Click to see the recipe)";
        SpannableString spannableString7 = new SpannableString(hyperlinkText7);
        ClickableSpan clickableSpan7 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here, e.g., open the URL in a web browser
                String url7="https://www.bbc.co.uk/food/recipes/fresh_fruit_salad_61942";
                Intent intent7= new Intent(Intent.ACTION_VIEW, Uri.parse(url7));
                startActivity(intent7);
            }
        };
        spannableString7.setSpan(clickableSpan7, 0, hyperlinkText7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        urlTextView7.setText(spannableString7);
        urlTextView7.setMovementMethod(LinkMovementMethod.getInstance());



        // Set the URL as the text of the TextView

    }
    private void showPopupMenu (View anchorView){
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(evening_meal_football.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(evening_meal_football.this, Football.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(evening_meal_football.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}
