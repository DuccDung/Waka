package com.example.waka.Chapter;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.ApiResponse;
import com.example.waka.Model.Comment;
import com.example.waka.R;

import java.util.List;

import api_service.ApiService;
import api_service.DataCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentComment extends Fragment implements CommentAdapter.ListenReplyClick {
    private RecyclerView rcvComment;
    private CommentAdapter commentAdapter;
    private EditText edtComment;
    private Button btnSend;

    private Integer currentReplyToCommentId = null;
    private boolean isReplyingToComment = false;
    public   View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment , container , false);
        edtComment = view.findViewById(R.id.edtComment);
        btnSend = view.findViewById(R.id.btnSend);
        rcvComment = view.findViewById(R.id.rcvComments);
        rootView = view.getRootView();
        rcvComment.setLayoutManager(new LinearLayoutManager(requireContext() ,LinearLayoutManager.VERTICAL , false));
        List<Comment> commentList;
        InitData(new DataCallback<List<Comment>>() {
            @Override
            public void onSuccess(List<Comment> data) {
                commentAdapter = new CommentAdapter(FragmentComment.this , data);
                rcvComment.setAdapter(commentAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        } , 6);
        btnSend.setOnClickListener(v -> {
            String content = edtComment.getText().toString().trim();
            if (content.isEmpty()) return;

            if (isReplyingToComment && currentReplyToCommentId != null) {
                sendReplyComment(currentReplyToCommentId, content);
                commentAdapter.notifyDataSetChanged();
            } else {
                sendCommentToStory(content);
                commentAdapter.notifyDataSetChanged();
            }

            // Reset sau khi gửi
            currentReplyToCommentId = null;
            isReplyingToComment = false;
            edtComment.setHint("Viết bình luận...");
            edtComment.setText("");
            InitData(new DataCallback<List<Comment>>() {
                @Override
                public void onSuccess(List<Comment> data) {
                    commentAdapter = new CommentAdapter(FragmentComment.this , data);
                    rcvComment.setAdapter(commentAdapter);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            } , 6);
        });

        return view;
    }

    private void sendCommentToStory(String content) {
        ApiService.apiService.PostCommentChapter(6 , "d9c3ca0b-dca4-4c25-92d0-01c85d85333c" , null , content).enqueue(new Callback<ApiResponse<Void>>() {
            @Override
            public void onResponse(Call<ApiResponse<Void>> call, Response<ApiResponse<Void>> response) {
                if(response.isSuccessful()){
                    Log.d("tag", "onResponse: Post success");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Void>> call, Throwable t) {

            }
        });
    }

    private void sendReplyComment(Integer currentReplyToCommentId, String content) {
        ApiService.apiService.PostCommentChapter(6 , "d9c3ca0b-dca4-4c25-92d0-01c85d85333c" , currentReplyToCommentId , content).enqueue(new Callback<ApiResponse<Void>>() {
            @Override
            public void onResponse(Call<ApiResponse<Void>> call, Response<ApiResponse<Void>> response) {
                if(response.isSuccessful()){
                    Log.d("tag", "onResponse: Post success");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Void>> call, Throwable t) {

            }
        });
    }

    public void InitData(DataCallback<List<Comment>> callback , int chapterId){
       ApiService.apiService.GetCommentByChapterId(chapterId).enqueue(new Callback<ApiResponse<Comment>>() {
           @Override
           public void onResponse(Call<ApiResponse<Comment>> call, Response<ApiResponse<Comment>> response) {
               if(response.isSuccessful() && response.body() != null){
                   callback.onSuccess(response.body().getDataList());
               }
           }

           @Override
           public void onFailure(Call<ApiResponse<Comment>> call, Throwable t) {
               Log.e("fail", "onFailure: " + t.getMessage());
           }
       });
    }

    @Override
    public void onClickReply(int commentId) {
        Log.d("Main", "onClickReply: " + commentId);
        edtComment.requestFocus();
        currentReplyToCommentId = commentId;
        isReplyingToComment = true;
        edtComment.setHint("Trả lời bình luận...");
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null) {
            imm.showSoftInput(edtComment, InputMethodManager.SHOW_IMPLICIT);
        }
    }
    public void resetReplyMode() {
        currentReplyToCommentId = null;
        isReplyingToComment = false;
        edtComment.setHint("Viết bình luận...");
    }

}
