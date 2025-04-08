package com.example.waka.Audio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.waka.Comment.ReviewAdapter;
import com.example.waka.Model.Review;
import com.example.waka.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class AudioActivity extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior;
    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;
    List<Review> reviewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        makeStatusBarTransparent();
        applyTopPadding();
       LinearLayout bottomSheet = findViewById(R.id.bottomSheetContainer);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        ImageView btnReview = findViewById(R.id.btn_review_in_audio);
        btnReview.setOnClickListener(v -> {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        bottomSheetBehavior.setHideable(true);

        recyclerView = findViewById(R.id.recyclerReviews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewList = new ArrayList<>();
        reviewList.add(new Review("Trung Đình Tuấn", "Doc"));
        reviewList.add(new Review("tel_09409219***", "Truyện tình tiết nhanh..."));
        reviewList.add(new Review("nnn***", "68 chương như v là full chị ạ"));
        reviewList.add(new Review("0368948***", "Quá xuất sắc luôn đó. Luy đến giờ"));
        reviewList.add(new Review("Dolly My", "***"));
        reviewList.add(new Review("0353598***", "Mê Tiểu Tiểu với Diễn gia lắm luôn..."));

        reviewAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(reviewAdapter);
    }





    private void makeStatusBarTransparent() {
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }
    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.audio_container);

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