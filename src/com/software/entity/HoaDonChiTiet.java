//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.entity;

public class HoaDonChiTiet {

    private Integer maHD;
    private Integer maHDCT;
    private String maSP;
    private Integer soLuong;
    private Double donGia;

    public HoaDonChiTiet() {

    }

    public HoaDonChiTiet(Integer maHD, Integer maHDCT, String maSP, Integer soLuong, Double donGia) {
        this.maHD = maHD;
        this.maHDCT = maHDCT;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(Integer maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

}
