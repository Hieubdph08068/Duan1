package com.example.duan1.model;

public class DichVu {
    private String MaDichVu;
    private String TenDichVu;
    private String MoTa;
    private String Gia;

    public DichVu() {
        this.MaDichVu = "DV1";
        this.TenDichVu = "abc";
        this.MoTa = "abc";
        this.Gia = "abc";
    }

    public DichVu(String maDichVu, String tenDichVu, String moTa, String gia) {
        this.MaDichVu = maDichVu;
        this.TenDichVu = tenDichVu;
        this.MoTa = moTa;
        this.Gia = gia;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        MaDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        TenDichVu = tenDichVu;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String toString(){
        return this.getTenDichVu();
    }
}
