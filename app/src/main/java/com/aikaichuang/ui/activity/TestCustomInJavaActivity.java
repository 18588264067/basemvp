package com.aikaichuang.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;


import com.aikaichuang.R;
import com.aikaichuang.ui.widget.tabview.TabView;
import com.aikaichuang.ui.widget.tabview.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class TestCustomInJavaActivity extends FragmentActivity {
    TabView tabView;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_quick_start_activity);

        tabView= (TabView) findViewById(R.id.tabView);
        //start add data
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.drawable.ic_prompt_close,R.drawable.ic_prompt_close,"首页",  TestFragmentCommon.newInstance("首页"));
        TabViewChild tabViewChild02=new TabViewChild(R.drawable.ic_prompt_close,R.drawable.ic_prompt_close,"分类",  TestFragmentCommon.newInstance("分类"));
        TabViewChild tabViewChild03=new TabViewChild(R.drawable.ic_prompt_close,R.drawable.ic_prompt_close,"资讯",  TestFragmentCommon.newInstance("资讯"));
        TabViewChild tabViewChild04=new TabViewChild(R.drawable.ic_prompt_close,R.drawable.ic_prompt_close,"购物车",TestFragmentCommon.newInstance("购物车"));
        TabViewChild tabViewChild05=new TabViewChild(R.drawable.ic_prompt_close,R.drawable.ic_prompt_close,"我的",  TestFragmentCommon.newInstance("我的"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild05);
        //end add data
        //start custom style
        tabView.setTextViewSelectedColor(Color.BLUE);
        tabView.setTextViewUnSelectedColor(Color.BLACK);
        tabView.setTabViewBackgroundColor(Color.YELLOW);
        tabView.setTabViewHeight(dip2px(52));
        tabView.setImageViewTextViewMargin(2);
        tabView.setTextViewSize(14);
        tabView.setImageViewWidth(dip2px(30));
        tabView.setImageViewHeight(dip2px(30));
        tabView.setTabViewGravity(Gravity.TOP);
        tabView.setTabViewDefaultPosition(2);
        //end of custom
        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int  position, ImageView currentImageIcon, TextView currentTextView) {
                // Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  int dip2px(float dpValue)
    {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
