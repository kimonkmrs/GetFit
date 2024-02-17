package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterInSeasonBasket extends FragmentStateAdapter {
    private static final int NUM_TABS = 2; // Number of tabs

    public CustomPagerAdapterInSeasonBasket(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_in_season_basket(); // Replace with your actual fragment class
            case 1:
                return new Day2_in_season_basket();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}
