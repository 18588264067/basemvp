package com.aikaichuang.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.aikaichuang.R;
import com.aikaichuang.ui.fragment.HomeFragment;
import com.aikaichuang.ui.widget.tabview.TabView;
import com.aikaichuang.ui.widget.tabview.TabViewChild;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabView)
    TabView tabView;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        tabView= (TabView) findViewById(R.id.tabView);
        //start add data
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.ico_home_home_selected_icon, R.drawable.ico_home_home_normal_icon,"首页",  new HomeFragment());
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.ico_home_order_selected_icon, R.drawable.ico_home_order_normal_icon,"订单",  TestFragmentCommon.newInstance("分类"));
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.ico_home_lijikaika, R.drawable.ico_home_lijikaika,"立即下单",  null);
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.ico_baobiao, R.drawable.ico_baobiao,"报表",TestFragmentCommon.newInstance("报表"));
        TabViewChild tabViewChild05 = new TabViewChild(R.drawable.ico_home_my_selected_icon, R.drawable.ico_home_my_normal_icon,"我的",  TestFragmentCommon.newInstance("我的"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild05);
        //end add data
        //start custom style

        tabView.setTextViewSelectedColor(Color.parseColor("#0071f4"));
        tabView.setTextViewUnSelectedColor(Color.parseColor("#999999"));
        tabView.setTabViewBackgroundColor(Color.parseColor("#dddddd"));
        tabView.setTabViewHeight(ArmsUtils.dip2px(this, 52));
        tabView.setTabViewGravity(Gravity.TOP);
        tabView.setTabViewDefaultPosition(0);
        //end of custom
        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int  position, ImageView currentImageIcon, TextView currentTextView) {
                // Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
