package com.example.getfit;

import androidx.fragment.app.Fragment;

public class ActivityItem {
    private String date;
    private String sport;
    private Fragment activityFragment;
    private int dayNumber; // Day number (e.g., 1 for Day1, 2 for Day2)
    private boolean restDay; // Indicates if it's a rest day

    public ActivityItem(String date, String sport, Fragment activityFragment, int dayNumber, boolean restDay) {
        this.date = date;
        this.sport = sport;
        this.activityFragment = activityFragment;
        this.dayNumber = dayNumber;
        this.restDay = restDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Fragment getActivityFragment() {
        return activityFragment;
    }

    public void setActivityFragment(Fragment activityFragment) {
        this.activityFragment = activityFragment;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public boolean isRestDay() {
        return restDay;
    }

    public void setRestDay(boolean restDay) {
        this.restDay = restDay;
    }
}
