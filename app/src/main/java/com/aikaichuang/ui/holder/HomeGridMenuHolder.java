package com.aikaichuang.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aikaichuang.R;
import com.aikaichuang.model.entity.HomeMenu;
import com.jess.arms.base.BaseHolder;

import butterknife.BindView;

/**
 * Created by Scene Tang on 2018/4/19.
 */

public class HomeGridMenuHolder extends BaseHolder<HomeMenu> {

    @BindView(R.id.item_name)
    TextView mName;
    @BindView(R.id.item_image)
    ImageView mAvatar;

    public HomeGridMenuHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(HomeMenu data, int position) {
        mName.setText(data.getName() + "");
        mAvatar.setImageResource(data.getUrl());
    }
}
