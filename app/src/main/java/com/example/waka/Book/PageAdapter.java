package com.example.waka.Book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.R;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.PageViewHolder> {

    private List<String> pageList;

    public PageAdapter(List<String> pageList) {
        this.pageList = pageList;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        holder.textPage.setText(pageList.get(position));
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }

    static class PageViewHolder extends RecyclerView.ViewHolder {
        TextView textPage;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            textPage = itemView.findViewById(R.id.textPage);
        }
    }
}
