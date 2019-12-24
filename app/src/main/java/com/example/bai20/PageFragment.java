package com.example.bai20;

import android.os.Bundle;
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

        createItemListData();

        listAdapter = new ListAdapter(itemList);
        recyclerView.setAdapter(listAdapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    public void createItemListData() {
        PageFragment1Model datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

        datalist = new PageFragment1Model("Cong ty CP VietLive", "Nhan vien thiet ke", "15-18 trieu", "So luong: 5 nguoi", "Thoi han: 30/12/2019", "700", "Ung vien (3)");
        itemList.add(datalist);

    }
}
