package com.example.bai20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class NavigationFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<NavigationItemModel> itemNav = new ArrayList<>();
    private NavigationListAdapter navAdaper;
    private RecyclerView.LayoutManager layoutNavManager;

    public NavigationFragment() {
        // Required empty public constructor
    }


    public static NavigationFragment newInstance() {
        NavigationFragment fragment = new NavigationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_navigation, container, false);

        recyclerView = view.findViewById(R.id.nav_header_rv);
        creatNavItem();
        navAdaper = new NavigationListAdapter(itemNav);
        recyclerView.setAdapter(navAdaper);
        layoutNavManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutNavManager);
        return view;
    }

    private void creatNavItem() {

        NavigationItemModel data = new NavigationItemModel(getString(R.string.icon_tkdn), "Tài khoản Doanh Nghiệp", 0);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_doitk), "Chuyển đổi tài khoản", 1);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_flash), "Lịch phỏng vấn", 2);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_package), "Gói dịch vụ", 3);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_about), "Thông tin ứng dụng", 4);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_terms), "Điều khoản sử dụng", 5);
        itemNav.add(data);

        data = new NavigationItemModel(getString(R.string.icon_share), "Giới thiệu Tuổi Trẻ Tìm Việc cho bạn bè", 6);
        itemNav.add(data);
    }
}