package com.aikaichuang.contract;

import android.app.Activity;

import com.aikaichuang.model.entity.HomeGiftPacket;
import com.aikaichuang.model.entity.HomeMenu;
import com.aikaichuang.model.entity.HomeRecommendProduct;
import com.aikaichuang.model.entity.HomeSlideShow;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public interface HomeContract {

    interface View extends IView {

        void refreshPage();

        void scanCode();

        void message();

        void menuIntemOnclick();

        void menuOnclickMore();

        void recycleUtoOrder();

         void giftPackIntemClick();

         void giftPackMoreClick();

         void goodRecommendGiftIntemClick();

         void goodRecommendGiftMore();

         void slideShowIntemClick();

         Activity getFragmentActivity();

    }

    interface Model extends IModel {

        Observable<List<HomeSlideShow>> getSlideShowDatas();

        List<HomeMenu> getMenus();

        List<HomeGiftPacket> getGiftPacks();

        List<HomeRecommendProduct> getProducts();

    }
}
