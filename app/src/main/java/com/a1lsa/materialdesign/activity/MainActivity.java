package com.a1lsa.materialdesign.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.yyz.materialdesign.R;
import com.a1lsa.materialdesign.adapter.MyTabPagerAdapter;
import com.a1lsa.materialdesign.fragment.EconomicFragment;
import com.a1lsa.materialdesign.fragment.EntertainmentFragment;
import com.a1lsa.materialdesign.fragment.MilitaryFragment;
import com.a1lsa.materialdesign.fragment.SportsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.Snackbar提供了一个介于Toast和AlertDialog之间轻量级控件，它可以很方便的提供消息的提示和动作反馈。
 * 2.TextInputLayout,将EditText封装起来,提示信息会变成一个显示在EditText之上的floating label，
 * 这样用户就始终知道他们现在输入的是什么。同时,给EditText增加监听,可以给它增加更多的floating label
 * 3.floating action button 是一个负责显示界面基本操作的圆形按钮(默认颜色为主题中colorAccent)
 * 4.NavigationView配合DrawerLayout侧滑使用，最重要的两个属性：
 * app:headerLayout 侧滑栏的头布局文件
 * app:menu  下面展示的菜单栏
 * setNavigationItemSelectedListener()可以获得元素被选中的回调事件。它为你提供被点击的菜单元素 ，
 * 让你可以处理选择事件，改变复选框状态，加载新内容，关闭导航菜单，以及其他任何你想做的操作
 */
public class MainActivity extends BaseActivity {

    private TextView tv,tvSnack;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String []mTabs={" 娱乐","财经","体育","军事"};
    private MyTabPagerAdapter mPagerAdapter;
    private List<Fragment> fragments;



    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }


    public void initView() {
       //  tv= (TextView) findViewById(R.id.tv);
       //  tvSnack= (TextView) findViewById(R.id.snackbar);
         mTabLayout= (TabLayout) findViewById(R.id.tabLayout);
         mViewPager=(ViewPager) findViewById(R.id.viewPager);

    }

    public void initData() {

        for (int i = 0; i < mTabs.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTabs[i]));
        }
        setUpViewPager();//设置viewpager的数据
        mTabLayout.setupWithViewPager(mViewPager);


    }
    private void setUpViewPager() {
        fragments=new ArrayList<Fragment>();
       /* for (int i = 0; i < mTabs.length; i++) {
            fragments.add(new PageFragment().newInstance(i+1));
        }*/
        fragments.add(new EntertainmentFragment());
        fragments.add(new EconomicFragment());
        fragments.add(new SportsFragment());
        fragments.add(new MilitaryFragment());
        mPagerAdapter=new MyTabPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mPagerAdapter);
    }


    public void initEvent() {
       /* tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(tvSnack,//第一个参数作为Snackbar显示的基准元素（显示在哪个容器里）
                        "SnackBar is showing",Snackbar.LENGTH_LONG)
                        //而设置的Action也可以设置多个。
                        .setAction("setTv", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });*/

    }

}
