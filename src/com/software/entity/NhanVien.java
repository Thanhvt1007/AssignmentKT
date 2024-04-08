//* Coder: BUI TRONG NHAN
//* Date of writing code: 29/11/2021
//* MSSV: PC01721
//* Class: IT16301
package com.software.entity;

public class NhanVien {

    String maNV;
    String tenNV;
    String soDienThoai;
    String diaChi;
    String cmnd;
    boolean gioiTinh;
    String maChucVu;
    String gmail;
    String path;

    public NhanVien() {

    }

    public NhanVien(String maNV, String tenNV, String soDienThoai, String diaChi, String cmnd, boolean gioiTinh, String maChucVu, String gmail, String path) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.cmnd = cmnd;
        this.gioiTinh = gioiTinh;
        this.maChucVu = maChucVu;
        this.gmail = gmail;
        this.path = path;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
