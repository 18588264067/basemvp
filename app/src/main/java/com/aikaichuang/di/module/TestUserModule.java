/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aikaichuang.di.module;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aikaichuang.contract.TestUserContract;
import com.aikaichuang.model.entity.TestUser;
import com.jess.arms.di.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

import com.aikaichuang.model.TestUserModel;
import com.aikaichuang.ui.adapter.TestUserAdapter;

/**
 * ================================================
 * 展示 Module 的用法
 *
 * @see <a href="https://github.com/JessYanCoding/MVPArms/wiki#2.4.5">Module wiki 官方文档</a>
 * Created by JessYan on 09/04/2016 11:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@Module
public class TestUserModule {
    private TestUserContract.View view;

    /**
     * 构建 TestUserModule 时,将 View 的实现类传进来,这样就可以提供 View 的实现类给 Presenter
     *
     * @param view
     */
    public TestUserModule(TestUserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TestUserContract.View provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TestUserContract.Model provideUserModel(TestUserModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    RxPermissions provideRxPermissions() {
        return new RxPermissions(view.getActivity());
    }

    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(view.getActivity(), 2);
    }

    @ActivityScope
    @Provides
    List<TestUser> provideUserList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    RecyclerView.Adapter provideUserAdapter(List<TestUser> list){
        return new TestUserAdapter(list);
    }
}
