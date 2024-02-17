
package com.example.getfit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Day1_footballViewHolder extends RecyclerView.ViewHolder {
    ImageView thumbnailImageView;
    TextView titleTextView;

    public Day1_footballViewHolder(@NonNull View itemView) {
        super(itemView);
        thumbnailImageView = itemView.findViewById(R.id.video_thumbnail);
        titleTextView = itemView.findViewById(R.id.video_title);
    }
}