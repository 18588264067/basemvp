package com.aikaichuang.ui.adapter;

import android.view.View;

import com.aikaichuang.R;
import com.aikaichuang.model.entity.HomeMenu;
import com.aikaichuang.ui.holder.HomeGridMenuHolder;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

/**
 * Created by Scene Tang on 2018/4/19.
 */

public class HomePageMenuGridAdapter extends DefaultAdapter<HomeMenu>{

    private int mIndex; // 页数下标，标示第几页，从0开始
    private int mPargerSize;// 每页显示的最大的数量


    public HomePageMenuGridAdapter(List<HomeMenu> menus, int i, int mPageSize) {
        super(menus);
        this.mIndex = i;
        this.mPargerSize = mPageSize;
    }

    @Override
    public BaseHolder<HomeMenu> getHolder(View v, int viewType) {
        return new HomeGridMenuHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.ui_homepage_menue_item;
    }


    @Override
    public int getItemCount() {
        return mInfos.size() > (mIndex + 1) * mPargerSize ?
                mPargerSize : (mInfos.size() - mIndex*mPargerSize);
    }

    @Override
    public long getItemId(int position) {
        return position + mIndex * mPargerSize;
    }

    @Override
    public HomeMenu getItem(int position) {
        return mInfos.get(position + mIndex * mPargerSize);
    }


    @Override
    public void onBindViewHolder(BaseHolder<HomeMenu> holder, int position) {
        holder.setData(getItem(position), position);
    }
}
