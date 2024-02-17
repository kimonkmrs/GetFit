package com.example.getfit;

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
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Personal_stats extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private RadioButton femaleRadioButton;
    private RadioButton maleRadioButton;
    private EditText bmiEditText;
    private ImageView back, menu;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_stats);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Create an instance of your custom PagerAdapter
        CustomPagerAdapterPersonalStats pagerAdapter = new CustomPagerAdapterPersonalStats(this);
        viewPager.setAdapter(pagerAdapter);

        /*new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Set the tab titles based on the position
            String[] titles = {"Football", "Basketball", "Track and field", "Box", "Volleyball", "Tennis"};
            tab.setText(titles[position]);
        }).attach();*/
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {

            String[] titles = {"Football", "Basketball", "Track and field", "Box", "Volleyball", "Tennis"};
            tab.setText(titles[position]);
        }).attach();




        // Initialize UI elements
        weightEditText = findViewById(R.id.weight_monitor_kg);
        heightEditText = findViewById(R.id.height_cm);
        ageEditText = findViewById(R.id.age_years);
        femaleRadioButton = findViewById(R.id.radio_female);
        maleRadioButton = findViewById(R.id.radio_male);
        bmiEditText = findViewById(R.id.BMI);
        saveButton = findViewById(R.id.save_bmi);

        // Load saved stats from shared preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        weightEditText.setText(preferences.getString("weight", ""));
        heightEditText.setText(preferences.getString("height", ""));
        ageEditText.setText(preferences.getString("age", ""));
        boolean isFemale = preferences.getBoolean("isFemale", true);
        femaleRadioButton.setChecked(isFemale);
        maleRadioButton.setChecked(!isFemale);
        bmiEditText.setText(preferences.getString("bmi", ""));

        // Add TextWatcher to calculate and update BMI
        weightEditText.addTextChangedListener(textWatcher);
        heightEditText.addTextChangedListener(textWatcher);

        // Add OnClickListener to save all stats
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStats();
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

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            calculateBMI();
        }
    };

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100; // Convert cm to meters
            double bmi = weight / (height * height);
            bmiEditText.setText(String.format("%.2f", bmi));
        } else {
            bmiEditText.setText(""); // Clear the BMI field
        }
    }

    private void saveStats() {
        // Save user stats to shared preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("weight", weightEditText.getText().toString());
        editor.putString("height", heightEditText.getText().toString());
        editor.putString("age", ageEditText.getText().toString());
        editor.putBoolean("isFemale", femaleRadioButton.isChecked());
        editor.putString("bmi", bmiEditText.getText().toString());
        editor.apply();
    }
    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_sportsquiz, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Personal_stats.this, MainActivity.class);
                    startActivity(intent);

                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Personal_stats.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }

    // Your code for back and menu ImageView click listeners ...

    // ... Other methods and code for the menu PopupMenu ...
}
