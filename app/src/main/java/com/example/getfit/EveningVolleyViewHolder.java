package com.example.getfit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EveningVolleyViewHolder extends RecyclerView.ViewHolder {
    private ImageView foodImage;
    private TextView foodTitle;

    public EveningVolleyViewHolder(@NonNull View itemView) {
        super(itemView);
        foodImage = itemView.findViewById(R.id.food_image);
        foodTitle = itemView.findViewById(R.id.title_food);

    }
}
