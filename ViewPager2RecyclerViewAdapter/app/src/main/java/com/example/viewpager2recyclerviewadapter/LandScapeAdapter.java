package com.example.viewpager2recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View vItem = layoutInflater.inflate(R.layout.item_land,parent,false);
        ItemLandHolder viewHolderCreate = new ItemLandHolder(vItem);
        return viewHolderCreate;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //lay doi tuong hien thi
        LandScape landScapeHienThi = listData.get(position);
        //Trichs thong tin
        String caption = landScapeHienThi.getLandCaption();
        String imgName = landScapeHienThi.getLandImageFileName();
        //Dat vao cac truong thong tin cua holder
        //dat ten caption
        holder.tvCaption.setText(caption);
        //Dat anh
            String packageName = holder.itemView.getContext().getPackageName();
            int imgID = holder.itemView.getResources().getIdentifier(imgName,"mipmap",packageName);
        holder.imgViewLandScape.setImageResource(imgID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView imgViewLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            imgViewLandScape = itemView.findViewById(R.id.imageViewLand);
        }
    }
}
