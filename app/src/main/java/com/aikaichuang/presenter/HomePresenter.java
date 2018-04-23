package com.aikaichuang.presenter;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aikaichuang.R;
import com.aikaichuang.contract.HomeContract;
import com.aikaichuang.model.entity.HomeGiftPacket;
import com.aikaichuang.model.entity.HomeRecommendProduct;
import com.aikaichuang.model.entity.HomeSlideShow;
import com.aikaichuang.ui.adapter.HomePageMenuGridAdapter;
import com.aikaichuang.ui.adapter.HomeMyViewPagerAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Scene Tang on 2018/4/17.
 */

@FragmentScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View>{

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View view){
        super(model, view);
    }

    public List<HomeSlideShow> getSlideShowDatas(){
        return  new ArrayList<HomeSlideShow>(){{
            add(new HomeSlideShow("最后的骑士", R.mipmap.image_movie_header_48621499931969370));
            add(new HomeSlideShow("三生三世十里桃花", R.mipmap.image_movie_header_12981501221820220));
            add(new HomeSlideShow("豆福传", R.mipmap.image_movie_header_12231501221682438));
        }};
    }

    public HomeMyViewPagerAdapter getMyViewPagerAdapter() {
        //总的页数向上取整
        int mPageSize = 8;
        int totalPage = (int) Math.ceil(mModel.getMenus().size() * 1.0 / mPageSize);
        List<View> viewPagerList = new ArrayList<View>();
        for(int i = 0; i < totalPage; i++){
            //每个页面都是inflate出一个新实例
            RecyclerView gridView = (RecyclerView) View.inflate(this.mRootView.getFragmentActivity(), R.layout.ui_homepage_menue_recycleview, null);
            gridView.setAdapter(new HomePageMenuGridAdapter(mModel.getMenus(), i, mPageSize));
            ArmsUtils.configRecyclerView(gridView, new GridLayoutManager(mRootView.getFragmentActivity(), 4) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        return new HomeMyViewPagerAdapter(viewPagerList);
    }

    public List<HomeGiftPacket> getGiftPacketData() {
        return mModel.getGiftPacks();
    }

    public List<HomeRecommendProduct> getProducts() {
        return mModel.getProducts();
    }

}
