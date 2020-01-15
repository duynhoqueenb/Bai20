package com.example.bai20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NavigationListAdapter extends RecyclerView.Adapter {
    private List<NavigationItemModel> itemNavList = new ArrayList<>();

    public NavigationListAdapter(List<NavigationItemModel> itemNavList) {
        if (itemNavList != null) {
            this.itemNavList = itemNavList;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item,parent,false);
        return new NavigationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemNavList.size();
    }

    private class NavigationViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public NavigationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
