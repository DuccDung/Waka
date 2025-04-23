package com.example.waka.Chapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.Model.ApiResponse;
import com.example.waka.Model.Comment;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

import api_service.ApiService;
import api_service.DataCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.itemHolder>{
    private List<Comment> dataComment = new ArrayList<>();
    public  interface ListenReplyClick{
        void onClickReply(int commentId);
    }
    ListenReplyClick listenReplyClick;
    public CommentAdapter(ListenReplyClick listenReplyClick ,List<Comment> data){
        this.dataComment = data;
        this.listenReplyClick = listenReplyClick;
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
        if(comment.getUser() == null) return;

        Glide.with(holder.imgAvt.getContext())
                .load(comment.getUser().getAvatar())
                .placeholder(R.drawable.loading_placeholder)
                .error(R.drawable.error_image)
                .into(holder.imgAvt);

        holder.txtNameUser.setText(comment.getUser().getFullName());

        holder.txtComment.setText(comment.getContent());
        InitData(new DataCallback<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                if (data > 0) {
                    holder.txtShowCommentChild.setText("Xem " + data + " bình luận");
                } else {
                    holder.txtShowCommentChild.setText("");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        } , comment.getId());
        holder.txtShowCommentChild.setOnClickListener(v -> {
            holder.rcvCommentChild.setVisibility(View.VISIBLE);
            holder.txtHideCommentChild.setVisibility(View.VISIBLE);
            InitDataChild(new DataCallback<List<Comment>>() {
                @Override
                public void onSuccess(List<Comment> data) {
                    CommentAdapter commentAdapterChild = new CommentAdapter( listenReplyClick,data);
                    holder.rcvCommentChild.setAdapter(commentAdapterChild);
                    holder.rcvCommentChild.setLayoutManager(new LinearLayoutManager(holder.rcvCommentChild.getContext()));
                    holder.rcvCommentChild.setVisibility(View.VISIBLE);
                    holder.txtShowCommentChild.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            }, comment.getId());
        });
        holder.txtHideCommentChild.setOnClickListener(v->{
        holder.rcvCommentChild.setVisibility(View.GONE);
        holder.txtShowCommentChild.setVisibility(View.VISIBLE);
        holder.txtHideCommentChild.setVisibility(View.GONE);

    });
        holder.txtReply.setOnClickListener(v->{
            listenReplyClick.onClickReply(comment.getId());
        });

    }

    @Override
    public int getItemCount() {
        return this.dataComment.size();
    }

    public class itemHolder extends RecyclerView.ViewHolder {
        private TextView txtNameUser;
        private TextView txtComment , txtShowCommentChild , txtHideCommentChild , txtReply;
        private RecyclerView rcvCommentChild;
        private ImageView imgAvt;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            txtNameUser = itemView.findViewById(R.id.tvName);
            txtComment = itemView.findViewById(R.id.tvComment);
            txtShowCommentChild = itemView.findViewById(R.id.txt_show_comment);
            rcvCommentChild = itemView.findViewById(R.id.rcv_comment_member);
            txtHideCommentChild = itemView.findViewById(R.id.txt_hide_comment);
            txtReply = itemView.findViewById(R.id.txtReply);
            imgAvt = itemView.findViewById(R.id.imgAvatarInComment);
        }
    }

    public void InitData(DataCallback<Integer> callback , int commentId){
        ApiService.apiService.GetCountCommentChildByParentId(commentId).enqueue(new Callback<ApiResponse<Integer>>() {
            @Override
            public void onResponse(Call<ApiResponse<Integer>> call, Response<ApiResponse<Integer>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Integer>> call, Throwable t) {

            }
        });

    }
    public void InitDataChild(DataCallback<List<Comment>> callback , int parentId){
        ApiService.apiService.GetCommentChildByParentId(parentId).enqueue(new Callback<ApiResponse<Comment>>() {
            @Override
            public void onResponse(Call<ApiResponse<Comment>> call, Response<ApiResponse<Comment>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.onSuccess(response.body().getDataList());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Comment>> call, Throwable t) {

            }
        });
    }
}
