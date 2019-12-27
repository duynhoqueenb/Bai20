package com.example.bai20;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {

    private List<PageFragment1Model> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        recyclerView = view.findViewById(R.id.listRecyclerView1);
        recyclerView.setHasFixedSize(true);



        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        listAdapter.setData(itemList);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        createItemListData();
    }

    public void createItemListData() {

        for (int i = 0; i <= 10; i++) {
            PageFragment1Model datalist = new PageFragment1Model("Cong ty CP VietLive " + i, "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
            itemList.add(datalist);
        }

//        PageFragment1Model datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);
//
//        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
//        itemList.add(datalist);

    }

    void addData(PageFragment1Model objAdd) {
        Log.e("A", "222");
        if (objAdd != null) {
            Log.e("A" + itemList.size(), "3333");
            itemList.add(objAdd);
            if (listAdapter == null) {
                listAdapter = new ListAdapter();
            }
            listAdapter.setData(itemList);
        }
    }
}
