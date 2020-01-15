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

public class NavigationListAdapter extends RecyclerView.Adapter {
    private List<NavigationItemModel> itemNavList = new ArrayList<>();
    private OnItemClickListener listenerNav;

    public void setOnClickNav(OnItemClickListener listener) {
        this.listenerNav = listener;
    }

    public NavigationListAdapter(List<NavigationItemModel> itemNavList) {
        if (itemNavList != null) {
            this.itemNavList = itemNavList;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, parent, false);
        return new NavigationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ((NavigationViewHolder) holder).icon.setText(itemNavList.get(position).getIcon());
        ((NavigationViewHolder) holder).title.setText(itemNavList.get(position).getTitle());

        Typeface myIconEx = Typeface.createFromAsset(holder.itemView.getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        ((NavigationViewHolder) holder).icon.setTypeface(myIconEx);

        ((NavigationViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerNav.onNavItemClick(itemNavList.get(position),holder.getLayoutPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemNavList.size();
    }

    private class NavigationViewHolder extends RecyclerView.ViewHolder {
        private TextView icon;
        private TextView title;

        public NavigationViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.nav_item_icontaikhoan);
            title = itemView.findViewById(R.id.nav_item_taikhoan);
        }
    }
}
