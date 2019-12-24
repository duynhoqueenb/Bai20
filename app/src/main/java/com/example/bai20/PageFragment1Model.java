package com.example.bai20;

/**
 * Created by Tư Lầu on 12/23/19.
 */
public class PageFragment1Model {
    private String title,vitri, luong, soluong, thoihan, view, ungvien;

    public PageFragment1Model(String title, String vitri, String luong, String soluong, String thoihan, String view, String ungvien) {
        this.title = title;
        this.vitri = vitri;
        this.luong = luong;
        this.soluong = soluong;
        this.thoihan = thoihan;
        this.view = view;
        this.ungvien = ungvien;
    }

    public String getTitle() {
        return title;
    }

    public String getVitri() {
        return vitri;
    }

    public String getLuong() {
        return luong;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public void setThoihan(String thoihan) {
        this.thoihan = thoihan;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setUngvien(String ungvien) {
        this.ungvien = ungvien;
    }

    public String getThoihan() {
        return thoihan;
    }

    public String getView() {
        return view;
    }

    public String getUngvien() {
        return ungvien;
    }


}


