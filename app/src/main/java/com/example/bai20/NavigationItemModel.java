package com.example.bai20;

public class NavigationItemModel {
    private String icon;
    private String title;
    private int id;

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public NavigationItemModel(String icon, String title, int id) {
        this.icon = icon;
        this.title = title;
        this.id = id;
    }
}


