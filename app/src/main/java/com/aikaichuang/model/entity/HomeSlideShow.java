package com.aikaichuang.model.entity;

import java.io.Serializable;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public class HomeSlideShow implements Serializable{
    public int pic;
    public String title;

    public HomeSlideShow() {
    }

    public HomeSlideShow(String title, int pic) {
        this.pic = pic;
        this.title = title;
    }
}
