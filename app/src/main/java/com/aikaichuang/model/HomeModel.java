package com.aikaichuang.model;

import com.aikaichuang.R;
import com.aikaichuang.contract.HomeContract;
import com.aikaichuang.model.entity.HomeGiftPacket;
import com.aikaichuang.model.entity.HomeMenu;
import com.aikaichuang.model.entity.HomeRecommendProduct;
import com.aikaichuang.model.entity.HomeSlideShow;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Scene Tang on 2018/4/17.
 */

@FragmentScope
public class HomeModel extends BaseModel implements HomeContract.Model {

    List<HomeMenu> listDatas;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<HomeSlideShow>> getSlideShowDatas() {
        return null;
    }

    @Override
    public List<HomeMenu> getMenus() {
        if (listDatas != null) {
            return listDatas;
        }

        String[] proName = {"名称0","名称1","名称2","名称3","名称4","名称5",
                "名称6","名称7","名称8","名称9","名称10","名称11","名称12","名称13",
                "名称14","名称15","名称16","名称17","名称18","名称19"};
        listDatas = new ArrayList<>();
        for(int i =0 ; i < proName.length; i++){
            listDatas.add(new HomeMenu(proName[i], R.drawable.ico_card));
        }
        return listDatas;
    }

    @Override
    public List<HomeGiftPacket> getGiftPacks() {
        List<HomeGiftPacket> list = new ArrayList<>();
        for (int i=0; i<4; i++) {
            list.add(new HomeGiftPacket());
        }
        return list;
    }

    @Override
    public List<HomeRecommendProduct> getProducts() {
        List<HomeRecommendProduct> list = new ArrayList<>();
        for (int i=0; i<4; i++) {
            list.add(new HomeRecommendProduct());
        }
        return list;
    }
}
