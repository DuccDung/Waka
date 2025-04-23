package com.example.waka.MenuBarInHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.waka.Model.BookSearch;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerViewBooks;
    BookAdapter bookAdapter;
    List<BookSearch> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        makeStatusBarTransparent();
        applyTopPadding();
        recyclerViewBooks = findViewById(R.id.recyclerSearch);
        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));

        bookList = new ArrayList<>();
        bookList.add(new BookSearch("Toàn thư chiêm tinh học nhập môn",
                "Sách điện tử  •  Joanna Martine Woolfolk",
                R.drawable.book1));

        bookList.add(new BookSearch("Nhà giả kim",
                "Sách điện tử  •  Paulo Coelho",
                R.drawable.book2));

        bookList.add(new BookSearch("Tư duy nhanh và chậm",
                "Sách điện tử  •  Daniel Kahneman",
                R.drawable.book3));

        // Gắn adapter
        bookAdapter = new BookAdapter(bookList);
        recyclerViewBooks.setAdapter(bookAdapter);
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