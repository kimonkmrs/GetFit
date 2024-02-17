package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomerPagerAdapterTrackAndField extends FragmentStateAdapter {
    private static final int NUM_TABS = 5; // Number of tabs

    public CustomerPagerAdapterTrackAndField(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_trackandfield(); // Replace with your actual fragment class
            case 1:
                return new Day2_trackandfield();
            case 2:
                return new Day3_trackandfield();
            case 3:
                return new Day4_trackandfield();
            case 4:
                return new Day5_trackandfield();


            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }


}
