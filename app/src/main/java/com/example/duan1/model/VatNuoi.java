package com.example.duan1.model;

public class VatNuoi {
    private String Mavatnuoi;
    private String Tenvatnuoi;
    private String Loai;
    private String Dacdiem;
    private String Cannang;
    private String Gia;

    public VatNuoi() {
        this.Mavatnuoi ="abc";
        this.Tenvatnuoi = "abc";
        this.Loai = "abc";
        this.Dacdiem = "abc";
        this.Cannang = "abc";
        this.Gia = "abc";
    }

    public VatNuoi(String mavatnuoi,String tenvatnuoi, String loai, String dacdiem, String cannang, String gia) {
        this.Mavatnuoi=mavatnuoi;
        this.Tenvatnuoi = tenvatnuoi;
        this.Loai = loai;
        this.Dacdiem = dacdiem;
        this.Cannang = cannang;
        this.Gia = gia;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getMavatnuoi() {
        return Mavatnuoi;
    }

    public void setMavatnuoi(String mavatnuoi) {
        Mavatnuoi = mavatnuoi;
    }

    public String getTenvatnuoi() {
        return Tenvatnuoi;
    }

    public void setTenvatnuoi(String tenvatnuoi) {
        Tenvatnuoi = tenvatnuoi;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getDacdiem() {
        return Dacdiem;
    }

    public void setDacdiem(String dacdiem) {
        Dacdiem = dacdiem;
    }

    public String getCannang() {
        return Cannang;
    }

    public void setCannang(String cannang) {
        Cannang = cannang;
    }
}

