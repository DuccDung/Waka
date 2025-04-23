package com.example.waka.Book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.DataPageInBook;
import com.example.waka.R;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.PageViewHolder> {

    private List<DataPageInBook> dataPage;
    private Context context;
    public PageAdapter(Context context , List<DataPageInBook> dataPage) {
        this.dataPage = dataPage;
        this.context = context;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        ContentPageAdapter contentPageAdapter = new ContentPageAdapter(this.dataPage.get(position).getData());
        holder.rcv.setAdapter(contentPageAdapter);
    }

    @Override
    public int getItemCount() {
        return this.dataPage.size();
    }

    public class PageViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rcv;
        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcvPageContent);
            rcv.setLayoutManager(new LinearLayoutManager(rcv.getContext() , LinearLayoutManager.VERTICAL , false));
        }
    }
}
