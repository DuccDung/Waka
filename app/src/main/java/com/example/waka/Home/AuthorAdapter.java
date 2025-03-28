package com.example.waka.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.Model.Author;
import com.example.waka.Model.Book;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ItemHolder>{
    private List<Author> dataAuthor;
    public AuthorAdapter(List<Author> DataAuthor){
        this.dataAuthor = DataAuthor;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_author , parent , false);
        return new AuthorAdapter.ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.txtName.setText(dataAuthor.get(position).getName());
        Glide.with(holder.imgAuthor.getContext())
                .load(dataAuthor.get(position).getImg())
                .placeholder(R.drawable.loading_placeholder)
                .error(R.drawable.error_image)
                .into(holder.imgAuthor);
    }
    @Override
    public int getItemCount() {
        return dataAuthor.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private ImageView imgAuthor;
        private TextView txtName;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgAuthor = itemView.findViewById(R.id.image_author);
            txtName = itemView.findViewById(R.id.name_author);
        }
    }
}
