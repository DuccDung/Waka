package com.example.waka.Home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemCategory>{
    private List<String> dataCate;

    public CategoryAdapter(List<String> dataCate){
        this.dataCate = dataCate;
    }
    @NonNull
    @Override
    public ItemCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View  view = inflater.inflate(R.layout.item_category , parent , false);
        return new ItemCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCategory holder, int position) {
        String itemCate = dataCate.get(position);
        holder.itemCate.setText(itemCate);
    }

    @Override
    public int getItemCount() {
        return dataCate.size();
    }

    public class ItemCategory extends RecyclerView.ViewHolder{
        private TextView itemCate;
        public ItemCategory(@NonNull View itemView) {
            super(itemView);
            itemCate = itemView.findViewById(R.id.home_item_category);
        }
    }
}
