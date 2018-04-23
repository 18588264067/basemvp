package com.aikaichuang.model.entity;

/**
 * Created by Scene Tang on 2018/4/17.
 */

public class HomeMenu {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public HomeMenu(String name, int url) {
        super();
        this.name = name;
        this.url = url;
    }
}