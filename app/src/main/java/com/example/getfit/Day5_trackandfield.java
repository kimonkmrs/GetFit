package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class Day5_trackandfield extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day5_football, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView = view.findViewById(R.id.exercise1_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView2 = view.findViewById(R.id.exercise2_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView3 = view.findViewById(R.id.exercise3_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView4 = view.findViewById(R.id.exercise4_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView5 = view.findViewById(R.id.exercise5_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView6 = view.findViewById(R.id.exercise6_5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView backSquatsImageView7 = view.findViewById(R.id.exercise7_5);


        // Set an OnClickListener for the ImageView
        backSquatsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_1.class);
                startActivity(intent);
            }
        });
        backSquatsImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_2.class);
                startActivity(intent);
            }
        });
        backSquatsImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_3.class);
                startActivity(intent);
            }
        });
        backSquatsImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_4.class);
                startActivity(intent);
            }
        });
        backSquatsImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_5.class);
                startActivity(intent);
            }
        });
        backSquatsImageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_6.class);
                startActivity(intent);
            }
        });
        backSquatsImageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the VideoPlayerFootball activity when the image is clicked
                Intent intent = new Intent(requireContext(), VideoPlayerTrackAndFieldDay5_7.class);
                startActivity(intent);
            }
        });


        return view;
    }
}