package com.aikaichuang.di.module;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.aikaichuang.contract.HomeContract;
import com.aikaichuang.model.HomeModel;
import com.aikaichuang.model.entity.HomeSlideShow;
import com.jess.arms.di.scope.FragmentScope;
import com.youth.banner.loader.ImageLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Scene Tang on 2018/4/18.
 */


@Module
public class HomeModule {

    private HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomeContract.View provideHomeView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HomeContract.Model provideHomeModel(HomeModel model) {
        return model;
    }

    @FragmentScope
    @Provides
    public ImageLoader provideImageLoader(){
        return new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageResource(((HomeSlideShow) path).pic);
            }
        };
    }

    @FragmentScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getFragmentActivity(), 4);
    }

}
