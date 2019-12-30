package com.example.bai20;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;


public class FragmentAddTuyenDung extends Fragment {

    private TextView tv_thugon;
    private TextView tv_gt_content;
    private TextView icon_edit;
    private TextView icon_edit2;
    private TextView icon_edit3;
    private TextView icon_edit4;
    private TextView icon_luunhap;
    private TextView icon_dangtin;
    private TextView icon_back;
    private LinearLayout ll_dangtin;
    private ImageView imgView_logo;
    private EditText tv_congViec;
    private EditText tv_mucLuong;
    private EditText tv_soLuong;
    private EditText tv_thoiHan;
    private EditText tv_diaDiem;


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
        icon_edit = rootView.findViewById(R.id.icon_edit);
        icon_edit2 = rootView.findViewById(R.id.icon_edit2);
        icon_edit3 = rootView.findViewById(R.id.icon_edit3);
        icon_edit4 = rootView.findViewById(R.id.icon_edit4);
        icon_luunhap = rootView.findViewById(R.id.icon_luunhap);
        icon_dangtin = rootView.findViewById(R.id.icon_dangtin);
        ll_dangtin = rootView.findViewById(R.id.ll_dangtin);
        imgView_logo = rootView.findViewById(R.id.view_logo);
        tv_congViec = rootView.findViewById(R.id.tv_congviec);
        tv_mucLuong = rootView.findViewById(R.id.tv_mucluong);
        tv_soLuong = rootView.findViewById(R.id.tv_soluong);
        tv_thoiHan = rootView.findViewById(R.id.tv_thoihan);
        tv_diaDiem = rootView.findViewById(R.id.tv_diadiem);
        icon_back = rootView.findViewById(R.id.icon_back);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_thugon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_gt_content.getMaxLines() > 2) {
                    tv_gt_content.setMaxLines(2);
                    tv_thugon.setText("Xem them");
                } else {
                    tv_gt_content.setMaxLines(8);
                    tv_thugon.setText("Thu gon");
                }
            }
        });

        Typeface myIconEdit = Typeface.createFromAsset(getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        icon_edit.setTypeface(myIconEdit);
        icon_edit2.setTypeface(myIconEdit);
        icon_edit3.setTypeface(myIconEdit);
        icon_edit4.setTypeface(myIconEdit);
        icon_luunhap.setTypeface(myIconEdit);
        icon_dangtin.setTypeface(myIconEdit);
        icon_back.setTypeface(myIconEdit);

        final FragmentManager fragmentManager = getFragmentManager();

        icon_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (fragmentManager.getBackStackEntryCount() > 0) {
//                    fragmentManager.popBackStack();
//                }

                if (dataPasser != null) {
                    dataPasser.getTuyenDung(null, "BACK");
                }
            }
        });

        ll_dangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_congViec.getText().toString().length() != 0 && tv_mucLuong.getText().toString().length() != 0 && tv_soLuong.getText().toString().length() != 0) {
                    if (dataPasser != null) {
                        //dataPasser.getTuyenDung(tv_congViec.getText().toString(), tv_mucLuong.getText().toString(), tv_soLuong.getText().toString(), tv_thoiHan.getText().toString(), tv_diaDiem.getText().toString());
                        PageFragment1Model obj = new PageFragment1Model(tv_congViec.getText().toString(), tv_mucLuong.getText().toString(), tv_soLuong.getText().toString(), tv_thoiHan.getText().toString(), tv_diaDiem.getText().toString(), "", "");
                        dataPasser.getTuyenDung(obj, "DATA");
                    }

                    icon_back.performClick();

//                    if (fragmentManager.getBackStackEntryCount() > 0) {
//                        fragmentManager.popBackStack();
//                    }

                } else Toast.makeText(getContext(), "Vui long nhap lai", Toast.LENGTH_SHORT).show();

            }
        });

        int px = convertToPx(11);
        GlideApp.with(this)
                .load("https://html5box.com/html5lightbox/images/Evening_1024.jpg")
                .transform(new CenterCrop(), new RoundedCorners(px)).into(imgView_logo);


        //tangdientich bam
//        expandTextArea(icon_back);

    }

    public int convertToPx(int dp) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }

    //interface
    TuyenDung dataPasser;

    public void passData(TuyenDung data) {
        this.dataPasser = data;
    }

    //tang dien tich
//    private void expandTextArea(View button){
//        final View parent = (View) button.getParent();
//        parent.post(new Runnable() {
//            @Override
//            public void run() {
//                final Rect rect = new Rect();
//                icon_back.getHitRect(rect);
//                rect.top -= 100;    // increase top hit area
//                rect.left -= 100;   // increase left hit area
//                rect.bottom += 100; // increase bottom hit area
//                rect.right += 100;  // increase right hit area
//                parent.setTouchDelegate( new TouchDelegate( rect , icon_back));
//            }
//        });
//    }

}
