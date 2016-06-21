package com.a1lsa.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyz.materialdesign.R;

import java.util.List;

/**
 * Created by yyz on 2016/5/27.
 * <p/>
 * 只管回收与复用View，其他的自己去设置
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String> mTitles;
    private int IMAGEITEM=0, TEXTITEM=1;


    public MyRecyclerViewAdapter(Context context, List<String> titles) {
        mContext = context;
        mTitles = titles;
        mLayoutInflater = LayoutInflater.from(context);

    }

    /**
     * 在该方法中，创建一个viewHolder并返回。
     * viewHolder必须有一个带有View的构造函数，这个View就是Item的根布局。
     *
     * @param parent
     * @param viewType
     * @return viewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TEXTITEM) {
            return new TextViewHolder(mLayoutInflater.inflate(R.layout.item_recycle_list_text, parent, false));
        } else if (viewType==IMAGEITEM){
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_recycle_list_image, parent, false));
        }
         return null;
       // return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_recycle_list_image, parent, false));

    }


    /**
     * 数据与界面进行绑定
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).mTextView.setText(mTitles.get( position));
        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).mTextView.setText(mTitles.get( position));
            ((ImageViewHolder) holder).mImageView.setImageResource(R.mipmap.fishboy);
        }
    }

    /**
     * 获取数据的数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.size();
    }

    /**
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
      /*  if (position%2==0){
            return TEXTITEM;
        }else {
            return IMAGEITEM;
        }*/
       return position % 2 == 0 ? TEXTITEM : IMAGEITEM;
       // return position;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_pic);
        }
    }
}