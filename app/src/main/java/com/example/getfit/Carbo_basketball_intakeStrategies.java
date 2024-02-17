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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Carbo_basketball_intakeStrategies extends AppCompatActivity {
    ImageView back, menu;

    EditText mWeight, mgMin, mgMax, mcalMin, mcalMax;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbo_basketball_intake_strategies);
        mWeight = findViewById(R.id.weight_monitor_kg);
        mgMin = findViewById(R.id.count_min);
        mgMax = findViewById(R.id.count_max);
        mcalMin = findViewById(R.id.count_min2);
        mcalMax = findViewById(R.id.count_max2);

        // Load the saved weight from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedWeight = preferences.getString("weight", "");
        mWeight.setText(savedWeight);
        if (!savedWeight.isEmpty()) {
            float weight = Float.parseFloat(savedWeight);
            float minG = 5 * weight;
            float maxG = 10 * weight;
            float minCal = 4 * minG;
            float maxCal = 4 * maxG;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            mgMin.setText(decimalFormat.format(minG));
            mgMax.setText(decimalFormat.format(maxG));
            mcalMin.setText(decimalFormat.format(minCal));
            mcalMax.setText(decimalFormat.format(maxCal));
        }
        else {
            mgMin.setText(""); // Clear the text if weight is empty
            mgMax.setText("");
            mcalMin.setText("");
            mcalMax.setText("");
        }

        // Add a TextWatcher to calculate min and max values based on weight
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
                    float minG = 5 * weight;
                    float maxG = 10 * weight;
                    float minCal = 4 * minG;
                    float maxCal = 4 * maxG;

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    mgMin.setText(decimalFormat.format(minG));
                    mgMax.setText(decimalFormat.format(maxG));
                    mcalMin.setText(decimalFormat.format(minCal));
                    mcalMax.setText(decimalFormat.format(maxCal));
                } else {
                    mgMin.setText(""); // Clear the text if weight is empty
                    mgMax.setText("");
                    mcalMin.setText("");
                    mcalMax.setText("");
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

        menu = findViewById(R.id.right_icon);
        menu.setOnClickListener(new View.OnClickListener() {
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
                    Intent intent = new Intent(Carbo_basketball_intakeStrategies.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Carbo_basketball_intakeStrategies.this, Basketball.class);
                    startActivity(intent);
                } else if (itemId == R.id.menu_item_layout3) {
                    Intent intent = new Intent(Carbo_basketball_intakeStrategies.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();
    }
}
