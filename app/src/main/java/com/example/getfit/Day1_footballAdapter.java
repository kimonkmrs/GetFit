package com.example.getfit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Day1_footballAdapter extends
        RecyclerView.Adapter<Day1_footballAdapter.Day1_footballViewHolder> {
    private Context context;
    private List<football_train_ex> videoItems;

    public Day1_footballAdapter(Context context, List<football_train_ex> videoItems) {
        this.context = context;
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public Day1_footballViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video,
                        parent, false);
        return new Day1_footballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Day1_footballViewHolder holder, int position) {
        football_train_ex videoItem = videoItems.get(position);

        holder.titleTextView.setText(videoItem.getTitle());
        holder.thumbnailImageView.setImageResource(videoItem.getThumbnailResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoId = videoItem.getVideoId();

                // Start the VideoPlayerFootball activity with the video ID
                Intent intent = new Intent(context, VideoPlayerFootball.class);
                intent.putExtra("VIDEO_ID", videoId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class Day1_footballViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnailImageView;
        TextView titleTextView;

        public Day1_footballViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.video_thumbnail);
            titleTextView = itemView.findViewById(R.id.video_title);
        }
    }
}