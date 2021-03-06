package com.quannm18.quanlykho.Model;

import com.google.gson.annotations.SerializedName;

public class HoaDonNhap {

    @SerializedName("MaHoaDonNhap")
    private String MaHoaDonNhap;
    @SerializedName("LoaiSP")
    private String LoaiSP;
//    @SerializedName("Hang")
//    private String Hang;
//    @SerializedName("Cot")
//    private String Cot;
    @SerializedName("ViTri")
    private String ViTri;
    @SerializedName("TenSP")
    private String TenSP;
    @SerializedName("DonGia")
    private int DonGia;
    @SerializedName("SoLuong")
    private int SoLuong;
    @SerializedName("NgayNhap")
    private String NgayNhap;
    @SerializedName("moTa")
    private String moTa;
    @SerializedName("_id")
    private String id;
    public HoaDonNhap() {
    }

    public HoaDonNhap(String maHoaDonNhap, String loaiSP, String viTri, String tenSP, int soLuong, String ngayNhap, int donGia, String moTa, String id) {
        MaHoaDonNhap = maHoaDonNhap;
        LoaiSP = loaiSP;
//        Hang = hang;
//        Cot = cot;
        ViTri = viTri;
        TenSP = tenSP;
        SoLuong = soLuong;
        NgayNhap = ngayNhap;
        DonGia = donGia;
        this.moTa = moTa;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHoaDonNhap() {
        return MaHoaDonNhap;
    }

    public void setMaHoaDonNhap(String maHoaDonNhap) {
        MaHoaDonNhap = maHoaDonNhap;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        LoaiSP = loaiSP;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String viTri) {
        ViTri = viTri;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        NgayNhap = ngayNhap;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
