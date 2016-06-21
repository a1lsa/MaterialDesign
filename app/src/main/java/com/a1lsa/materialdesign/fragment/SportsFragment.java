package com.a1lsa.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yyz.materialdesign.R;

/**
 * 娱乐页面
 * Created by yyz on 2016/6/14.
 */
public class SportsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_sportsfragment, container, false);
        return view;
    }
}
