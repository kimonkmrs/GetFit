package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.text.DecimalFormat;

public class Fat_tennis_intake_strategies extends AppCompatActivity {
    EditText mWeight, mEasyLow, mEasyHigh,mMidLow,mMidHigh,mGamePrep1,mGamePrep2;
    ImageView back, menus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_tennis_intake_strategies);
        mWeight = findViewById(R.id.weight_monitor_kg);
        mEasyLow = findViewById(R.id.count_easy_low);
        mEasyHigh=findViewById(R.id.count_easy_high);
        mMidLow=findViewById(R.id.count_mid_low);
        mMidHigh=findViewById(R.id.count_mid_high);
        mGamePrep1=findViewById(R.id.count_max_low);
        mGamePrep2=findViewById(R.id.count_max_high);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedWeight = preferences.getString("weight", "");
        mWeight.setText(savedWeight);
        if (!savedWeight.isEmpty()) {
            float weight = Float.parseFloat(savedWeight);
            float easyLowValue = (float) (1.1* weight);
            float easyHighValue= (float) (1.5*weight);
            float midLowValue= (float) (1.1*weight);
            float midHighValue= (float) (1.5*weight);
            float GamePrep1=1*weight;
            float GamePrep2= (float) (1.1*weight);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            mEasyLow.setText(decimalFormat.format(easyLowValue));
            mEasyHigh.setText(decimalFormat.format(easyHighValue));
            mMidLow.setText(decimalFormat.format(midLowValue));
            mMidHigh.setText(decimalFormat.format(midHighValue));
            mGamePrep1.setText(decimalFormat.format(GamePrep1));
            mGamePrep2.setText(decimalFormat.format(GamePrep2));

        } else {
            mEasyLow.setText(""); // Clear the text if weight is empty
            mEasyHigh.setText("");
            mMidHigh.setText("");
            mMidLow.setText("");
            mGamePrep1.setText("");
            mGamePrep2.setText("");

        }    mWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    float weight = Float.parseFloat(s.toString());
                    float easyLowValue = (float) (1.1* weight);
                    float easyHighValue= (float) (1.5*weight);
                    float midLowValue= (float) (1.1*weight);
                    float midHighValue= (float) (1.5*weight);
                    float GamePrep1=1*weight;
                    float GamePrep2= (float) (1.1*weight);
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    mEasyLow.setText(decimalFormat.format(easyLowValue));
                    mEasyHigh.setText(decimalFormat.format(easyHighValue));
                    mMidLow.setText(decimalFormat.format(midLowValue));
                    mMidHigh.setText(decimalFormat.format(midHighValue));
                    mGamePrep1.setText(decimalFormat.format(GamePrep1));
                    mGamePrep2.setText(decimalFormat.format(GamePrep2));

                } else {
                    mEasyLow.setText(""); // Clear the text if weight is empty
                    mEasyHigh.setText("");
                    mMidHigh.setText("");
                    mMidLow.setText("");
                    mGamePrep1.setText("");
                    mGamePrep2.setText("");

                }
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
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Fat_tennis_intake_strategies.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Fat_tennis_intake_strategies.this, Tennis.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Fat_tennis_intake_strategies.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}