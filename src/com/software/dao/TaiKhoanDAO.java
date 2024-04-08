//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.TaiKhoan;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends SoftwareDAO<TaiKhoan, String> {

    String INSERT_SQL = "INSERT INTO TaiKhoan (SoDienThoai, Pass) VALUES (?, ?)";
    String UPDATE_SQL = "UPDATE TaiKhoan SET Pass = ? WHERE SoDienThoai = ?";
    String DELETE_SQL = "DELETE FROM TaiKhoan WHERE SoDienThoai = ?";
    String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    String SELECT_BY_ID_SQL = "SELECT * FROM TaiKhoan WHERE SoDienThoai = ?";

    public TaiKhoan checkLogin(String user, String password) {
        String SELECT_BY_USERNAME_PASSWORD_SQL = "SELECT * FROM TaiKhoan WHERE SoDienThoai = ? AND Pass = ?";
        List<TaiKhoan> list = this.SelectBySQL(SELECT_BY_USERNAME_PASSWORD_SQL, user, password);
        if (list.isEmpty()) {
            return null; // Không tìm thấy tài khoản
        } else {
            return list.get(0); // Trả về thông tin tài khoản nếu tìm thấy
        }
    }

    @Override
    public void insert(TaiKhoan entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getSoDienThoai(),
                    entity.getMatKhau());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(TaiKhoan entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMatKhau(),
                    entity.getSoDienThoai());
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
    public TaiKhoan SelectByID(String ID) {
        List<TaiKhoan> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<TaiKhoan> SelectBySQL(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setSoDienThoai(rs.getString("SoDienThoai"));
                taiKhoan.setMatKhau(rs.getString("Pass"));
                list.add(taiKhoan);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePass(String pass, String soDienThoai) {
        try {
            XJdbc.update(UPDATE_SQL, pass, soDienThoai);
        } catch (SQLException ex) {
        }
    }
}
