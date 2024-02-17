package com.example.getfit;

public class Workout {
    private String date;
    private String activity;
    private String sport;
    private String season;

    public Workout(String date, String activity, String sport, String season) {
        this.date = date;
        this.activity = activity;
        this.sport = sport;
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public String getActivity() {
        return activity;
    }

}
