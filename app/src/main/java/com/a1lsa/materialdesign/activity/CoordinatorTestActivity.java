package com.a1lsa.materialdesign.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.yyz.materialdesign.R;
import com.a1lsa.materialdesign.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * CoordinatorLayout
 * 1、给这个可滚动组件设置了layout_behavior
 * 2、给另一个控件设置了layout_scrollFlags
 *
 * 设置的layout_scrollFlags有如下几种选项：
 * scroll: 所有想滚动出屏幕的view都需要设置这个flag- 没有设置这个flag的view将被固定在屏幕顶部。
 * enterAlways: 这个flag让任意向下的滚动都会导致该view变为可见，启用快速“返回模式”。
 * enterAlwaysCollapsed: 当你的视图已经设置minHeight属性又使用此标志时，
 * 你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
 */
public class CoordinatorTestActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private Toolbar mToolbar;
   // private TabLayout mTabLayout;
    private RadioButton mBtnList,mBtnGrid,mBtnPubu;


    @Override
    public int initLayout() {
        return R.layout.activity_coordinatortest;
    }


    public void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        mToolbar.setTitle("al1sa");
       // mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mBtnGrid= (RadioButton) findViewById(R.id.btn_grid);
        mBtnList= (RadioButton) findViewById(R.id.btn_list);
        mBtnPubu= (RadioButton) findViewById(R.id.btn_pubu);

        mBtnList.performClick();//初始化设置为点击了mBtnNew，显示左边方式的布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initDataRecycler();
    }

    @Override
    public void initData() {

    }


    public void initDataRecycler() {

       // mTabLayout.addTab(mTabLayout.newTab().setText("最新"));
       // mTabLayout.addTab(mTabLayout.newTab().setText("最热"));
        mDatas=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i%2==0){
                mDatas.add("今天天气好晴朗------------>" + (1 + i));
            }
            else {
                mDatas.add("处处好风光------------>" + (1 + i));
            }

        }

        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(this,mDatas));
    }

    @Override
    public void initEvent() {
        mBtnGrid.setOnClickListener(this);
        mBtnList.setOnClickListener(this);
        mBtnPubu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_list:
                //这里用线性显示 类似于listview
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;

            case R.id.btn_grid:
                //这里用线性宫格显示 类似于grid view
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));                break;

            case R.id.btn_pubu:
                //这里用线性宫格显示 类似于瀑布流
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager
                        (2, OrientationHelper.VERTICAL));
                break;
        }

        initDataRecycler();
    }
}
