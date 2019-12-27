package com.example.bai20;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tư Lầu on 12/23/19.
 */
public class ListAdapter extends RecyclerView.Adapter {
    private List<PageFragment1Model> itemList = new ArrayList<>();

    public ListAdapter(List<PageFragment1Model> itemList) {
        setData(itemList);
    }

    public ListAdapter() {
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //((ListViewHolder) holder).bindView(position);
        Typeface myIcon = Typeface.createFromAsset(holder.itemView.getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        ((ListViewHolder) holder).mItemIconEye.setTypeface(myIcon);

        Typeface myIconFlash = Typeface.createFromAsset(holder.itemView.getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        ((ListViewHolder) holder).mItemIconFlash.setTypeface(myIconFlash);

        ((ListViewHolder) holder).mItemTitle.setText(itemList.get(position).getTitle());
        ((ListViewHolder) holder).mItemViTri.setText(itemList.get(position).getVitri());
        ((ListViewHolder) holder).mItemLuong.setText(itemList.get(position).getLuong());
        ((ListViewHolder) holder).mItemSoluong.setText(itemList.get(position).getSoluong());
        ((ListViewHolder) holder).mItemThoiHan.setText(itemList.get(position).getThoihan());
        ((ListViewHolder) holder).mItemView.setText(itemList.get(position).getView());
        ((ListViewHolder) holder).mItemUngVien.setText(itemList.get(position).getUngvien());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setData(List<PageFragment1Model> itemList) {
        Log.e("A", "55");
        if (itemList != null) {
            Log.e("A", "66");
            this.itemList = itemList;
            notifyDataSetChanged();
            Log.e("A>>" + getItemCount(), this.itemList.toString());
        }
    }


    private class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView mItemTitle;
        private TextView mItemViTri;
        private TextView mItemLuong;
        private TextView mItemSoluong;
        private TextView mItemThoiHan;
        private TextView mItemView;
        private TextView mItemUngVien;
        private TextView mItemIconEye;
        private TextView mItemIconFlash;

        public ListViewHolder(View itemView) {
            super(itemView);
            mItemTitle = itemView.findViewById(R.id.li_title);
            mItemViTri = itemView.findViewById(R.id.li_vitri);
            mItemLuong = itemView.findViewById(R.id.li_luong);
            mItemSoluong = itemView.findViewById(R.id.li_soluong);
            mItemThoiHan = itemView.findViewById(R.id.li_thoihan);
            mItemView = itemView.findViewById(R.id.li_tvIconEye);
            mItemUngVien = itemView.findViewById(R.id.li_tvIconFlash);
            mItemIconEye = itemView.findViewById(R.id.li_icon_eye);
            mItemIconFlash = itemView.findViewById(R.id.li_iconFlash);
        }


//        public void bindView(int position){
//            mItemTitle.setText(DataOfPageFrg1.title[position]);
//            mItemViTri.setText(DataOfPageFrg1.vitri[position]);
//            mItemLuong.setText(DataOfPageFrg1.luong[position]);
//            mItemSoluong.setText(DataOfPageFrg1.soluong[position]);
//            mItemThoiHan.setText(DataOfPageFrg1.thoihan[position]);
//        }

//        public void onClick(View v) {
//
//        }
    }

}
