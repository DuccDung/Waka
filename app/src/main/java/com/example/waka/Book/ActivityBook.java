package com.example.waka.Book;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.waka.Model.DataBook;
import com.example.waka.Model.DataPageInBook;
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

        makeStatusBarTransparent();
        applyTopPadding();

        viewPagerBook = findViewById(R.id.viewPagerBook);

        List<DataPageInBook> bookPages = new ArrayList<>();

        List<DataBook> page1 = new ArrayList<>();
        page1.add(new DataBook("Chương 1: Ngày xửa ngày xưa..."));
        page1.get(0).setType(true);
        page1.add(new DataBook("Một ngôi làng yên bình bên triền núi."));
        page1.get(1).setType(true);
        bookPages.add(new DataPageInBook(1 ,page1));

        List<DataBook> page2 = new ArrayList<>();
        page2.add(new DataBook(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.au1)));
        page2.get(0).setType(false);
        page2.add(new DataBook("Hình minh họa: ngôi làng lúc bình minh."));
        page2.get(1).setType(true);
        bookPages.add(new DataPageInBook(2 ,page2));

        List<DataBook> page3 = new ArrayList<>();
        page3.add(new DataBook("Cuộc sống cứ thế trôi qua, cho đến một ngày nọ..."));
        page3.get(0).setType(true);
        bookPages.add(new DataPageInBook(3 ,page3));

        List<DataBook> page4 = new ArrayList<>();
        page4.add(new DataBook(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.au2)));
        page4.get(0).setType(false);
        bookPages.add(new DataPageInBook(4 ,page4));

        pageAdapter = new PageAdapter(this, bookPages);
        viewPagerBook.setAdapter(pageAdapter);

        // Hiệu ứng chuyển trang
        viewPagerBook.setPageTransformer(new DepthPageTransformer());
    }

    private void makeStatusBarTransparent() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
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
