package com.aikaichuang.ui.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aikaichuang.R;
import com.aikaichuang.contract.HomeContract;
import com.aikaichuang.di.component.DaggerHomeComponent;
import com.aikaichuang.di.module.HomeModule;
import com.aikaichuang.presenter.HomePresenter;
import com.aikaichuang.ui.adapter.HomeGiftPacketAdapter;
import com.aikaichuang.ui.adapter.HomeProductAdapter;
import com.aikaichuang.util.permission.PermissionCallBack;
import com.aikaichuang.util.permission.PermissionChecker;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.convenientBanner)
    Banner banner;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @BindView(R.id.iv_top_bar_msg)
    View topMsg;

    @BindView(R.id.giftPacketRecyclerView)
    RecyclerView giftPacketRecyclerView;

    @BindView(R.id.productPacketRecyclerView)
    RecyclerView productPacketRecyclerView;

    @Inject
    ImageLoader imageLoader;

    @Inject
    RecyclerView.LayoutManager mLayoutManager;

    PermissionChecker permissionChecker;

    // 所需的全部权限
    public static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_NETWORK_STATE
    };

    @Override
    public void setupFragmentComponent
            (@NonNull AppComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, null);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        banner.setImageLoader(imageLoader);
        banner.setImages(mPresenter.getSlideShowDatas());
        banner.start();

        viewpager.setAdapter(mPresenter.getMyViewPagerAdapter());

        ArmsUtils.configRecyclerView(giftPacketRecyclerView, new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        giftPacketRecyclerView.setAdapter(new HomeGiftPacketAdapter(mPresenter.getGiftPacketData()));

        ArmsUtils.configRecyclerView(productPacketRecyclerView, new GridLayoutManager(getContext(), 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        productPacketRecyclerView.setAdapter(new HomeProductAdapter(mPresenter.getProducts()));
    }

    public Activity getFragmentActivity(){
        return getActivity();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void refreshPage() {

    }

    @Override
    public void scanCode() {

    }

    @Override
    public void message() {

    }

    @Override
    public void menuIntemOnclick() {

    }

    @Override
    public void menuOnclickMore() {

    }

    @Override
    public void recycleUtoOrder() {

    }

    @Override
    public void giftPackIntemClick() {

    }

    @Override
    public void giftPackMoreClick() {

    }

    @Override
    public void goodRecommendGiftIntemClick() {

    }

    @Override
    public void goodRecommendGiftMore() {

    }

    @Override
    public void slideShowIntemClick() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }


    @OnClick(R.id.iv_top_bar_msg)
    public void topBarMsg() {
        PermissionChecker checker = new PermissionChecker(getActivity());
        checker.checkPermissions(new PermissionCallBack() {
            @Override
            public void success() {
                showToast("ok");
            }

            @Override
            public void onCancel() {
                showToast("fail");
            }
        }, PERMISSIONS);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
