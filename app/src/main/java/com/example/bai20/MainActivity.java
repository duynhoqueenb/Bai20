package com.example.bai20;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ViewGroup containerRoot;
    ViewPager viewPager;
    TabLayout tabLayout;
    private FloatingActionButton buttonFab;
    private SampleFragmentPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        initTabView();
        final TextView tvTab0 = (TextView) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.tv_title);
        final TextView tvTab1 = (TextView) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.tv_title);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("TAG", "onPageScrolled");

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        tvTab0.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/helveticalmedium.ttf"));
                        tvTab0.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                        tvTab1.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/helveticallight.ttf"));
                        tvTab1.setTextColor(Color.parseColor("#000000"));
                        break;
                    case 1:
                        tvTab0.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/helveticallight.ttf"));
                        tvTab0.setTextColor(Color.parseColor("#000000"));
                        tvTab1.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/helveticalmedium.ttf"));
                        tvTab1.setTextColor(Color.parseColor("#000000"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TAG", "onPageScrollStateChanged");
            }
        });

        buttonFab = findViewById(R.id.fab);
        buttonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFragmentTuyenDung(v);
//                buttonFab.hide();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        TextView titleThongBao = findViewById(R.id.miThongBao);
//        titleThongBao.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/TuoiTreTV.ttf"));
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        containerRoot = (ViewGroup) getWindow().getDecorView().getRootView();

        return super.onCreateView(parent, name, context, attrs);

    }


    void initTabView() {
        View viewTab1 = LayoutInflater.from(this).inflate(R.layout.custom_tab, containerRoot, false);
        ((TextView) viewTab1.findViewById(R.id.tv_title)).setText("Tuyển Dụng");
        viewTab1.findViewById(R.id.tv_title).setSelected(true);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(viewTab1);

        View viewTab2 = LayoutInflater.from(this).inflate(R.layout.custom_tab, containerRoot, false);
        ((TextView) viewTab2.findViewById(R.id.tv_title)).setText("CV Cá Nhân");
        Typeface mytypeface = Typeface.createFromAsset(getAssets(),"fonts/helveticallight.ttf");
        ((TextView) viewTab2.findViewById(R.id.tv_title)).setTypeface(mytypeface);
        viewTab2.findViewById(R.id.tv_title).setSelected(true);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(viewTab2);
    }

    public static void reduceMarginsInTabs(TabLayout tabLayout, int marginOffset) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            for (int i = 0; i < ((ViewGroup) tabStrip).getChildCount(); i++) {
                View tabView = tabStripGroup.getChildAt(i);
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).leftMargin = marginOffset;
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).rightMargin = marginOffset;
                }
            }
            tabLayout.requestLayout();
        }
    }

    public void AddFragmentTuyenDung(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        Fragment fragment = null;
        fragment = FragmentAddTuyenDung.newInstance();

        ((FragmentAddTuyenDung)fragment).passData(new TuyenDung() {
            @Override
            public void getTuyenDung(String congviec, String mucluong, String soluong, String thoihan, String diadiem) {

            }
        });
        fragmentTransaction.replace(R.id.placeholder, fragment);
        fragmentTransaction.addToBackStack("optional tag");
        fragmentTransaction.commitAllowingStateLoss();


    }

}
