package com.example.getfit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomPagerAdapterGeneralTrainingBox extends FragmentStateAdapter {
    private static final int NUM_TABS = 4; // Number of tabs

    public CustomPagerAdapterGeneralTrainingBox(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new Day1_general_training_box(); // Replace with your actual fragment class
            case 1:
                return new Day2_general_training_box();
            case 2:
                return new Day3_general_training_box(); // Replace with your actual fragment class
            case 3:
                return new Day4_general_training_box();




            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}
