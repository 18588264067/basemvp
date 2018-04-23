package com.aikaichuang.di.component;

import com.aikaichuang.di.module.HomeModule;
import com.aikaichuang.ui.fragment.HomeFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Scene Tang on 2018/4/18.
 */

@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
}
