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
 * Created by Tư Lầu on 12/24/19.
 */
public class ListAdapter2 extends RecyclerView.Adapter {


    private List<PageFragment2Model> itemList2 = new ArrayList<>();

    public ListAdapter2(List<PageFragment2Model> itemList2) {
        if (itemList2 != null) {
            this.itemList2 = itemList2;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
        return new ListViewHolder2(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder2) holder).title2.setText(itemList2.get(position).getTitle2());
        ((ListViewHolder2) holder).year2.setText(itemList2.get(position).getYear());

        Typeface myIconEx = Typeface.createFromAsset(holder.itemView.getContext().getAssets(),"fonts/TuoiTreTV.ttf");
        ((ListViewHolder2) holder).icon2.setTypeface(myIconEx);
    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    private class ListViewHolder2 extends RecyclerView.ViewHolder{

        private TextView title2;
        private TextView year2;
        private TextView icon2;

        public ListViewHolder2(View itemView2){
            super(itemView2);
            title2 = itemView2.findViewById(R.id.li_title2);
            icon2 = itemView2.findViewById(R.id.li_iconEx);
            year2 = itemView2.findViewById(R.id.li_year);
        }
    }
}
