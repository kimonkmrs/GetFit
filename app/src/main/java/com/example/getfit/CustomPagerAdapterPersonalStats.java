package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterPersonalStats extends FragmentStateAdapter {
    private static final int NUM_TABS = 6; // Number of tabs

    public CustomPagerAdapterPersonalStats(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Footballer(); // Replace with your actual fragment class
            case 1:
                return new Basket_player();
            case 2:
                return new Runner();
            case 3:
                return new Boxer();
            case 4:
                return new Volley_player();
            case 5:
                return new Tennis_player();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }


}
