package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterEarlyPreSeasonTennis extends FragmentStateAdapter {
    private static final int NUM_TABS = 2; // Number of tabs

    public CustomPagerAdapterEarlyPreSeasonTennis(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_early_pre_season_tennis(); // Replace with your actual fragment class
            case 1:
                return new Day2_early_pre_season_tennis(); // Replace with your actual fragment class

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}
