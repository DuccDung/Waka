package com.example.waka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.waka.Payment.PaymentActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    private BarChart barChart;
    private LineChart lineChart;
    private TextView btnDeposit;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        btnDeposit = view.findViewById(R.id.txtDeposit);
        makeStatusBarTransparent();
        applyTopPadding(view);


        btnDeposit.setOnClickListener(v -> {
            if (isAdded()) {
                Intent intent = new Intent(requireContext(), PaymentActivity.class);
                startActivity(intent);
            }
        });


        // Lấy lineChart từ layout
//        lineChart = view.findViewById(R.id.lineChart);
//        setupChart();
        barChart = view.findViewById(R.id.barChart);
        setupBarChart();


        return view;
    }

    private void setupBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 100)); // Vua Một
        entries.add(new BarEntry(1, 80));  // Một Thông Thái
        entries.add(new BarEntry(2, 60));  // Một Sách
        entries.add(new BarEntry(3, 30));  // Một...
        entries.add(new BarEntry(4, 5));   // Nhóm cuối

        BarDataSet dataSet = new BarDataSet(entries, "");
        dataSet.setColors(new int[]{
                Color.parseColor("#00FF00"), // xanh lá
                Color.parseColor("#FFFF00"), // vàng
                Color.parseColor("#FFA500"), // cam
                Color.parseColor("#FF6600"), // cam đậm
                Color.parseColor("#FF3300")  // đỏ
        });

        dataSet.setDrawValues(true); // Hiện số %
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(12f);

        BarData data = new BarData(dataSet);
        data.setBarWidth(0.9f);

        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBorders(false);
        barChart.setDescription(null);
        barChart.getLegend().setEnabled(false);
        barChart.setTouchEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.setPinchZoom(false);

        // Trục X
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(
                new String[]{"0%", "4%", "13%", "83%", ""}
        ));
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(entries.size());
        xAxis.setTextSize(11f);

        // Trục Y
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        barChart.invalidate();
    }

    private void setupChart() {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 100));
        entries.add(new Entry(1, 80));
        entries.add(new Entry(2, 60));
        entries.add(new Entry(3, 30));
        entries.add(new Entry(4, 5));

        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawFilled(true);
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setColor(Color.YELLOW);


        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.chart_gradient);
        dataSet.setFillDrawable(drawable);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.getLegend().setEnabled(false);

        Description description = new Description();
        description.setText("");
        lineChart.setDescription(description);

        lineChart.invalidate(); // Refresh chart
    }

    private void makeStatusBarTransparent() {
        Window window = requireActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    private void applyTopPadding(View view) {
        View contentContainer = view.findViewById(R.id.fragment_container);
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
