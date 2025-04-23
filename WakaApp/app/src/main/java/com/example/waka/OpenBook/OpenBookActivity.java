package com.example.waka.OpenBook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.waka.Model.Review;
import com.example.waka.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OpenBookActivity extends AppCompatActivity {
    private RecyclerView rcvReview;
    private ReviewAdapter reviewAdapter;
    private RecyclerView rcvComment;
    private CommentAdapter commentAdapter;
    TabLayout tabLayout;
    FrameLayout contentFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_book);

        makeStatusBarTransparent(); // làm trong suốt status bar
        applyTopPadding();          // tránh đè nội dung lên status bar nếu cần

        rcvReview= findViewById(R.id.rcv_review_in_open_book);
        rcvReview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcvComment = findViewById(R.id.rcv_booker_review_in_open_book);
        rcvComment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Review> reviewList = new ArrayList<>();

        // Tạo 5 đối tượng Review
        Review review1 = new Review("Linh", "Truyện rất hay, cốt truyện hấp dẫn!");
        Review review2 = new Review("Minh", "Tác giả xây dựng nhân vật rất tốt.");
        Review review3 = new Review("Trang", "Mình đọc một mạch không dừng lại được.");
        Review review4 = new Review("Huy", "Nội dung ổn nhưng đoạn kết hơi vội.");
        Review review5 = new Review("Lan", "Tình tiết nhẹ nhàng, rất phù hợp để thư giãn.");

        // Thêm vào danh sách
        reviewList.add(review1);
        reviewList.add(review2);
        reviewList.add(review3);
        reviewList.add(review4);
        reviewList.add(review5);

        reviewAdapter = new ReviewAdapter(reviewList);
        rcvReview.setAdapter(reviewAdapter);

        commentAdapter = new CommentAdapter(reviewList);
        rcvComment.setAdapter(commentAdapter);


        // =========================================
        tabLayout = findViewById(R.id.tabLayout);
        contentFrame = findViewById(R.id.contentFrame);

        // Thêm 2 tab
        tabLayout.addTab(tabLayout.newTab().setText("Chương"));
        tabLayout.addTab(tabLayout.newTab().setText("Có thể bạn thích"));

        // Load tab đầu tiên mặc định
        loadFragment(new ChapterFragment());

        // Lắng nghe sự kiện chọn tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    loadFragment(new ChapterFragment());
                } else if (tab.getPosition() == 1) {
                    loadFragment(new MinghtLikeFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .commit();
    }



    private void makeStatusBarTransparent() {
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }


    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.box_open_book_activity);

        if (contentContainer != null) {
            int statusBarHeight = getStatusBarHeight();
            contentContainer.setPadding(0, statusBarHeight, 0, 0);
        }
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
