package com.example.waka.Book;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.Model.DataBook;
import com.example.waka.R;

import java.util.List;

public class ContentPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<DataBook> dataBook;
    public ContentPageAdapter(List<DataBook> dataBook){
        this.dataBook = dataBook;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == 1){ // text
            View view = inflater.inflate(R.layout.item_content_page_text , parent , false);
            return new ItemTextHolder(view);
        }
        else {
            View view = inflater.inflate(R.layout.item_content_page_img , parent , false);
            return new ItemUriHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemUriHolder){
            ItemUriHolder holderUri = (ItemUriHolder) holder;

            Glide.with(holderUri.imgView.getContext())
                    .load(dataBook.get(position).getUri())
                    .placeholder(R.drawable.loading_placeholder)
                    .error(R.drawable.error_image)
                    .into(holderUri.imgView);
        }
        else if (holder instanceof ItemTextHolder) {
            ItemTextHolder holderText = (ItemTextHolder) holder;
            holderText.txtContent.setText(dataBook.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return this.dataBook.size();
    }

    @Override
    public int getItemViewType(int position) {
        DataBook checkData = dataBook.get(position);
        if(checkData.getType() == true){ // text
            return 1;
        }
        else {
            return 2; // uri
        }
    }

    public class ItemUriHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgView;
        public ItemUriHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgContentPage);
        }
    }
    public class ItemTextHolder extends RecyclerView.ViewHolder
    {
        private TextView txtContent;
        public ItemTextHolder(@NonNull View itemView) {
            super(itemView);
            txtContent = itemView.findViewById(R.id.textContentInPage);
        }
    }
}
