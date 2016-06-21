package com.a1lsa.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class  BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initLayout());

        initView();
        initData();
        initEvent();

    }

    public abstract int initLayout();

    public abstract void initView();

    public abstract void initData();

    public abstract void initEvent();
}
