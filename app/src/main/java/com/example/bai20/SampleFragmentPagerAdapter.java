package com.example.bai20;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private Context context;
    private ArrayList<Fragment> lstFragments;

    Fragment fragment0, fragment1;

//    private String tabTitles[] = new String[]{"Tuyển dụng", "CV Cá Nhân"};
//    private int[] imageResId = {
//            R.drawable.ic_one,
//            R.drawable.ic_one
//    };


    void setFragments(ArrayList<Fragment> lstFragments) {
        this.lstFragments = lstFragments;
    }

    public SampleFragmentPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //return lstFragments.get(position);
        switch (position) {
            case 0:
                if (fragment0 == null) {
                    return fragment0 = PageFragment.newInstance(0);
                } else {
                    return fragment0;
                }

            case 1:
                if (fragment1 == null) {
                    return fragment1 = Page2Fragment.newInstance(1);
                } else {
                    return fragment1;
                }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        // Replace blank spaces with image icon
//        SpannableString sb = new SpannableString("   " + tabTitles[position]);
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
//    }

//    public View getTabView(int position) {
//        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
//        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
//
//        TextView tv = (TextView) v.findViewById(R.id.tv_title);
////        Typeface myFont = Typeface.createFromAsset(v.getContext().getAssets(),"fonts/TuoiTreTV.ttf");
////        tv.setTypeface(myFont);
//        tv.setText(/*tabTitles[position]*/"");
////        ImageView img = (ImageView) v.findViewById(R.id.img_title);
////        img.setImageResource(imageResId[position]);
//        return v;
//    }
//
//    public View getTabViewNoSelected(int position){
//        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab_no_selected, null);
//        TextView tv = v.findViewById(R.id.tv_title);
//        tv.setText(tabTitles[position]);
//        return v;
//    }


}
