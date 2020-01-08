package com.example.bai20;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tư Lầu on 1/4/20.
 */
public class UngVienListAdapter extends RecyclerView.Adapter {
    private List<UngVienModel> itemListUngVien = new ArrayList<>();

    public UngVienListAdapter(List<UngVienModel> itemListUngVien) {
        if (itemListUngVien != null) {
            this.itemListUngVien = itemListUngVien;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ungvien_list_item,parent,false);
        return new UngVienListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((UngVienListViewHolder)holder).vitri.setText(itemListUngVien.get(position).getVitri());
        ((UngVienListViewHolder)holder).ten.setText(itemListUngVien.get(position).getTen());
        ((UngVienListViewHolder)holder).gioi.setText(itemListUngVien.get(position).getGioitinh());
        ((UngVienListViewHolder)holder).tuoi.setText(itemListUngVien.get(position).getTuoi());
        ((UngVienListViewHolder)holder).diadiem.setText(itemListUngVien.get(position).getDiadiem());
        ((UngVienListViewHolder)holder).kinhnghiem.setText(itemListUngVien.get(position).getKinhnghiem());

        Typeface myIcon = Typeface.createFromAsset(holder.itemView.getContext().getAssets(),"fonts/TuoiTreTV.ttf");
        ((UngVienListViewHolder)holder).iconTime.setTypeface(myIcon);
        ((UngVienListViewHolder)holder).iconUser.setTypeface(myIcon);
        ((UngVienListViewHolder)holder).iconFlash.setTypeface(myIcon);
    }

    @Override
    public int getItemCount() {
        return itemListUngVien.size();
    }

    private class UngVienListViewHolder extends RecyclerView.ViewHolder{
        private TextView vitri;
        private TextView ten;
        private TextView gioi;
        private TextView tuoi;
        private TextView diadiem;
        private TextView kinhnghiem;
        private TextView iconUser;
        private TextView iconTime,iconFlash;
        public UngVienListViewHolder(@NonNull View itemView) {
            super(itemView);
            vitri = itemView.findViewById(R.id.itemUV_vitri);
            ten = itemView.findViewById(R.id.itemUV_ten);
            gioi = itemView.findViewById(R.id.itemUV_gioitinh);
            tuoi = itemView.findViewById(R.id.itemUV_tuoi);
            diadiem = itemView.findViewById(R.id.itemUV_diadiem);
            kinhnghiem = itemView.findViewById(R.id.itemUV_kinhnghiem);
            iconTime = itemView.findViewById(R.id.itemUV_iconTime);
            iconUser = itemView.findViewById(R.id.itemUV_iconUser);
            iconFlash = itemView.findViewById(R.id.tv_uv_lichhen_icon);
        }
    }
}
