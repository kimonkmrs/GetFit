package com.example.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Calendar_schedule extends AppCompatActivity {
    private Spinner optionsSpinner;
    private Toolbar footballToolbar, basketballToolbar,boxToolbar,tennisToolbar,trackToolbar,volleyballToolbar;
    // Define the other sport Toolbars here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_schedule); // Set your layout here

        // Initialize your views by finding them in the XML layout
        optionsSpinner = findViewById(R.id.options_spinner);
        footballToolbar = findViewById(R.id.football_toolbar);
        setSupportActionBar(footballToolbar);
        basketballToolbar = findViewById(R.id.basketball_toolbar);
        setSupportActionBar(basketballToolbar);
        volleyballToolbar = findViewById(R.id.volleyball_toolbar);
        setSupportActionBar(volleyballToolbar);
        tennisToolbar = findViewById(R.id.tennis_toolbar);
        setSupportActionBar(tennisToolbar);
        boxToolbar = findViewById(R.id.box_toolbar);
        setSupportActionBar(boxToolbar);
        trackToolbar = findViewById(R.id.trackandfield_toolbar);
        setSupportActionBar(trackToolbar);
        // Initialize other sport Toolbars here

        // Set up an ArrayAdapter for the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionsSpinner.setAdapter(adapter);

        // Set up an OnItemSelectedListener for the Spinner
        optionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Determine the selected sport
                String selectedSport = optionsSpinner.getSelectedItem().toString();

                // Based on the selected sport, show the corresponding Toolbar and hide others
                if ("Football".equals(selectedSport)) {
                    footballToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(footballToolbar);
                    basketballToolbar.setVisibility(View.GONE);
                    tennisToolbar.setVisibility(View.GONE);
                    volleyballToolbar.setVisibility(View.GONE);
                    trackToolbar.setVisibility(View.GONE);
                    boxToolbar.setVisibility(View.GONE);
                    // Hide other sport Toolbars
                } else if ("Basketball".equals(selectedSport)) {
                    basketballToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(basketballToolbar);
                    footballToolbar.setVisibility(View.GONE);
                    tennisToolbar.setVisibility(View.GONE);
                    volleyballToolbar.setVisibility(View.GONE);
                    trackToolbar.setVisibility(View.GONE);
                    boxToolbar.setVisibility(View.GONE);
                    // Hide other sport Toolbars
                    // Hide other sport Toolbars
                }else if ("Volleyball".equals(selectedSport)) {
                    volleyballToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(volleyballToolbar);
                    footballToolbar.setVisibility(View.GONE);
                    tennisToolbar.setVisibility(View.GONE);

                    trackToolbar.setVisibility(View.GONE);
                    basketballToolbar.setVisibility(View.GONE);
                    boxToolbar.setVisibility(View.GONE);
                }else if ("Tennis".equals(selectedSport)){

                    tennisToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(tennisToolbar);
                    volleyballToolbar.setVisibility(View.GONE);
                    footballToolbar.setVisibility(View.GONE);
                    trackToolbar.setVisibility(View.GONE);
                    basketballToolbar.setVisibility(View.GONE);
                    boxToolbar.setVisibility(View.GONE);

                }else if ("Track and Field".equals(selectedSport)){


                    trackToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(trackToolbar);
                    tennisToolbar.setVisibility(View.GONE);
                    volleyballToolbar.setVisibility(View.GONE);
                    footballToolbar.setVisibility(View.GONE);
                    basketballToolbar.setVisibility(View.GONE);
                    boxToolbar.setVisibility(View.GONE);

                }else if ("Boxing".equals(selectedSport)){

                    boxToolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(boxToolbar);
                    trackToolbar.setVisibility(View.GONE);
                    tennisToolbar.setVisibility(View.GONE);
                    volleyballToolbar.setVisibility(View.GONE);
                    footballToolbar.setVisibility(View.GONE);
                    basketballToolbar.setVisibility(View.GONE);


                }
                // Add more conditions for other sports here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle nothing selected if needed
            }
        });
        ImageView back = findViewById(R.id.left_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Handle menu button click
        ImageView menu = findViewById(R.id.right_icon);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.football, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Off_season:
                Intent intent = new Intent(Calendar_schedule.this, Off_season_football_schedule.class);
                startActivity(intent);
                return true;
            case R.id.Pre_season:
                Intent intent2 = new Intent(Calendar_schedule.this, Pre_season_football_schedule.class);
                startActivity(intent2);
                return true;
            case R.id.In_season:
                Intent intent3 = new Intent(Calendar_schedule.this, In_season_football_schedule.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int sportMenuId = 0;
        String selectedSport = optionsSpinner.getSelectedItem().toString();

        switch (selectedSport) {
            case "Football":
                sportMenuId = R.menu.football;
                break;
            case "Basketball":
                sportMenuId = R.menu.basketball; // Use the basketball menu
                break;
            case "Tennis":
                sportMenuId = R.menu.tennis; // Use the basketball menu
                break;
            case "Boxing":
                sportMenuId = R.menu.boxing; // Use the basketball menu
                break;
            case "Track and Field":
                sportMenuId = R.menu.trackandfield; // Use the basketball menu
                break;
            case "Volleyball":
                sportMenuId = R.menu.volleyball; // Use the basketball menu
                break;
            // Add cases for other sports similarly
        }

        if (sportMenuId != 0) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(sportMenuId, menu);
            return true;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String selectedSport = optionsSpinner.getSelectedItem().toString();

        switch (selectedSport) {
            case "Football":
                // Handle football menu items
                if (itemId == R.id.Off_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Off_season_football_schedule.class);
                    startActivity(intent);
                    return true;
                }if (itemId == R.id.Pre_season) {
                Intent intent = new Intent(Calendar_schedule.this, Pre_season_football_schedule.class);
                startActivity(intent);
                return true;
            }if (itemId == R.id.In_season) {
                Intent intent = new Intent(Calendar_schedule.this, In_season_football_schedule.class);
                startActivity(intent);
                return true;
            }
                // Handle other football menu items similarly
                break;
            case "Basketball":
                // Handle basketball menu items
                if (itemId == R.id.Off_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Off_season_basketball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.Pre_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Pre_season_basketball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.In_season) {
                    Intent intent = new Intent(Calendar_schedule.this, In_season_basketball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                // Handle other basketball menu items similarly
                break;
            case "Volleyball":
                // Handle basketball menu items
                if (itemId == R.id.Off_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Off_season_volleyball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.Pre_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Pre_season_volleyball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.In_season) {
                    Intent intent = new Intent(Calendar_schedule.this, In_season_volleyball_schedule.class);
                    startActivity(intent);
                    return true;
                }
                // Handle other basketball menu items similarly
                break;
            case "Tennis":
                // Handle basketball menu items
                if (itemId == R.id.Off_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Early_pre_season_tennis_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.Pre_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Late_pre_season_tennis_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.In_season) {
                    Intent intent = new Intent(Calendar_schedule.this, In_season_tennis_schedule.class);
                    startActivity(intent);
                    return true;
                }
                // Handle other basketball menu items similarly
                break;
            case "Track and Field":
                // Handle basketball menu items
                if (itemId == R.id.season) {
                    Intent intent = new Intent(Calendar_schedule.this, TrackAndField_schedule.class);
                    startActivity(intent);
                    return true;
                }
            case "Boxing":
                // Handle basketball menu items
                if (itemId == R.id.Off_season) {
                    Intent intent = new Intent(Calendar_schedule.this, General_training_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.Pre_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Specific_preparation_schedule.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.In_season) {
                    Intent intent = new Intent(Calendar_schedule.this, Competition_phase_schedule.class);
                    startActivity(intent);
                    return true;
                }
                // Handle other basketball menu items similarly
                break;

                // Handle other basketball menu items similarly

            // Add cases for other sports similarly
        }

        return super.onOptionsItemSelected(item);
    }


    private void showPopupMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_sportsquiz, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_item_layout1) {
                    Intent intent = new Intent(Calendar_schedule.this, MainActivity.class);
                    startActivity(intent);

                } else if (itemId == R.id.menu_item_layout2) {
                    Intent intent = new Intent(Calendar_schedule.this, Login.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        popupMenu.show();


    }
}












