package com.example.bai20;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter {

    private List<UserModel> itemListSearchAdapter = new ArrayList<>();

    public SearchAdapter(List<UserModel> itemListSearch) {
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_item, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SearchViewHolder) holder).searchName.setText(itemListSearchAdapter.get(position).getNv106());
    }

    @Override
    public int getItemCount() {
        if (itemListSearchAdapter != null) return itemListSearchAdapter.size();
        else return 0;
    }

    public void setDataList(List<UserModel> itemListSearch) {
        this.itemListSearchAdapter = itemListSearch;
    }

    private class SearchViewHolder extends RecyclerView.ViewHolder {
        private TextView searchName;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchName = itemView.findViewById(R.id.search_listitem_name);
        }
    }
}
