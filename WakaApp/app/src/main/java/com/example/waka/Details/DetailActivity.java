package com.example.waka.Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;

import com.example.waka.Model.Book;
import com.example.waka.Model.CategoryItem;
import com.example.waka.OpenBook.BookDetailAdapter;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    View contentContainer;
    private RecyclerView rcvBookDetail;
    private BookDetailAdapter bookDetailAdapter;
    private RecyclerView rcvCate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SetColorBar();
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
        window.setStatusBarColor(Color.TRANSPARENT);
        // Gán view cần set padding
        contentContainer = findViewById(R.id.content_detail_container);
        rcvCate = findViewById(R.id.rcv_Category_in_detail);
        // Tính chiều cao status bar và set padding
        int statusBarHeight = getStatusBarHeight();
        contentContainer.setPadding(0, statusBarHeight, 0, 0);


        String[] categories = {"Ngôn tình", "Kinh dị", "Trinh thám", "Hài hước"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item_category,
                categories
        );


        Book book1 = new Book();
        book1.setName("The Alchemist");
        book1.setImg(R.drawable.book1);

        Book book2 = new Book();
        book2.setName("Atomic Habits");
        book2.setImg(R.drawable.book2);

        Book book3 = new Book();
        book3.setName("Thinking Fast and Slow");
        book3.setImg(R.drawable.book3);

        Book book4 = new Book();
        book4.setName("Rich Dad Poor Dad");
        book4.setImg(R.drawable.book4);

        Book book5 = new Book();
        book5.setName("Ikigai");
        book5.setImg(R.drawable.book5);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);


        rcvBookDetail = findViewById(R.id.rcv_book_detail);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2); // 2 cột
        rcvBookDetail.setLayoutManager(layoutManager);
        bookDetailAdapter = new BookDetailAdapter(bookList);
        rcvBookDetail.setAdapter(bookDetailAdapter);



        RecyclerView recyclerView = findViewById(R.id.rcv_Category_in_detail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CategoryItem> categoryList = new ArrayList<>();
        categoryList.add(new CategoryItem("Ngôn Tình"));
        categoryList.add(new CategoryItem("Hành Động"));
        categoryList.add(new CategoryItem("Hài Hước"));
        categoryList.add(new CategoryItem("Tâm Lý"));
        categoryList.add(new CategoryItem("Kinh Dị"));

        CategoryAdapter cateAdapter = new CategoryAdapter(categoryList);
        recyclerView.setAdapter(cateAdapter);

    }
    public void SetColorBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.color_background_primary));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.color_background_primary));
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