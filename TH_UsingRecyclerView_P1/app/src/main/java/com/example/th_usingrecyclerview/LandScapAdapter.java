package com.example.th_usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapAdapter extends RecyclerView.Adapter<LandScapAdapter.ItemLandHolder> {
    private Context context;
    private ArrayList<LandScape> listData;

    public LandScapAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_land, parent, false);
        return new ItemLandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        LandScape landScape = listData.get(position);
        String caption = landScape.getLandCaption();
        holder.tvCaption.setText(caption);

        // Set ảnh
        String tenAnh = landScape.getLandImageFileName();
        int imageID = context.getResources().getIdentifier(tenAnh, "mipmap", context.getPackageName());
        holder.imageViewLandscape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class ItemLandHolder extends RecyclerView.ViewHolder {
        TextView tvCaption;
        ImageView imageViewLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaptiuon);
            imageViewLandscape = itemView.findViewById(R.id.imageViewLand);
        }
    }
}
