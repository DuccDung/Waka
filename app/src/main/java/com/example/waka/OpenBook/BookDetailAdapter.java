package com.example.waka.OpenBook;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.Model.Book;
import com.example.waka.R;

import java.util.List;

public class BookDetailAdapter extends RecyclerView.Adapter<BookDetailAdapter.ItemHolder>{

    private List<Book> dataBook;
    public BookDetailAdapter(List<Book> DataBook){
        this.dataBook = DataBook;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_book_in_detail , parent , false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.txtNameBook.setText(dataBook.get(position).getName());
        Glide.with(holder.imgBook.getContext())
                .load(dataBook.get(position).getImg())
                .placeholder(R.drawable.loading_placeholder)
                .error(R.drawable.error_image)
                .into(holder.imgBook);
    }

    @Override
    public int getItemCount() {
        return dataBook.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private ImageView imgBook;
        private TextView txtNameBook;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.image_characters_in_detail);
            txtNameBook = itemView.findViewById(R.id.book_title_in_detail);
        }
    }
}
