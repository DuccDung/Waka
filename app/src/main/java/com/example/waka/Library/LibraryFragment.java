package com.example.waka.Library;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Book;
import com.example.waka.OpenBook.BookDetailAdapter;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryFragment extends Fragment {
    private RecyclerView recyclerBookView;
    private BookDetailAdapter Bookadapter;
    private List<Book> bookList;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library , container , false);
        makeStatusBarTransparent();
        applyTopPadding(view);
        recyclerBookView = view.findViewById(R.id.rcv_book_library);
        RecyclerView recyclerView = view.findViewById(R.id.rcv_cate_library);
        List<String> categories = Arrays.asList("Sách điện tử", "Sách nói", "Truyện tranh", "Sách hiệu sách", "Sách nước ngoài");

        LibraryCateAdapter adapter = new LibraryCateAdapter(categories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        // ============================================================
        GridLayoutManager layoutManagerBook = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerBookView.setLayoutManager(layoutManagerBook);

        loadSampleData();

        return view;
    }
    private void loadSampleData() {

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

        Bookadapter = new BookDetailAdapter(bookList);
        recyclerBookView.setAdapter(Bookadapter);

        Bookadapter.notifyDataSetChanged();
    }
    private void makeStatusBarTransparent() {
        Window window = requireActivity().getWindow();

        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        window.setStatusBarColor(Color.TRANSPARENT);
    }


    private void applyTopPadding(View view) {
        View contentContainer = view.findViewById(R.id.fragment_library);

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
