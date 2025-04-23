package com.example.waka.MenuBarInHome;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Library.LibraryCateAdapter;
import com.example.waka.R;

import java.util.List;

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.CategoryViewHolder>{

    private List<String> categories;
    private int selectedPosition = 0;

    public CateAdapter (List<String> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CateAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cate_bar, parent, false);
        return new CateAdapter.CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateAdapter.CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.tvCategory.setText(category);

        if (selectedPosition == position) {
            holder.tvCategory.setBackgroundResource(R.drawable.bg_category_selected);
            holder.tvCategory.setTextColor(Color.BLACK);
        } else {
            holder.tvCategory.setBackgroundResource(R.drawable.bg_category_unselected);
            holder.tvCategory.setTextColor(Color.WHITE);
        }

        holder.tvCategory.setOnClickListener(v -> {
            int prevSelected = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(prevSelected);
            notifyItemChanged(selectedPosition);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvCategoryInBar);
        }
    }
}
