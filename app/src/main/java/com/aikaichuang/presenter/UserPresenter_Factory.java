package com.aikaichuang.presenter;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import com.jess.arms.integration.AppManager;
import com.aikaichuang.model.entity.User;

import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import com.aikaichuang.contract.UserContract;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserPresenter_Factory implements Factory<UserPresenter> {
  private final Provider<UserContract.Model> modelProvider;

  private final Provider<UserContract.View> rootViewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<AppManager> mAppManagerProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<List<User>> mUsersProvider;

  private final Provider<RecyclerView.Adapter> mAdapterProvider;

  public UserPresenter_Factory(
      Provider<UserContract.Model> modelProvider,
      Provider<UserContract.View> rootViewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<List<User>> mUsersProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    this.modelProvider = modelProvider;
    this.rootViewProvider = rootViewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.mAppManagerProvider = mAppManagerProvider;
    this.mApplicationProvider = mApplicationProvider;
    this.mUsersProvider = mUsersProvider;
    this.mAdapterProvider = mAdapterProvider;
  }

  @Override
  public UserPresenter get() {
    UserPresenter instance = new UserPresenter(modelProvider.get(), rootViewProvider.get());
    UserPresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    UserPresenter_MembersInjector.injectMAppManager(instance, mAppManagerProvider.get());
    UserPresenter_MembersInjector.injectMApplication(instance, mApplicationProvider.get());
    UserPresenter_MembersInjector.injectMUsers(instance, mUsersProvider.get());
    UserPresenter_MembersInjector.injectMAdapter(instance, mAdapterProvider.get());
    return instance;
  }

  public static UserPresenter_Factory create(
      Provider<UserContract.Model> modelProvider,
      Provider<UserContract.View> rootViewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<List<User>> mUsersProvider,
      Provider<RecyclerView.Adapter> mAdapterProvider) {
    return new UserPresenter_Factory(
        modelProvider,
        rootViewProvider,
        mErrorHandlerProvider,
        mAppManagerProvider,
        mApplicationProvider,
        mUsersProvider,
        mAdapterProvider);
  }

  public static UserPresenter newUserPresenter(
      UserContract.Model model, UserContract.View rootView) {
    return new UserPresenter(model, rootView);
  }
}
