package com.example.waka.Comment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Chapter.CommentAdapter;
import com.example.waka.Model.Comment;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    private RecyclerView rcvComment;
    private CommentAdapter commentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comment3);
        getStatusBarHeight();
        rcvComment = findViewById(R.id.rcvComments);
        rcvComment.setLayoutManager(new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL , false));
        List<Comment> commentList = new ArrayList<>();

        // data
//        commentAdapter = new CommentAdapter(commentList);
//        rcvComment.setAdapter(commentAdapter);
    }
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}