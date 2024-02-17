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
import android.widget.TextView;

import java.text.DecimalFormat;

public class Protein_tennis extends AppCompatActivity {
    EditText mWeight, mEasyLow, mEasyHigh,mMidLow,mMidHigh,mGamePrep1,mGamePrep2;
    TextView mClickable;
    ImageView back, menus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_tennis);
        mClickable=findViewById(R.id.food_sources);
        mClickable.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Tennis_protein_food_sources.class)));
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
            float easyLowValue = (float) (1.5* weight);
            float easyHighValue= (float) (1.7*weight);
            float midLowValue= (float) (1.5*weight);
            float midHighValue= (float) (1.7*weight);
            float GamePrep1=(float) (1.5*weight);
            float GamePrep2= (float) (1.7*weight);
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
        mWeight.addTextChangedListener(new TextWatcher() {
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
                    float easyLowValue = (float) (1.5* weight);
                    float easyHighValue= (float) (1.7*weight);
                    float midLowValue= (float) (1.5*weight);
                    float midHighValue= (float) (1.7*weight);
                    float GamePrep1=(float) (1.5*weight);
                    float GamePrep2= (float) (1.7*weight);
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
                    Intent intent = new Intent(Protein_tennis.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Protein_tennis.this, Tennis.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Protein_tennis.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}