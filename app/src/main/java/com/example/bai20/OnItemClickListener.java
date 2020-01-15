package com.example.bai20;

/**
 * Created by Tư Lầu on 1/2/20.
 */
public interface OnItemClickListener {
    public void onItemClick(PageFragment1Model itemModel, int position);

    public void onUngVienClick(PageFragment1Model itemModel, int position);

    public void onNavItemClick(NavigationItemModel itemNavModel, int positon);
}
