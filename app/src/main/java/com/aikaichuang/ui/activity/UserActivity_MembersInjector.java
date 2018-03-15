package com.aikaichuang.ui.activity;

import android.support.v7.widget.RecyclerView;
import com.jess.arms.base.BaseActivity_MembersInjector;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import com.aikaichuang.presenter.UserPresenter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserActivity_MembersInjector implements MembersInjector<UserActivity> {
  private final Provider<UserPresenter> mPresenterProvider;

  private final Provider<RxPermissions> mRxPermissionsProvider;

  private final Provider<RecyclerView.LayoutManager> mLayoutManagerProvider;

  private final Provider<RecyclerView.Adapter> mAdapterProvider;

  public UserActivity_MembersInjector(
      Provider<UserPresenter> mPresenterProvider,
      Provider<RxPermissions> mRxPermissionsProvider,
      Provider<RecyclerView.LayoutManager> mLayoutManagerProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.mRxPermissionsProvider = mRxPermissionsProvider;
    this.mLayoutManagerProvider = mLayoutManagerProvider;
    this.mAdapterProvider = mAdapterProvider;
  }

  public static MembersInjector<UserActivity> create(
      Provider<UserPresenter> mPresenterProvider,
      Provider<RxPermissions> mRxPermissionsProvider,
      Provider<RecyclerView.LayoutManager> mLayoutManagerProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    return new UserActivity_MembersInjector(
        mPresenterProvider, mRxPermissionsProvider, mLayoutManagerProvider, mAdapterProvider);
  }

  @Override
  public void injectMembers(UserActivity instance) {
    BaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectMRxPermissions(instance, mRxPermissionsProvider.get());
    injectMLayoutManager(instance, mLayoutManagerProvider.get());
    injectMAdapter(instance, mAdapterProvider.get());
  }

  public static void injectMRxPermissions(UserActivity instance, RxPermissions mRxPermissions) {
    instance.mRxPermissions = mRxPermissions;
  }

  public static void injectMLayoutManager(
      UserActivity instance, RecyclerView.LayoutManager mLayoutManager) {
    instance.mLayoutManager = mLayoutManager;
  }

  public static void injectMAdapter(UserActivity instance, RecyclerView.Adapter mAdapter) {
    instance.mAdapter = mAdapter;
  }
}
