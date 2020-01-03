package com.example.bai20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;



public class UngVienFragment extends Fragment {



    public UngVienFragment() {
        // Required empty public constructor
    }


    public static UngVienFragment newInstance() {
        UngVienFragment fragment = new UngVienFragment();

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
        return inflater.inflate(R.layout.fragment_ung_vien, container, false);
    }
}
