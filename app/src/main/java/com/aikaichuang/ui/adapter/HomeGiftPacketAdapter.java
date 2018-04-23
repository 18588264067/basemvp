package com.aikaichuang.ui.adapter;

import android.view.View;

import com.aikaichuang.R;
import com.aikaichuang.model.entity.HomeGiftPacket;
import com.aikaichuang.ui.holder.HomeGiftPacketItemHolder;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

/**
 * Created by Scene Tang on 2018/4/20.
 */
public class HomeGiftPacketAdapter extends DefaultAdapter<HomeGiftPacket> {

    public HomeGiftPacketAdapter(List<HomeGiftPacket> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<HomeGiftPacket> getHolder(View v, int viewType) {
        return new HomeGiftPacketItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.ui_homepage_giftpacket_item;
    }
}
