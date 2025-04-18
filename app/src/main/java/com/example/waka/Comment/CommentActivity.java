package com.example.waka.Comment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        commentList.add(new Comment(1, "Bài viết rất hay!"));
        commentList.get(0).setNameUser("Nguyễn Văn A");

        commentList.add(new Comment(2, "Cảm ơn bạn đã chia sẻ."));
        commentList.get(1).setNameUser("Trần Thị B");

        commentList.add(new Comment(3, "Đồng ý với bạn A"));
        commentList.get(2).setNameUser("Lê Văn C");

        commentList.add(new Comment(4, "Ý kiến rất sâu sắc"));
        commentList.get(3).setNameUser("Phạm Thị D");

        commentList.add(new Comment(5, "Mọi người bàn luận sôi nổi quá"));
        commentList.get(4).setNameUser("Hoàng Văn E");
        commentAdapter = new CommentAdapter(commentList);
        rcvComment.setAdapter(commentAdapter);
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