package com.example.getfit;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Day1_off_season_volley extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_day1_off_season_volley, container, false);

        // Find the ImageView associated with "Back squats"

        ImageView backSquatsImageView = view.findViewById(R.id.exercise1);
        ImageView backSquatsImageView2 = view.findViewById(R.id.exercise2);
        ImageView backSquatsImageView3 = view.findViewById(R.id.exercise3);
        ImageView backSquatsImageView4 = view.findViewById(R.id.exercise4);
        ImageView backSquatsImageView5 = view.findViewById(R.id.exercise5);
        ImageView backSquatsImageView6 = view.findViewById(R.id.exercise6);
        ImageView backSquatsImageView7 = view.findViewById(R.id.exercise7);
        ImageView backSquatsImageView8 = view.findViewById(R.id.exercise8);
        ImageView backSquatsImageView9 = view.findViewById(R.id.exercise9);
        ImageView backSquatsImageView10 = view.findViewById(R.id.exercise10);


        // Set an OnClickListener for the ImageView
        backSquatsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_1.class);
                startActivity(intent);
            }
        });
        backSquatsImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_2.class);
                startActivity(intent);
            }
        });
        backSquatsImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_3.class);
                startActivity(intent);
            }
        });
        backSquatsImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_4.class);
                startActivity(intent);
            }
        });
        backSquatsImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_5.class);
                startActivity(intent);
            }
        });
        backSquatsImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_6.class);
                startActivity(intent);
            }
        });
        backSquatsImageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_7.class);
                startActivity(intent);
            }
        });
        backSquatsImageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_8.class);
                startActivity(intent);
            }
        });
        backSquatsImageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_9.class);
                startActivity(intent);
            }
        });
        backSquatsImageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerOffSeasonVolleyDay1_10.class);
                startActivity(intent);
            }
        });


        return view;
    }
}