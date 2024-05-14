package com.example.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.model.RecentData;

import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentViewHolder> {

    Context context;
    List<RecentData> recentDataList;

    public RecentAdapter(Context context, List<RecentData> recentDataList) {
        this.context = context;
        this.recentDataList = recentDataList;
    }

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false);
        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {
        holder.district.setText(recentDataList.get(position).getDistrict());
        holder.placeName.setText(recentDataList.get(position).getPlaceName());
        holder.grade.setText(recentDataList.get(position).getGrade());
        holder.placeImage.setImageResource(recentDataList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return recentDataList.size();
    }

    public static final class RecentViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, district, grade;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.mem_name);
            district = itemView.findViewById(R.id.mem_nic);
            grade = itemView.findViewById(R.id.view_hotel_name);

        }
    }
}
