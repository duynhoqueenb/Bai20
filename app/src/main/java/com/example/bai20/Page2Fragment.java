package com.example.bai20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class Page2Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";



    private  int mPage2;


    public Page2Fragment() {
        // Required empty public constructor
    }

    public static Page2Fragment newInstance(int page) {
        Page2Fragment fragment = new Page2Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage2 = getArguments().getInt(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 = inflater.inflate(R.layout.fragment_page2, container, false);
        TextView textView = view2.findViewById(R.id.tv_2);
        textView.setText("Fragment #" + mPage2);
        return view2;
    }
}
