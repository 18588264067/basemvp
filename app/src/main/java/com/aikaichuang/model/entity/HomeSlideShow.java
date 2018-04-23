package com.aikaichuang.model.entity;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public class HomeSlideShow {
    public int pic;
    public String title;

    public HomeSlideShow() {
    }

    public HomeSlideShow(String title, int pic) {
        this.pic = pic;
        this.title = title;
    }
}
