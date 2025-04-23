package com.example.waka.OpenBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Book;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class MinghtLikeFragment extends Fragment {

    private RecyclerView rcvBookDetail;
    private BookDetailAdapter bookDetailAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_might_like, container, false);

        // Tạo dữ liệu sách mẫu
        List<Book> bookList = new ArrayList<>();

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

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        // Ánh xạ RecyclerView
        rcvBookDetail = view.findViewById(R.id.rcv_book_in_open);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3); // 2 cột
        rcvBookDetail.setLayoutManager(layoutManager);

        // Gắn adapter
        bookDetailAdapter = new BookDetailAdapter(bookList);
        rcvBookDetail.setAdapter(bookDetailAdapter);

        return view;
    }
}
