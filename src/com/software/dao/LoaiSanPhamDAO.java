//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.LoaiSanPham;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiSanPhamDAO extends SoftwareDAO<LoaiSanPham, String> {

    String INSERT_SQL = "INSERT INTO LoaiSP (MaLoai, TenLoai, MoTa) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE LoaiSP SET TenLoai = ?, MoTa = ? WHERE MaLoai = ?";
    String DELETE_SQL = "DELETE FROM LoaiSP WHERE MaLoai = ?";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiSP";
    String SELECT_BY_ID_SQL = "SELECT * FROM LoaiSP WHERE MaLoai = ?";

    @Override
    public void insert(LoaiSanPham entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaLoai(),
                    entity.getTenLoai(),
                    entity.getMoTa());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void update(LoaiSanPham entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenLoai(),
                    entity.getMoTa(),
                    entity.getMaLoai());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(String ID) {
        try {
            XJdbc.update(DELETE_SQL, ID);
        } catch (SQLException ex) {
        }
    }

    @Override
    public LoaiSanPham SelectByID(String ID) {
        List<LoaiSanPham> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiSanPham> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<LoaiSanPham> SelectBySQL(String sql, Object... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                LoaiSanPham loaiSP = new LoaiSanPham();
                loaiSP.setMaLoai(rs.getString("MaLoai"));
                loaiSP.setTenLoai(rs.getString("TenLoai"));
                loaiSP.setMoTa(rs.getString("MoTa"));
                list.add(loaiSP);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LoaiSanPham> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM LoaiSP WHERE MaLoai LIKE ? OR TenLoai LIKE ?";
        return SelectBySQL(sql, "%" + keyword + "%", "%" + keyword + "%");
    }

    public List<LoaiSanPham> selectByLoaiInSanPham(String maLSP) {
        String sql = "SELECT * FROM LoaiSP WHERE MaLoai = ? and MaLoai in (select Loai from SanPham)";
        return this.SelectBySQL(sql, maLSP);
    }
}
