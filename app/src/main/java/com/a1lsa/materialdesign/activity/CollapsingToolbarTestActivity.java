package com.a1lsa.materialdesign.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.yyz.materialdesign.R;
import com.a1lsa.materialdesign.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarTestActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private Toolbar mToolBar;
    private ArrayAdapter<String> mAdapter;

    @Override
    public int initLayout() {
        return R.layout.activity_collapsing_toolbar_test;
    }

    public void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recycleView);
        mToolBar= (Toolbar) findViewById(R.id.toolbar);



    }

    public void initData() {

        mDatas=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDatas.add(""+ (i));
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(this,mDatas));
    }


    public void initEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
