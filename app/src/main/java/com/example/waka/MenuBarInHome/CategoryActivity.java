package com.example.waka.MenuBarInHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.waka.Library.LibraryCateAdapter;
import com.example.waka.Model.Book;
import com.example.waka.Model.Genre;
import com.example.waka.OpenBook.BookDetailAdapter;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CateAdapter itemAdapter;
    private ImageView imgSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        makeStatusBarTransparent();
        applyTopPadding();
        imgSearch = findViewById(R.id.imgSearchInBar);
        imgSearch.setOnClickListener(view -> {
            Intent intent = new Intent(this , SearchActivity.class);
            startActivity(intent);
        });
        // ============================= Cate ==========
        RecyclerView recyclerView = findViewById(R.id.rcvCategoryInBar);
        List<String> categories = Arrays.asList("Sách điện tử", "Sách nói", "Truyện tranh", "Sách hiệu sách", "Sách nước ngoài");
        LibraryCateAdapter adapter = new LibraryCateAdapter(categories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // ============================================

        RecyclerView recyclerGenres;
        GenreAdapter genreAdapter;
        List<Genre> genreList;
        recyclerGenres = findViewById(R.id.recyclerGenres);
        recyclerGenres.setLayoutManager(new LinearLayoutManager(this));

        genreList = new ArrayList<>();
        genreList.add(new Genre("Thơ - Tản văn", false));
        genreList.add(new Genre("Trinh thám - Kinh dị", true));
        genreList.add(new Genre("Marketing - Bán hàng", false));
        genreList.add(new Genre("Chứng khoán - Bất động sản - Đầu tư", true));
        genreList.add(new Genre("Khoa học - Công nghệ", false));

        genreAdapter = new GenreAdapter(genreList);
        recyclerGenres.setAdapter(genreAdapter);

    }
    private void makeStatusBarTransparent() {
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }
    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.barContainer);
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