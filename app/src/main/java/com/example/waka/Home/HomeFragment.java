package com.example.waka.Home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.waka.Home.Banner.CarouselTransformer;
import com.example.waka.Home.Banner.ImageSliderAdapter;
import com.example.waka.MenuBarInHome.CategoryActivity;
import com.example.waka.Model.Author;
import com.example.waka.Model.Book;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<String> dataList;
    private ViewPager2 viewPager2;
    private View backgroundView;
    private ImageView imgBar;
    private final Handler sliderHandler = new Handler();

    private RecyclerView rcvBookTC;
    private BookAdapter bookAdapter;

    private RecyclerView rcvHorrifiedBook;
    private BookAdapter bookHorrifiedAdapter;

    private RecyclerView rcvMarketingBook;
    private BookAdapter bookMarketingAdapter;
    private RecyclerView rcvAuthor;
    private AuthorAdapter authorAdapter;
    private List<Book> books = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // bar
        imgBar = view.findViewById(R.id.imgBarInHome);
        imgBar.setOnClickListener(v->{
            if(requireContext() != null){
                Intent intent = new Intent(requireContext() , CategoryActivity.class);
                startActivity(intent);
            }
        });
        //
        // RecyclerView Cate
        recyclerView = view.findViewById(R.id.rcv_main_category);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // RecyclerView Khinh Dị
        rcvHorrifiedBook = view.findViewById(R.id.rcv_book_detective_horrified);
        rcvHorrifiedBook.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        // RecyclerView Ngôn tình
        rcvBookTC = view.findViewById(R.id.rcv_books);
        rcvBookTC.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // RecyclerView Marketing
        rcvMarketingBook = view.findViewById(R.id.rcv_book_marketing);
        rcvMarketingBook.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // RecyclerView Author
        rcvAuthor = view.findViewById(R.id.rcv_author);
        rcvAuthor.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // data cate ("Ae đẩy dữ liệu vào đây -> Category")
        dataList = new ArrayList<>(Arrays.asList(
                "Sách Điện Tử", "Sách Nói", "Chuyện Tranh",
                "Sách Hiệu Sồi", "Sách Tóm Tắt", "Podcast"
        ));

        categoryAdapter = new CategoryAdapter(dataList);
        recyclerView.setAdapter(categoryAdapter);
        // ====================================================
        // Sách Ngôn Tình

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

        bookAdapter = new BookAdapter(bookList);
        rcvBookTC.setAdapter(bookAdapter);

        bookHorrifiedAdapter = new BookAdapter(bookList);
        rcvHorrifiedBook.setAdapter(bookHorrifiedAdapter);

        bookMarketingAdapter = new BookAdapter(bookList);
        rcvMarketingBook.setAdapter(bookMarketingAdapter);

        Author author1 = new Author("Nguyễn Nhật Ánh", R.drawable.au1);
        Author author2 = new Author("Tô Hoài", R.drawable.au2);
        Author author3 = new Author("Nam Cao", R.drawable.au3);
        Author author4 = new Author("Xuân Quỳnh", R.drawable.au4);
        Author author5 = new Author("Nguyễn Huy Thiệp", R.drawable.au5);
        List<Author> authorList = new ArrayList<>();

        authorList.add(author1);
        authorList.add(author2);
        authorList.add(author3);
        authorList.add(author4);
        authorList.add(author5);

        authorAdapter = new AuthorAdapter(authorList);
        rcvAuthor.setAdapter(authorAdapter);
        // =====================================================

        // =====================================================
        // ViewPager2

        View contentContainer = view.findViewById(R.id.content_container);
        int statusBarHeight = getStatusBarHeight();
        contentContainer.setPadding(0, statusBarHeight, 0, 0);
        viewPager2 = view.findViewById(R.id.viewPager);
        backgroundView = view.findViewById(R.id.background_view);
        // image banner
        List<Integer> imageList = Arrays.asList(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3
        );

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        int pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        int pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        viewPager2.setPageTransformer((page, position) -> {
            float offset = position * -(2 * pageOffset + pageMargin);
            if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                page.setTranslationX(offset);
            } else {
                page.setTranslationY(offset);
            }
        });

        viewPager2.setPageTransformer(new CarouselTransformer());
        viewPager2.setAdapter(new ImageSliderAdapter(imageList));
        viewPager2.setCurrentItem(Integer.MAX_VALUE / 2);

        updateBackgroundColor(imageList.get(viewPager2.getCurrentItem() % imageList.size()));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
                updateBackgroundColor(imageList.get(position % imageList.size()));
            }
        });

        return view;
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 4000);
    }
    private int getAverageColor(Bitmap bitmap) {
        long redBucket = 0;
        long greenBucket = 0;
        long blueBucket = 0;
        long pixelCount = 0;

        for (int y = 0; y < bitmap.getHeight(); y += 10) {
            for (int x = 0; x < bitmap.getWidth(); x += 10) {
                int c = bitmap.getPixel(x, y);
                redBucket += Color.red(c);
                greenBucket += Color.green(c);
                blueBucket += Color.blue(c);
                pixelCount++;
            }
        }

        return Color.rgb(
                (int)(redBucket / pixelCount),
                (int)(greenBucket / pixelCount),
                (int)(blueBucket / pixelCount)
        );
    }
    private void updateBackgroundColor(int imageResId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResId);
        Palette.from(bitmap).generate(palette -> {
            if (palette != null) {
                int defaultColor = ContextCompat.getColor(requireContext(), android.R.color.black);
                int dominantColor = palette.getDominantColor(defaultColor);
                int averageColor = getAverageColor(bitmap);
                int startColor = addAlpha(dominantColor, 200); // 200 = ~78% độ mờ

                int endColor = android.graphics.Color.parseColor("#101318");

                // Gradient từ trên xuống dưới
                GradientDrawable gradientDrawable = new GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM,
                        new int[]{startColor, endColor}
                );
                gradientDrawable.setCornerRadius(0f);
                backgroundView.setBackground(gradientDrawable);
                //requireActivity().getWindow().setStatusBarColor(averageColor);
            }
        });
    }
    private int addAlpha(int color, int alpha) {
        return (alpha << 24) | (color & 0x00FFFFFF);
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