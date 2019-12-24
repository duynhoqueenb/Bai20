package com.example.bai20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentAddTuyenDung extends Fragment {

    private TextView tv_thugon;
    private TextView tv_gt_content;





    public FragmentAddTuyenDung() {
        // Required empty public constructor
    }

    public static FragmentAddTuyenDung newInstance() {
        FragmentAddTuyenDung fragment = new FragmentAddTuyenDung();



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
        View rootView = inflater.inflate(R.layout.fragment_add_tuyen_dung, container, false);
        tv_thugon = rootView.findViewById(R.id.tv_thugon);
        tv_gt_content = rootView.findViewById(R.id.tv_gt_content);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            tv_thugon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tv_gt_content.getMaxLines() > 2){
                        tv_gt_content.setMaxLines(2);
                        tv_thugon.setText("Xem them");
                    }
                    else {
                        tv_gt_content.setMaxLines(8);
                        tv_thugon.setText("Thu gon");
                    }
                }
            });


    }
}
