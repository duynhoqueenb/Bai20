package com.example.bai20;

/**
 * Created by Tư Lầu on 1/2/20.
 */
public interface OnItemClickListener {
    void onItemClick(PageFragment1Model itemModel, int position);

    void onUngVienClick(PageFragment1Model itemModel, int position);

    void onNavItemClick(NavigationItemModel itemNavModel, int positon);
}
