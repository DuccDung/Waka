package com.example.waka.Home.Banner;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class CarouselTransformer implements ViewPager2.PageTransformer {

    @Override
    public void transformPage(@NonNull View page, float position) {
        float minScale = 0.85f; // kích thước nhỏ nhất của item hai bên
        float minAlpha = 0.5f;  // độ mờ thấp nhất của item hai bên

        if (position < -1 || position > 1) {
            // item nằm ngoài màn hình
            page.setScaleX(minScale);
            page.setScaleY(minScale);
            page.setAlpha(minAlpha);
        } else {
            // item đang nằm trong khoảng [-1,1]
            float scaleFactor = Math.max(minScale, 1 - Math.abs(position) * 0.15f);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            // độ mờ (alpha) giảm dần theo vị trí
            float alphaFactor = Math.max(minAlpha, 1 - Math.abs(position) * 0.5f);
            page.setAlpha(alphaFactor);
        }

        // dịch chuyển item nhẹ nhàng tạo hiệu ứng carousel
        page.setTranslationX(-position * page.getWidth() * 0.1f);

        // đưa item ở giữa nổi bật lên trên các item khác
        page.setTranslationZ(position == 0 ? 1 : 0);
    }
}
