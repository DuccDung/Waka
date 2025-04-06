package com.example.waka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.waka.Home.CategoryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class RankActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        makeStatusBarTransparent();
        applyTopPadding();
        // RecyclerView Cate
        recyclerView = findViewById(R.id.rcv_in_rank);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<String> dataList = new ArrayList<>(Arrays.asList(
                "Tổng", "Đọc sách", "Nghe sách",
                "Sách Hiệu Sồi", "Sách Tóm Tắt", "Podcast"
        ));

        categoryAdapter = new CategoryAdapter(dataList);
        recyclerView.setAdapter(categoryAdapter);
    }

    private void makeStatusBarTransparent() {
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }
    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.fragment_container);

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