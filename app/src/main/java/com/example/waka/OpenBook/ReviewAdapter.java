package com.example.waka.OpenBook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Review;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ItemHolder> {
    private List<Review> dataReView = new ArrayList<>();

    public ReviewAdapter(List<Review> dataReView) {
        this.dataReView = dataReView;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_review , parent  , false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Review review = dataReView.get(position);
        holder.txtReview.setText(review.getComment());
        holder.txtName.setText(review.getName());
    }

    @Override
    public int getItemCount() {
        return this.dataReView.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtReview;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.username_in_open_book);
            txtReview = itemView.findViewById(R.id.review_in_open_book);
        }
    }
}
