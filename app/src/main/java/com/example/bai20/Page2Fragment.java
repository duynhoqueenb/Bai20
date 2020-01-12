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


public class Page2Fragment extends Fragment {

    private static final String KEY_2 = "Key2";

    private List<PageFragment2Model> itemList2 = new ArrayList<>();
    private RecyclerView recyclerView2;
    private ListAdapter2 listAdapter2;
    private RecyclerView.LayoutManager layoutManager2;

    private  int mPage2;


    public Page2Fragment() {
        // Required empty public constructor
    }

    public static Page2Fragment newInstance(int page) {
        Page2Fragment fragment = new Page2Fragment();
        Bundle args = new Bundle();
        args.putInt(KEY_2, page);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage2 = getArguments().getInt(KEY_2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_page2, container, false);

        recyclerView2 = view2.findViewById(R.id.listRecyclerView2);
        recyclerView2.setHasFixedSize(true);

        createItemListData2();

        listAdapter2 = new ListAdapter2(itemList2);
        recyclerView2.setAdapter(listAdapter2);
        layoutManager2 = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(layoutManager2);


        return view2;
    }

    private void createItemListData2() {
        PageFragment2Model dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Giam doc kinh doanh","5 nam");
        itemList2.add(dataList2);

        dataList2 = new PageFragment2Model("Truong phong nhan su","2 nam");
        itemList2.add(dataList2);
    }


}
