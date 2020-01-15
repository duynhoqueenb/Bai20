package com.example.bai20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TkDoanhNghiepFragment extends Fragment {





    public TkDoanhNghiepFragment() {
        // Required empty public constructor
    }


    public static TkDoanhNghiepFragment newInstance() {
        TkDoanhNghiepFragment fragment = new TkDoanhNghiepFragment();

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
        return inflater.inflate(R.layout.fragment_tk_doanh_nghiep, container, false);
    }
}