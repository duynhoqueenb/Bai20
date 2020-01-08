package com.example.bai20;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
        final View view = inflater.inflate(R.layout.fragment_page, container, false);
        recyclerView = view.findViewById(R.id.listRecyclerView1);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        listAdapter.setData(itemList);
        //item onclick
        listAdapter.setOnClick(new OnItemClickListener() {
            @Override
            public void onItemClick(PageFragment1Model itemModel, int position) {

                PageFragment1Model objItemUngVien = new PageFragment1Model(itemModel.getTitle(), itemModel.getVitri(), itemModel.getLuong(), itemModel.getSoluong(), itemModel.getThoihan(), itemModel.getView(), itemModel.getUngvien());

                final ItemFragment fragment = ItemFragment.newInstance(objItemUngVien, position);
                fragment.setParent(PageFragment.this);
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right,R.anim.pop_enter,R.anim.pop_exit).add(R.id.placeholder, fragment).commitAllowingStateLoss();

                fragment.passData2(new TuyenDung() {
                    @Override
                    public void getTuyenDung(PageFragment1Model tuyendungObj, String msg) {
                        switch (msg) {
                            case "BACK2":
                                callCloseFragment(fragment);

                                if (dataPasserItem != null) {
                                    dataPasserItem.getTuyenDung(null, "BACK");
                                }
                                break;
                        }
                    }
                });

                if (dataPasserItem != null) {
                    dataPasserItem.getTuyenDung(null, "NEXT");
                }

            }

            @Override
            public void onUngVienClick(PageFragment1Model itemModel, int position) {
                callUngVienFragment(itemModel, position,"UNGVIEN");
                if (dataPasserItem != null) {
                    dataPasserItem.getTuyenDung(null, "NEXT");
                }
            }
        });

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

    TuyenDung dataPasserItem;

    void passDataPaserItem(TuyenDung data) {
        this.dataPasserItem = data;
    }

    void callCloseFragment(final Fragment thisFragment) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getFragmentManager().beginTransaction().remove(thisFragment).commitAllowingStateLoss();
            }
        });
    }

    void callUngVienFragment(PageFragment1Model mObjectUngVien, int loadInfoPosition, String key) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        final UngVienFragment fragment = UngVienFragment.newInstance(mObjectUngVien, loadInfoPosition);

        fragmentTransaction.add(R.id.placeholder, fragment);
        fragmentTransaction.commitAllowingStateLoss();
        switch (key) {
            case "UNGVIEN":
                fragment.passDataUVDetail(new TuyenDung() {
                    @Override
                    public void getTuyenDung(PageFragment1Model tuyendungObj, String msg) {
                        switch (msg) {
                            case "BACKUVDETAIL":
                                callCloseFragment(fragment);
                                if (dataPasserItem != null) {
                                    dataPasserItem.getTuyenDung(null, "BACK");
                                }
                                break;
                        }
                    }
                });
                break;
            case "ITEM":
                fragment.passDataUVDetail(new TuyenDung() {
                    @Override
                    public void getTuyenDung(PageFragment1Model tuyendungObj, String msg) {
                        switch (msg) {
                            case "BACKUVDETAIL":
                                callCloseFragment(fragment);
                                break;
                        }
                    }
                });
                break;
        }

    }
}
