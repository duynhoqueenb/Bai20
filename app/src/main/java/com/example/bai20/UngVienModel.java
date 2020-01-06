package com.example.bai20;

/**
 * Created by Tư Lầu on 1/4/20.
 */
public class UngVienModel {
    private String vitri;
    private String ten;
    private String gioitinh;
    private String tuoi;
    private String diadiem;
    private String kinhnghiem;
    public String getVitri() {
        return vitri;
    }

    public String getTen() {
        return ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getTuoi() {
        return tuoi;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public String getKinhnghiem() {
        return kinhnghiem;
    }




    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public void setKinhnghiem(String kinhnghiem) {
        this.kinhnghiem = kinhnghiem;
    }


    public UngVienModel(String vitri, String ten, String gioitinh, String tuoi, String diadiem, String kinhnghiem) {
        this.vitri = vitri;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.tuoi = tuoi;
        this.diadiem = diadiem;
        this.kinhnghiem = kinhnghiem;
    }


}
