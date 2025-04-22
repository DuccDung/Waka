package com.example.waka.Chapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.OpenBook.ChapterAdapter;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentChooseChapter extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_choose_chapter , container , false);
        // Tạo danh sách chương
        List<String> chapterList = new ArrayList<>();
        chapterList.add("Chương 1: Xin lỗi, gia phả nhà tao không có mày");
        chapterList.add("Chương 2: Mày không xứng đáng");
        chapterList.add("Chương 3: Tao sẽ cho mày thấy địa ngục là như thế nào");
        chapterList.add("Chương 4: Không ai có thể thay thế được tao");
        chapterList.add("Chương 5: Tạm biệt, kẻ phản bội");

        // Gán dữ liệu vào RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rcv_chapter_in_read_book);
        ChapterAdapter adapter = new ChapterAdapter(requireContext(), chapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
