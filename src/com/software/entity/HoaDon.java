//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.entity;

public class HoaDon {

    private Integer maHD;
    private String maNV;
    private Integer maKH;
    private Integer phanTramGiam;
    private Double giaGiam;
    private String ngayLapHD;
    private String trangThai;
    private Double thanhTien;

    public HoaDon() {

    }

    public HoaDon(Integer maHD, String maNV, Integer maKH, Integer phanTramGiam, Double giaGiam, String ngayLapHD, String trangThai, Double thanhTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.phanTramGiam = phanTramGiam;
        this.giaGiam = giaGiam;
        this.ngayLapHD = ngayLapHD;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Integer phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public Double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Double giaGiam) {
        this.giaGiam = giaGiam;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
