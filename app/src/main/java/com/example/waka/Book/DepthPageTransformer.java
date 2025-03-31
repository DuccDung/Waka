package com.example.waka.Book;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class DepthPageTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position <= -1 || position >= 1) {
            page.setAlpha(0f); // ngoài màn hình
        } else if (position == 0f) {
            page.setAlpha(1f); // đang hiển thị
        } else {
            // Làm mờ + dịch trái/phải
            page.setAlpha(1 - Math.abs(position));
            page.setTranslationX(-position * page.getWidth());
        }
    }
}
