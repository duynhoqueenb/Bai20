package com.example.bai20;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;


public class ItemFragment extends Fragment {

    private static final String KEY = "key1";
    private static final String KEY2 = "key2";

    private TextView tvItemClose, tv_item_titleTop, tv_item_luong, tv_item_thoihan, tv_item_soluong, tv_item_vitri, tv_item_view, tv_item_ungvien,
            tvItemFlash, tvItemEyes, tvItemNext, tvThuGon, tvItemIntro, tvXemthem, tv_item_thietkeContent, tvXemthem2, tv_item_quyenloiContent;
    private ImageView img_item_logo;
    private RelativeLayout rlv_item_footer;

    private PageFragment1Model loadInfo;
    PageFragment parent;

    public ItemFragment() {
        // Required empty public constructor
    }


    public static ItemFragment newInstance(PageFragment1Model mObj, Integer mPosition) {
        ItemFragment fragment = new ItemFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, mObj);
        bundle.putInt(KEY2, mPosition);
        fragment.setArguments(bundle);
        return fragment;
    }

    void setParent(PageFragment pageFragment) {
        this.parent = pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);
        tvItemClose = rootView.findViewById(R.id.tv_item_iconClose);
        tvItemEyes = rootView.findViewById(R.id.tv_item_iconView);
        tvItemFlash = rootView.findViewById(R.id.tv_item_iconUv);
        tvItemNext = rootView.findViewById(R.id.tv_item_icon_next);
        tvThuGon = rootView.findViewById(R.id.tv_thugon);
        tvItemIntro = rootView.findViewById(R.id.tv_item_intro);
        tvXemthem = rootView.findViewById(R.id.tv_xemthem);
        tv_item_thietkeContent = rootView.findViewById(R.id.tv_item_thietkeContent);
        tvXemthem2 = rootView.findViewById(R.id.tv_xemthem2);
        tv_item_quyenloiContent = rootView.findViewById(R.id.tv_item_quyenloiContent);
        tv_item_titleTop = rootView.findViewById(R.id.tv_item_titleTop);
        tv_item_luong = rootView.findViewById(R.id.tv_item_luong);
        tv_item_thoihan = rootView.findViewById(R.id.tv_item_thoihan);
        tv_item_soluong = rootView.findViewById(R.id.tv_item_soluongUv);
        tv_item_vitri = rootView.findViewById(R.id.tv_item_thietke);
        tv_item_view = rootView.findViewById(R.id.tv_item_view);
        tv_item_ungvien = rootView.findViewById(R.id.tv_item_footer_ungvien);
        img_item_logo = rootView.findViewById(R.id.img_item_logo);
        rlv_item_footer = rootView.findViewById(R.id.rlv_item_footer);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Typeface myIconEdit = Typeface.createFromAsset(getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        tvItemClose.setTypeface(myIconEdit);
        tvItemEyes.setTypeface(myIconEdit);
        tvItemFlash.setTypeface(myIconEdit);
        tvItemNext.setTypeface(myIconEdit);

        tvThuGon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvItemIntro.getMaxLines() > 2) {
                    tvItemIntro.setMaxLines(2);
                    tvThuGon.setText("Xem them");
                } else {
                    tvItemIntro.setMaxLines(8);
                    tvThuGon.setText("Thu gon");
                }
            }
        });

        tvXemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_item_thietkeContent.getMaxLines() > 2) {
                    tv_item_thietkeContent.setMaxLines(2);
                    tvXemthem.setText("Xem them");
                } else {
                    tv_item_thietkeContent.setMaxLines(8);
                    tvXemthem.setText("Thu gon");
                }
            }
        });

        tvXemthem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_item_quyenloiContent.getMaxLines() > 2) {
                    tv_item_quyenloiContent.setMaxLines(2);
                    tvXemthem2.setText("Xem them");
                } else {
                    tv_item_quyenloiContent.setMaxLines(8);
                    tvXemthem2.setText("Thu gon");
                }
            }
        });

        loadInfo = (PageFragment1Model) getArguments().getSerializable(KEY);
        final int loadInfoPosition = getArguments().getInt(KEY2);

        tv_item_titleTop.setText(loadInfo.getTitle());
        tv_item_vitri.setText(loadInfo.getVitri());
        tv_item_luong.setText(loadInfo.getLuong());
        tv_item_thoihan.setText(loadInfo.getThoihan());
        tv_item_soluong.setText(loadInfo.getSoluong());
        tv_item_view.setText(loadInfo.getView());
        tv_item_ungvien.setText(loadInfo.getUngvien());

        int px = convertToPx(11);
        GlideApp.with(this)
                .load("https://html5box.com/html5lightbox/images/Evening_1024.jpg")
                .transform(new CenterCrop(), new RoundedCorners(px)).into(img_item_logo);

        tvItemClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataItemPasser2 != null) {
                    dataItemPasser2.getTuyenDung(null, "BACK2");
                }
            }
        });


        rlv_item_footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageFragment1Model mObjectUngVien = new PageFragment1Model(loadInfo.getTitle(), loadInfo.getVitri(), loadInfo.getLuong(), loadInfo.getSoluong(), loadInfo.getThoihan(), loadInfo.getView(), loadInfo.getUngvien());
                parent.callUngVienFragment(mObjectUngVien, loadInfoPosition);
            }
        });

    }

    public int convertToPx(int dp) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }

    TuyenDung dataItemPasser2;

    public void passData2(TuyenDung data) {
        this.dataItemPasser2 = data;
    }

    void callCloseFragment(final Fragment thisFragment) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getFragmentManager().beginTransaction().remove(thisFragment).commitAllowingStateLoss();
            }
        });
    }
}
