package com.example.bai20;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SearchFragment extends Fragment {


    private View rootView;
    private TextView iconBack, iconSearch;

    public SearchFragment() {
        // Required empty public constructor
    }


    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
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
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        iconBack = rootView.findViewById(R.id.tv_search_iconBack);
        iconSearch = rootView.findViewById(R.id.icon_search);
        MainActivity.callAnimationIn(rootView, getContext(), R.anim.slide_in_left, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Typeface myIconEdit = Typeface.createFromAsset(getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        iconBack.setTypeface(myIconEdit);
        iconSearch.setTypeface(myIconEdit);

        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.callAnimationOut(rootView, getContext(), R.anim.slide_out_right, new AnimationInf() {
                    @Override
                    public void afterAnim() {
                        if (dataPasserSearch != null) {
                            dataPasserSearch.getSearch("BACKSEARCH");
                        }
                    }
                });
            }
        });
    }

    //interface
    TuyenDung dataPasserSearch;

    public void passDataSearch(TuyenDung data) {
        this.dataPasserSearch = data;
    }


}