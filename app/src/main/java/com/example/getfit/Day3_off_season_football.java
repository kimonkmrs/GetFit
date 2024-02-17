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


public class Day3_off_season_football extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_day3_off_season_football, container, false);

        // Find the ImageView associated with "Back squats"

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView = view.findViewById(R.id.exercise1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView2 = view.findViewById(R.id.exercise2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView3 = view.findViewById(R.id.exercise3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView4 = view.findViewById(R.id.exercise4);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView5 = view.findViewById(R.id.exercise5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView6 = view.findViewById(R.id.exercise6);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView7 = view.findViewById(R.id.exercise7);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView8 = view.findViewById(R.id.exercise8);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView9 = view.findViewById(R.id.exercise9);



        // Set an OnClickListener for the ImageView
        backSquatsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_1.class);
                startActivity(intent);
            }
        });
        backSquatsImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_2.class);
                startActivity(intent);
            }
        });
        backSquatsImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_3.class);
                startActivity(intent);
            }
        });
        backSquatsImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_4.class);
                startActivity(intent);
            }
        });
        backSquatsImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_5.class);
                startActivity(intent);
            }
        });
        backSquatsImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_6.class);
                startActivity(intent);
            }
        });
        backSquatsImageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_7.class);
                startActivity(intent);
            }
        });
        backSquatsImageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_8.class);
                startActivity(intent);
            }
        });
        backSquatsImageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonFootballDay3_9.class);
                startActivity(intent);
            }
        });








        return view;
    }
}