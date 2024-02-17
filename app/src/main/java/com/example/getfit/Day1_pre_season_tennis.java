package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Day1_pre_season_tennis extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_day1_pre_season_tennis, container, false);

        // Find the ImageView associated with "Back squats"

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView = view.findViewById(R.id.exercise1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView2 = view.findViewById(R.id.exercise2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView3 = view.findViewById(R.id.exercise3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView4 = view.findViewById(R.id.exercise4);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView5 = view.findViewById(R.id.exercise5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView6 = view.findViewById(R.id.exercise6);



        // Set an OnClickListener for the ImageView
        backSquatsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_1.class);
                startActivity(intent);
            }
        });
        backSquatsImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_2.class);
                startActivity(intent);
            }
        });
        backSquatsImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_3.class);
                startActivity(intent);
            }
        });
        backSquatsImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_4.class);
                startActivity(intent);
            }
        });
        backSquatsImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_5.class);
                startActivity(intent);
            }
        });
        backSquatsImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerPreSeasonTennisDay1_6.class);
                startActivity(intent);
            }
        });



        return view;
    }
}