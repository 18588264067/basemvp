package com.aikaichuang.model;

import com.jess.arms.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserModel_Factory implements Factory<UserModel> {
  private final Provider<IRepositoryManager> repositoryManagerProvider;

  public UserModel_Factory(Provider<IRepositoryManager> repositoryManagerProvider) {
    this.repositoryManagerProvider = repositoryManagerProvider;
  }

  @Override
  public UserModel get() {
    return new UserModel(repositoryManagerProvider.get());
  }

  public static UserModel_Factory create(Provider<IRepositoryManager> repositoryManagerProvider) {
    return new UserModel_Factory(repositoryManagerProvider);
  }
}
