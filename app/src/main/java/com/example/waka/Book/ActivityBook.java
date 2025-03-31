package com.example.waka.Book;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityBook extends AppCompatActivity {

    private ViewPager2 viewPagerBook;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        makeStatusBarTransparent(); // làm trong suốt status bar
        applyTopPadding();          // tránh đè nội dung lên status bar nếu cần
        viewPagerBook = findViewById(R.id.viewPagerBook);

        List<String> pages = new ArrayList<>();
        pages.add("Trang 1: Ngày xửa ngày xưa...");
        pages.add("Trang 2: Có một cậu bé sống trong ngôi làng nhỏ...");
        pages.add("Trang 3: Một hôm, cậu quyết định lên đường...");
        pages.add("Trang 4: Cuộc hành trình bắt đầu...");
        // ... thêm bao nhiêu trang tùy bạn

        pageAdapter = new PageAdapter(pages);
        viewPagerBook.setAdapter(pageAdapter);

        // Tùy chọn: hiệu ứng như lật trang
        viewPagerBook.setPageTransformer(new DepthPageTransformer());
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
