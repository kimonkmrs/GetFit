package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterInSeasonFootball extends FragmentStateAdapter {
    private static final int NUM_TABS = 3; // Number of tabs

    public CustomPagerAdapterInSeasonFootball(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_in_season_football(); // Replace with your actual fragment class
            case 1:
                return new Day2_in_season_football();
            case 2:
                return new Day3_in_season_football();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }


}
