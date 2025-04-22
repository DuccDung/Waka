package com.example.waka.Chapter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.waka.OpenBook.ChapterAdapter;
import com.example.waka.R;
import com.google.android.material.tabs.TabLayout;

public class ChapterActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chapter);
        applyTopPadding();

        String[] tabTitles = {"Mục lục", "Dấu trang", "Ghi chú", "Bình luận"};
        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frame_layout_in_chapter);
        fragmentManager = getSupportFragmentManager();

        // Adding tabs
        for (String title : tabTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout_in_chapter, new FragmentChooseChapter())
                .commit();
        // Setting tab selected listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment selectedFragment = null;

                switch (tab.getPosition()) {
                    case 0:
                        selectedFragment = new FragmentChooseChapter();
                        break;
                    case 3:
                        selectedFragment = new FragmentComment();
                        break;
                }

                // Replace the current fragment with the selected one
                if (selectedFragment != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_layout_in_chapter, selectedFragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void makeStatusBarTransparent() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.toolbar);
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
