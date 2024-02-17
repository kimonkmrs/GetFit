package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Basketball_weight extends AppCompatActivity {
    ImageView back, menu;

    private Button selectedActivityButton;

    private EditText weightKgEditText;
    private EditText heightCmEditText;
    private EditText ageYearsEditText;
    private Button sedentaryButton;
    private Button lightlyActiveButton;
    private Button moderatelyActiveButton;
    private Button veryActiveButton;
    private Button extremelyActiveButton;
    private EditText caloriesSurplusEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_weight);

        weightKgEditText = findViewById(R.id.weight_monitor_kg);
        heightCmEditText = findViewById(R.id.height_cm);
        ageYearsEditText = findViewById(R.id.age_years);
        sedentaryButton = findViewById(R.id.Sedentary);
        lightlyActiveButton = findViewById(R.id.Lightly_active);
        moderatelyActiveButton = findViewById(R.id.Moderately_active);
        veryActiveButton = findViewById(R.id.Very_active);
        extremelyActiveButton = findViewById(R.id.Extremely_active);
        caloriesSurplusEditText = findViewById(R.id.calories_surpl);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedWeight = preferences.getString("weight", "");
        String savedHeight = preferences.getString("height", "");
        String savedAge = preferences.getString("age", "");

        weightKgEditText.setText(savedWeight);
        heightCmEditText.setText(savedHeight);
        ageYearsEditText.setText(savedAge);

        weightKgEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        heightCmEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ageYearsEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        weightKgEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateCaloriesSurplus();
            }
        });

        heightCmEditText.addTextChangedListener(new TextWatcher() {
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
                calculateCaloriesSurplus();
            }
        });

        ageYearsEditText.addTextChangedListener(new TextWatcher() {
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
                calculateCaloriesSurplus();
            }
        });

        sedentaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedActivityButton = sedentaryButton;
                calculateCaloriesSurplus();
            }
        });

        lightlyActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedActivityButton = lightlyActiveButton;
                calculateCaloriesSurplus();
            }
        });


        moderatelyActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedActivityButton = moderatelyActiveButton;
                calculateCaloriesSurplus();
            }
        });

        veryActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedActivityButton = veryActiveButton;
                calculateCaloriesSurplus();
            }
        });

        extremelyActiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedActivityButton = extremelyActiveButton;
                calculateCaloriesSurplus();
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

    private void calculateCaloriesSurplus() {
        try {
            double weightKg = Double.parseDouble(weightKgEditText.getText().toString());
            double heightCm = Double.parseDouble(heightCmEditText.getText().toString());
            int ageYears = Integer.parseInt(ageYearsEditText.getText().toString());
            double activity_Multiplier;

            if (selectedActivityButton == sedentaryButton) {
                activity_Multiplier = 1.2;
            } else if (selectedActivityButton == lightlyActiveButton) {
                activity_Multiplier = 1.375;
            } else if (selectedActivityButton == moderatelyActiveButton) {
                activity_Multiplier = 1.55;
            } else if (selectedActivityButton == veryActiveButton) {
                activity_Multiplier = 1.725;
            } else if (selectedActivityButton == extremelyActiveButton) {
                activity_Multiplier = 1.9;
            } else {

                activity_Multiplier = 1.2; // Default to sedentary
            }

            double caloriesSurplus = ((10 * weightKg) + (6.25 * heightCm) - (5 * ageYears) - 161) * activity_Multiplier * 1.05;
            int roundedCaloriesSurplus = (int) Math.ceil(caloriesSurplus); // Round up to the nearest whole number

            caloriesSurplusEditText.setText(String.valueOf(roundedCaloriesSurplus));



        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showPopupMenu (View anchorView){
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menus, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Basketball_weight.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Basketball_weight.this, Basketball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Basketball_weight.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}