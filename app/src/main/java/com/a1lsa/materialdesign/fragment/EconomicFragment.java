package com.a1lsa.materialdesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yyz.materialdesign.R;
import com.a1lsa.materialdesign.activity.CollapsingToolbarTestActivity;
import com.a1lsa.materialdesign.activity.CoordinatorTestActivity;

/**
 * 财经页面
 * Created by yyz on 2016/6/14.
 */
public class EconomicFragment extends Fragment {

    private ListView mLv;
    private String[] data={"A","B","C","D","E","F","G","H","I","J","K","M","N","L"};
    private ArrayAdapter<String> mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_economicfragment, container, false);


        initView(view);
        initEvent();
        return view;
    }



    private void initView(View view) {
        mLv = (ListView) view.findViewById(R.id.listview);
        mAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);

        mLv.setAdapter(mAdapter);
    }

    private void initEvent() {

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position%2==0){
                    Intent intent=new Intent(getActivity(),CoordinatorTestActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(getActivity(),CollapsingToolbarTestActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
