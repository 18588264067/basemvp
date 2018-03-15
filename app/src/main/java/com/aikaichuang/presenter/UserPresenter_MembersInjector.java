package com.aikaichuang.presenter;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import com.jess.arms.integration.AppManager;
import com.aikaichuang.model.entity.User;

import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserPresenter_MembersInjector implements MembersInjector<UserPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<AppManager> mAppManagerProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<List<User>> mUsersProvider;

  private final Provider<RecyclerView.Adapter> mAdapterProvider;

  public UserPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<List<User>> mUsersProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.mAppManagerProvider = mAppManagerProvider;
    this.mApplicationProvider = mApplicationProvider;
    this.mUsersProvider = mUsersProvider;
    this.mAdapterProvider = mAdapterProvider;
  }

  public static MembersInjector<UserPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<List<User>> mUsersProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    return new UserPresenter_MembersInjector(
        mErrorHandlerProvider,
        mAppManagerProvider,
        mApplicationProvider,
        mUsersProvider,
        mAdapterProvider);
  }

  @Override
  public void injectMembers(UserPresenter instance) {
    injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectMAppManager(instance, mAppManagerProvider.get());
    injectMApplication(instance, mApplicationProvider.get());
    injectMUsers(instance, mUsersProvider.get());
    injectMAdapter(instance, mAdapterProvider.get());
  }

  public static void injectMErrorHandler(UserPresenter instance, RxErrorHandler mErrorHandler) {
    instance.mErrorHandler = mErrorHandler;
  }

  public static void injectMAppManager(UserPresenter instance, AppManager mAppManager) {
    instance.mAppManager = mAppManager;
  }

  public static void injectMApplication(UserPresenter instance, Application mApplication) {
    instance.mApplication = mApplication;
  }

  public static void injectMUsers(UserPresenter instance, List<User> mUsers) {
    instance.mUsers = mUsers;
  }

  public static void injectMAdapter(UserPresenter instance, RecyclerView.Adapter mAdapter) {
    instance.mAdapter = mAdapter;
  }
}
