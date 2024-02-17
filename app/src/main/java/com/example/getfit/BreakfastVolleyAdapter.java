package com.example.getfit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BreakfastVolleyAdapter extends RecyclerView.Adapter<BreakfastVolleyAdapter.ViewHolder>{
    private Context context;
    private List<item_breakfast_volley> items;

    public BreakfastVolleyAdapter(Context context, List<item_breakfast_volley> items3) {
        this.context = context;
        this.items = items3;
    }

    @NonNull
    @Override
    public BreakfastVolleyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new BreakfastVolleyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastVolleyAdapter.ViewHolder holder, int position) {
        item_breakfast_volley item = items.get(position);
        holder.foodtitle.setText(item.getName());
        holder.foodimage.setImageResource(item.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(item.getUrl());
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView foodtitle;
    ImageView foodimage;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        foodtitle = itemView.findViewById(R.id.title_food);
        foodimage = itemView.findViewById(R.id.food_image);
    }
}
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

}
