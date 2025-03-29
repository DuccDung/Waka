package com.example.waka;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class OpenBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_book);

        makeStatusBarTransparent(); // làm trong suốt status bar
        applyTopPadding();          // tránh đè nội dung lên status bar nếu cần
    }

    /**
     * Làm status bar trong suốt để ảnh có thể tràn lên
     */
    private void makeStatusBarTransparent() {
        Window window = getWindow();

        // Cho phép vẽ dưới status bar
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        // Đặt màu status bar là trong suốt
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * Set padding top để tránh che mất nội dung bởi status bar (nếu cần)
     */
    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.box_open_book_activity);

        if (contentContainer != null) {
            int statusBarHeight = getStatusBarHeight();
            contentContainer.setPadding(0, statusBarHeight, 0, 0);
        }
    }

    /**
     * Hàm lấy chiều cao status bar của hệ thống
     */
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
