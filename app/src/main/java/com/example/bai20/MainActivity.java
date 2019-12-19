package com.example.bai20;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ViewGroup containerRoot;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        final SampleFragmentPagerAdapter pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        initTabView();

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
                        ((TextView) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.tv_title)).setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), ""));
                        ((TextView) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.tv_title2)).setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), ""));
                        break;
                    case 1:
                        ((TextView) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.tv_title2)).setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), ""));
                        ((TextView) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.tv_title)).setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), ""));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("TAG", "onPageScrollStateChanged");
            }
        });

        reduceMarginsInTabs(tabLayout,70);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        containerRoot = (ViewGroup) getWindow().getDecorView().getRootView();

        return super.onCreateView(parent, name, context, attrs);

    }


    void initTabView() {
        View viewTab1 = LayoutInflater.from(this).inflate(R.layout.custom_tab, containerRoot, false);
        ((TextView) viewTab1.findViewById(R.id.tv_title)).setText("tab1");
        viewTab1.findViewById(R.id.tv_title).setSelected(true);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(viewTab1);

        View viewTab2 = LayoutInflater.from(this).inflate(R.layout.custom_tab, containerRoot, false);
        ((TextView) viewTab2.findViewById(R.id.tv_title2)).setText("tab2");
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
}
