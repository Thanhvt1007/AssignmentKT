//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.SanPham;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO extends SoftwareDAO<SanPham, String> {

    String INSERT_SQL = "INSERT INTO SanPham (MaSP, TenSP, DonViTinh,SoLuong, Gia, TrangThai, Loai) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE SanPham SET TenSP = ?, DonViTinh = ?,SoLuong = ?, Gia = ?, TrangThai = ?, Loai = ? WHERE MaSP = ?";
    String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP = ?";
    String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP = ?";
    String SELECT_SP_DANGKINHDOANH = "SELECT * FROM SanPham WHERE TrangThai = N'Đang Kinh Doanh'";

    @Override
    public void insert(SanPham entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaSanPham(),
                    entity.getTenSanPham(),
                    entity.getDonViTinh(),
                    entity.getSoLuong(),
                    entity.getGia(),
                    entity.getTrangThai(),
                    entity.getLoaiSanPham());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void update(SanPham entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenSanPham(),
                    entity.getDonViTinh(),
                    entity.getSoLuong(),
                    entity.getGia(),
                    entity.getTrangThai(),
                    entity.getLoaiSanPham(),
                    entity.getMaSanPham());
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
    public SanPham SelectByID(String ID) {
        List<SanPham> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<SanPham> SelectBySQL(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getString("MaSP"));
                sanPham.setTenSanPham(rs.getString("TenSP"));
                sanPham.setDonViTinh(rs.getString("DonViTinh"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setGia(rs.getDouble("Gia"));
                sanPham.setTrangThai(rs.getString("TrangThai"));
                sanPham.setLoaiSanPham(rs.getString("Loai"));
                list.add(sanPham);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SanPham> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE TenSP LIKE ? OR MaSP LIKE ?";
        return SelectBySQL(sql, "%" + keyword + "%", "%" + keyword + "%");
    }

    public List<SanPham> SelectByIDS(String ID) {
        List<SanPham> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    } 
    
    public List<SanPham> SelectSanPhamDangKinhDoanh() {
        return this.SelectBySQL(SELECT_SP_DANGKINHDOANH);
    }
    public List<SanPham> selectBySanPhamInHoaDon(String maSP) {
        String sql = "SELECT * FROM SanPham WHERE MaSP = ? and MaSP in (select MaSP from ChiTietHoaDon)";
        return this.SelectBySQL(sql, maSP);
    }
}
