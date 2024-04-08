//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.entity;

public class DonViTinh {

    private String maDonVi;
    private String tenDonVi;
    private String moTa;

    public DonViTinh() {

    }

    public DonViTinh(String maDonVi, String tenDonVi, String moTa) {
        this.maDonVi = maDonVi;
        this.tenDonVi = tenDonVi;
        this.moTa = moTa;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
