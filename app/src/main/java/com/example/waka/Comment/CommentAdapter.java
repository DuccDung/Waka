package com.example.waka.Comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Comment;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.itemHolder>{
    private List<Comment> dataComment = new ArrayList<>();
    public CommentAdapter(List<Comment> data){
        this.dataComment = data;
    }
    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_comment_list , parent , false);
        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        Comment comment = dataComment.get(position);
        holder.txtNameUser.setText(comment.getNameUser());
        holder.txtComment.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return this.dataComment.size();
    }

    public class itemHolder extends RecyclerView.ViewHolder {
        private TextView txtNameUser;
        private TextView txtComment;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            txtNameUser = itemView.findViewById(R.id.tvName);
            txtComment = itemView.findViewById(R.id.tvComment);
        }
    }
}
