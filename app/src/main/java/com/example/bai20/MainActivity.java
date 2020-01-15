package com.example.bai20;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ViewGroup containerRoot;
    ViewPager viewPager;
    TabLayout tabLayout;
    public static FloatingActionButton buttonFab;
    private SampleFragmentPagerAdapter pagerAdapter;
    private FragmentManager fragmentManager;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView icon_thongbao = findViewById(R.id.icon_thongbao);
        icon_thongbao.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/TuoiTreTV.ttf"));
        TextView icon_navigate = findViewById(R.id.icon_navigate);
        icon_navigate.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/TuoiTreTV.ttf"));

        //add Drawer Layout
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nvView);
        addFragmentNav();
        icon_navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout != null) {
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }
            }
        });


        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        ArrayList<Fragment> lst = new ArrayList<>();
        PageFragment f1 = PageFragment.newInstance(0);
        Page2Fragment f2 = Page2Fragment.newInstance(1);
        f1.passDataPaserItem(new TuyenDung() {
            @Override
            public void getTuyenDung(PageFragment1Model tuyendungObj, String msg) {
                switch (msg) {
                    case "NEXT":
                        buttonFab.hide();
                        break;
                    case "BACK":
                        buttonFab.show();
                        break;
                }
            }
        });
        lst.add(f1);
        lst.add(f2);
        pagerAdapter.setFragments(lst);
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

                switch (position) {
                    case 0:
                        tvTab0.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/helveticalmedium.ttf"));
                        tvTab0.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
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
                buttonFab.hide();
            }
        });


    }

    private void addFragmentNav() {
        final Fragment fragment = NavigationFragment.newInstance();
        ((NavigationFragment) fragment).passDataPaserItemNav(new NavigationItem() {
            @Override
            public void getNavigationItem(NavigationItemModel objNav, String msg) {
                switch (msg){
                    case "NAVCALLBACK":
                        switch (objNav.getId()){
                            case 0:
                                drawerLayout.closeDrawer(GravityCompat.START);
                                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                                buttonFab.hide();
                                Fragment fragmentTKDN = TkDoanhNghiepFragment.newInstance();
                                FragmentTransaction fragmentTransactionTKDN = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionTKDN.add(R.id.placeholder,fragmentTKDN);
                                fragmentTransactionTKDN.commitAllowingStateLoss();
                                break;
                        }
                        break;
                }
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rl_navigation, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        Tit titleThongBao = findViewById(R.id.miThongBao);
//        titleThongBao.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/TuoiTreTV.ttf"));
//        return true;
//    }

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
        Typeface mytypeface = Typeface.createFromAsset(getAssets(), "fonts/helveticallight.ttf");
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

    public void AddFragmentTuyenDung(View view) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Fragment fragment = FragmentAddTuyenDung.newInstance();

//        ((FragmentAddTuyenDung) fragment).passData(new TuyenDung() {
//            @Override
//            public void getTuyenDung(String congviec, String mucluong, String soluong, String thoihan, String diadiem) {
//                PageFragment1Model objAdd = new PageFragment1Model(congviec, diadiem, mucluong, "10", thoihan, "99", "ung vien");
//                if (pagerAdapter.getItem(0) != null) {
//                    if (pagerAdapter.getItem(0) instanceof PageFragment) {
//                        ((PageFragment) pagerAdapter.getItem(0)).addData(objAdd);
//                    }
//                }
//            }
//        });
        ((FragmentAddTuyenDung) fragment).passData(new TuyenDung() {
            @Override
            public void getTuyenDung(PageFragment1Model tuyendungObj, String msg) {
                switch (msg) {
                    case "DATA":
                        //call du lieu ra
                        if (pagerAdapter.getItem(0) != null) {
                            if (pagerAdapter.getItem(0) instanceof PageFragment && tuyendungObj != null) {
                                ((PageFragment) pagerAdapter.getItem(0)).addData(tuyendungObj);
                            }
                        }
                        break;
                    case "BACK":
                        //callclose Fragment
                        buttonFab.show();
                        callCloseFragment(fragment);
                        break;
                }
            }
        });

        fragmentTransaction.replace(R.id.placeholder, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    void callCloseFragment(final Fragment thisFragment) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().remove(thisFragment).commitAllowingStateLoss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    public static void callAnimationOut(final View view, Context context, int idAnimation, final AnimationInf interfaceAnim) {
        if (view == null) return;
        Animation anim = AnimationUtils.loadAnimation(context, idAnimation);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                if (interfaceAnim != null) interfaceAnim.afterAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(anim);
    }

    public static void callAnimationIn(final View view, Context context, int idAnimation, final AnimationInf interfaceAnim) {
        if (view == null) return;
        Animation anim = AnimationUtils.loadAnimation(context, idAnimation);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (interfaceAnim != null) interfaceAnim.afterAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(anim);
    }
}
