package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterOffSeasonVolley extends FragmentStateAdapter {
    private static final int NUM_TABS = 6; // Number of tabs

    public CustomPagerAdapterOffSeasonVolley(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_off_season_volley(); // Replace with your actual fragment class
            case 1:
                return new Day2_off_season_volley();
            case 2:
                return new Day3_off_season_volley(); // Replace with your actual fragment class
            case 3:
                return new Day4_off_season_volley();

            case 4:
                return new Day5_off_season_volley(); // Replace with your actual fragment class
            case 5:
                return new Day6_off_season_volley();


            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }


}