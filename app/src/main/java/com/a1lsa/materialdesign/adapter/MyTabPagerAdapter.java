package com.a1lsa.materialdesign.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by mry on 2016/6/14.
 */
public class MyTabPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private String []mTabs={" 娱乐","财经","体育","军事"};

    public MyTabPagerAdapter(FragmentManager fm,List<Fragment> mFragments) {
        super(fm);
        this.mFragments=mFragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return mTabs[position];
    }
}
