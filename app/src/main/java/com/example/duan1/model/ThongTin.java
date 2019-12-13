package com.example.duan1.model;

public class ThongTin {
    private String MaHoaDon;
    private String Ngay;
    private String TenVatNuoi;
    private String DacDiem;
    private String CanNang;
    private String SoDienThoai;
    private String MaDichVu;
    private String GhiChu;

    public ThongTin() {
        MaHoaDon = "abc";
        Ngay = "abc";
        TenVatNuoi = "abc";
        DacDiem = "abc";
        CanNang = "abc";
        SoDienThoai = "abc";
        MaDichVu = "abc";
        GhiChu = "abc";
    }
    public ThongTin(String maHoaDon, String ngay, String tenVatNuoi, String dacDiem, String canNang, String soDienThoai, String maDichVu, String ghiChu) {
        MaHoaDon = maHoaDon;
        Ngay = ngay;
        TenVatNuoi = tenVatNuoi;
        DacDiem = dacDiem;
        CanNang = canNang;
        SoDienThoai = soDienThoai;
        MaDichVu = maDichVu;
        GhiChu = ghiChu;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getTenVatNuoi() {
        return TenVatNuoi;
    }

    public void setTenVatNuoi(String tenVatNuoi) {
        TenVatNuoi = tenVatNuoi;
    }

    public String getDacDiem() {
        return DacDiem;
    }

    public void setDacDiem(String dacDiem) {
        DacDiem = dacDiem;
    }

    public String getCanNang() {
        return CanNang;
    }

    public void setCanNang(String canNang) {
        CanNang = canNang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        MaDichVu = maDichVu;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
