package com.example.waka.Home.Banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.R;

import java.util.List;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder> {

    private List<Integer> imageList;

    public ImageSliderAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
       // holder.imageSlide.setImageResource(imageList.get(position % imageList.size()));

        Glide.with(holder.imageSlide.getContext())
                .load(imageList.get(position % imageList.size()))
                .into(holder.imageSlide);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE; // để tạo hiệu ứng vô hạn
    }

    static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageSlide;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSlide = itemView.findViewById(R.id.imageSlide);
        }
    }
}

