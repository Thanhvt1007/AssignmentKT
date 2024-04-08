//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.HoaDonChiTiet;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietDAO extends SoftwareDAO<HoaDonChiTiet, Integer> {

    String INSERT_SQL = "INSERT INTO ChiTietHoaDon (MaHDCT, MaHD, MaSP, SoLuong, DonGia) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE ChiTietHoaDon SET MaSP = ?, SoLuong = ? WHERE MaHDCT = ? AND MaSP = ?";
    String DELETE_SQL = "DELETE FROM ChiTietHoaDon WHERE MaHD = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietHoaDon";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietHoaDon WHERE MaHDCT = ?";
    String FIND_MAHDCT_MAX = "SELECT * FROM ChiTietHoaDon ORDER BY MaHDCT ASC";
//    String SELECT_BY_KEYWORD = "SELECT * FROM ChiTietHoaDon WHERE MaHDCT = ?, ";

    @Override
    public void insert(HoaDonChiTiet entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaHDCT(),
                    entity.getMaHD(),
                    entity.getMaSP(),
                    entity.getSoLuong(),
                    entity.getDonGia());
        } catch (SQLException ex) {
            System.out.println("LổiHDCT"+ex);
        }
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMaSP(),
                    entity.getSoLuong(),
                    entity.getMaHDCT(),
                    entity.getMaSP());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(Integer ID) {
    }

    public void deletes(Integer maHD) {
        try {
            XJdbc.update(DELETE_SQL, maHD);
        } catch (SQLException ex) {
        }
    }

    @Override
    public HoaDonChiTiet SelectByID(Integer ID) {
        List<HoaDonChiTiet> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<HoaDonChiTiet> SelectBySQL(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHDCT(rs.getInt("MaHDCT"));
                hdct.setMaHD(rs.getInt("MaHD"));
                hdct.setMaSP(rs.getString("MaSP"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setDonGia(rs.getDouble("DonGia"));
                list.add(hdct);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDonChiTiet> FindIdMax() {
        return this.SelectBySQL(FIND_MAHDCT_MAX);
    }

    public List<HoaDonChiTiet> SelectByIDS(Integer ID) {
        List<HoaDonChiTiet> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public List<HoaDonChiTiet> SelectByMaHD(Integer ID) {
        String SQL = "select * from ChiTietHoaDon where MaHD = ?";
        List<HoaDonChiTiet> list = this.SelectBySQL(SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
