package com.example.getfit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class myViewHolder extends RecyclerView.ViewHolder{

    ImageView foodimage;
    TextView foodtitle;


    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        foodimage=itemView.findViewById(R.id.food_image);
        foodtitle=itemView.findViewById(R.id.title_food);
    }
}
