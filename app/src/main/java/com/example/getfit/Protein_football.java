package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

import soup.neumorphism.NeumorphCardView;

public class Protein_football extends AppCompatActivity {
    ImageView back, menu;
    EditText mWeight, mProteinLow, mProteinHigh;
    CardView FoodSource,IntakeStrategy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_football);
        mWeight = findViewById(R.id.weight_monitor_kg);
        mProteinLow = findViewById(R.id.count_protein1);
        mProteinHigh=findViewById(R.id.grams_count);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedWeight = preferences.getString("weight", "");
        mWeight.setText(savedWeight);
        if (!savedWeight.isEmpty()) {
            float weight = Float.parseFloat(savedWeight);
            float proteinLowValue = (float) (1.3* weight);
            float proteinHighValue= (float) (1.4* weight);


            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            mProteinLow.setText(decimalFormat.format(proteinLowValue));
            mProteinHigh.setText(decimalFormat.format(proteinHighValue));}
            else {
                mProteinLow.setText(""); // Clear the text if weight is empty
                mProteinHigh.setText("");


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
                    float proteinLowValue = (float) (1.3* weight);
                    float proteinHighValue= (float) (1.4*weight);

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    mProteinLow.setText(decimalFormat.format(proteinLowValue));
                    mProteinHigh.setText(decimalFormat.format(proteinHighValue));


                } else {
                    mProteinLow.setText(""); // Clear the text if weight is empty
                    mProteinHigh.setText("");


                }
            }
        });
        FoodSource = findViewById(R.id.NutritionFootballProteinSources);
        FoodSource .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Protein_football.this, Protein_food_sources.class);
                startActivity(intent);
            }
        });
        IntakeStrategy = findViewById(R.id.DietaryPlan);
        IntakeStrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Protein_football.this, Protein_Intake_Strategies_football.class);
                startActivity(intent);
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
                    Intent intent = new Intent(Protein_football.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Protein_football.this, Football.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Protein_football.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}