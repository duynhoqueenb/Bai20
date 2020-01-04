package com.example.bai20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Tư Lầu on 1/4/20.
 */
public class UngVienListAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ungvien_list_item,parent,false);
        return new UngVienListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class UngVienListViewHolder extends RecyclerView.ViewHolder{

        public UngVienListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
