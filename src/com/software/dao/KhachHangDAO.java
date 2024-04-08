//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.KhachHang;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends SoftwareDAO<KhachHang, Integer> {

    String INSERT_SQL = "INSERT INTO KhachHang (MaKH, TenKH, SoDT) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE KhachHang SET TenKH = ?, SoDT = ? WHERE MaKH = ?";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH = ?";
    String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    String SELECT_BY_ID_SQL = "SELECT * FROM KhachHang WHERE MaKH = ?";

    @Override
    public void insert(KhachHang entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaKhachHang(),
                    entity.getTenKhachHang(),
                    entity.getSoDT());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenKhachHang(),
                    entity.getSoDT(),
                    entity.getMaKhachHang());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(Integer ID) {
        try {
            XJdbc.update(DELETE_SQL, ID);
        } catch (SQLException ex) {
        }
    }

    @Override
    public KhachHang SelectByID(Integer ID) {
        List<KhachHang> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<KhachHang> SelectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        ResultSet resultSet;
        try {
            resultSet = XJdbc.query(sql, args);
            while (resultSet.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(resultSet.getInt("MaKH"));
                kh.setTenKhachHang(resultSet.getString("TenKH"));
                kh.setSoDT(resultSet.getString("SoDT"));
                list.add(kh);
            }
            resultSet.getStatement().getConnection().close();
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public List<KhachHang> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? OR SoDT = ?";
        return SelectBySQL(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
    public List<KhachHang> SelectByIDS(Integer ID) {
        List<KhachHang> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<KhachHang> selectByKhachHanngInHoaDon(Integer maKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ? and MaKH in (SELECT MaKH FROM HDBan)";
        return this.SelectBySQL(sql, maKH);
    }
}
