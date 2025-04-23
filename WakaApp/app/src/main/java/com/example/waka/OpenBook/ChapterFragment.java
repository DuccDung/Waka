package com.example.waka.OpenBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class ChapterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);

        // Tạo danh sách chương
        List<String> chapterList = new ArrayList<>();
        chapterList.add("Chương 1: Xin lỗi, gia phả nhà tao không có mày");
        chapterList.add("Chương 2: Mày không xứng đáng");
        chapterList.add("Chương 3: Tao sẽ cho mày thấy địa ngục là như thế nào");
        chapterList.add("Chương 4: Không ai có thể thay thế được tao");
        chapterList.add("Chương 5: Tạm biệt, kẻ phản bội");

        // Gán dữ liệu vào RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rcv_chapter_in_open_book);
        ChapterAdapter adapter = new ChapterAdapter(getContext(), chapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
