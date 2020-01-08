package com.example.bai20;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class UngVienFragment extends Fragment {

    private List<UngVienModel> itemListUngVien = new ArrayList<>();
    private static final String KEYUNGVIEN = "keyungvien";
    private static final String KEYUNGVIEN2 = "keyungvien2";
    private TextView btnBack, iconEyes, iconFlash, title, vitri, luong, soluong, thoihan, luotview, luotungvien;
    private PageFragment1Model loadUngVien;

    public UngVienFragment() {
        // Required empty public constructor
    }


    public static UngVienFragment newInstance(PageFragment1Model mObjectUngVien, Integer positon) {
        UngVienFragment fragment = new UngVienFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEYUNGVIEN, mObjectUngVien);
        bundle.putInt(KEYUNGVIEN2, positon);
        fragment.setArguments(bundle);
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
        View view = inflater.inflate(R.layout.fragment_ung_vien, container, false);

        btnBack = view.findViewById(R.id.tv_ungvien_iconBack);
        iconEyes = view.findViewById(R.id.tv_uv_iconeye);
        iconFlash = view.findViewById(R.id.tv_uv_iconflash);
        title = view.findViewById(R.id.tv_ungvien_title);
        vitri = view.findViewById(R.id.tv_ungvien_vitri);
        luong = view.findViewById(R.id.tv_ungvien_luong);
        soluong = view.findViewById(R.id.tv_ungvien_soluong);
        thoihan = view.findViewById(R.id.tv_ungvien_thoihan);
        luotview = view.findViewById(R.id.tv_uv_view);
        luotungvien = view.findViewById(R.id.tv_uv_luotUV);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        creatDataUngVien();
        RecyclerView.LayoutManager layoutManagerUngVien = new LinearLayoutManager(getContext());
        ((RecyclerView) view.findViewById(R.id.rv_ungvien)).setLayoutManager(layoutManagerUngVien);
        UngVienListAdapter ungVienListAdapter = new UngVienListAdapter(itemListUngVien);
        ((RecyclerView) view.findViewById(R.id.rv_ungvien)).setAdapter(ungVienListAdapter);

        Typeface myicon = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        btnBack.setTypeface(myicon);
        iconEyes.setTypeface(myicon);
        iconFlash.setTypeface(myicon);

        loadUngVien = (PageFragment1Model) getArguments().getSerializable(KEYUNGVIEN);
        title.setText(loadUngVien.getTitle());
        vitri.setText(loadUngVien.getVitri());
        luong.setText(loadUngVien.getLuong());
        soluong.setText(loadUngVien.getSoluong());
        thoihan.setText(loadUngVien.getThoihan());
        luotview.setText(loadUngVien.getView());
        luotungvien.setText(loadUngVien.getUngvien());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataUngVienDetail != null) {
                    dataUngVienDetail.getTuyenDung(null, "BACKUVDETAIL");
                }
            }
        });
    }

    private void creatDataUngVien() {
        for (int i = 0; i < 10; i++) {
            UngVienModel dataUngVien = new UngVienModel("Nhan vien 2D", "Nguyen Van A", "Nam", "26 tuoi", "HCM", "3 nam");
            itemListUngVien.add(dataUngVien);
        }
    }

    TuyenDung dataUngVienDetail;

    public void   passDataUVDetail(TuyenDung data) {
        this.dataUngVienDetail = data;
    }
}
