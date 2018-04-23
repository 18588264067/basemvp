package com.aikaichuang.ui.adapter;

import android.view.View;

import com.aikaichuang.R;
import com.aikaichuang.model.entity.HomeGiftPacket;
import com.aikaichuang.model.entity.HomeRecommendProduct;
import com.aikaichuang.ui.holder.HomeGiftPacketItemHolder;
import com.aikaichuang.ui.holder.HomeProductItemHolder;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

/**
 * Created by Scene Tang on 2018/4/20.
 */
public class HomeProductAdapter extends DefaultAdapter<HomeRecommendProduct> {

    public HomeProductAdapter(List<HomeRecommendProduct> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<HomeRecommendProduct> getHolder(View v, int viewType) {
        return new HomeProductItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.ui_homepage_product_item;
    }
}
