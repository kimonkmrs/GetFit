package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterPreSeasonBasket extends FragmentStateAdapter {
    private static final int NUM_TABS = 5; // Number of tabs

    public CustomPagerAdapterPreSeasonBasket(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_pre_season_basket(); // Replace with your actual fragment class
            case 1:
                return new Day2_pre_season_basket();
            case 2:
                return new Day3_pre_season_basket(); // Replace with your actual fragment class
            case 3:
                return new Day4_pre_season_basket();
            case 4:
                return new Day5_pre_season_basket(); // Replace with your actual fragment class


            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}
