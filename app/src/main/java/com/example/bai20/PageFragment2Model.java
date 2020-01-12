package com.example.bai20;

/**
 * Created by Tư Lầu on 12/24/19.
 */
public class PageFragment2Model {
    private String title2, year;

    public String getTitle2() {
        return title2;
    }

    public String getYear() {
        return year;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public PageFragment2Model(String title2, String year) {
        this.title2 = title2;
        this.year = year;
    }
}
