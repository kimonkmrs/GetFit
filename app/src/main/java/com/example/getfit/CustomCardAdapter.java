package com.example.getfit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomCardAdapter extends RecyclerView.Adapter<CustomCardAdapter.CardViewHolder> {
    private Context context;
    private List<String> cardDataList;

    public CustomCardAdapter(Context context, List<String> cardDataList) {
        this.context = context;
        this.cardDataList = cardDataList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_layout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String cardData = cardDataList.get(position);
        holder.bindData(cardData);
    }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView cardTextView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTextView = itemView.findViewById(R.id.card_text_view);
        }

        public void bindData(String cardData) {
            cardTextView.setText(cardData);

            // Set an OnClickListener here if you want to handle card clicks
        }
    }
}

