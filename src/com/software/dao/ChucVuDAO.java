//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 29/11/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.dao;

import com.software.entity.ChucVu;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChucVuDAO extends SoftwareDAO<ChucVu, String> {

    String INSERT_SQL = "INSERT INTO ChucVu (MaChucVu, TenChucVu, MoTa) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE ChucVu SET TenChucVu = ?, MoTa = ? WHERE MaChucVu = ?";
    String DELETE_SQL = "DELETE FROM ChucVu WHERE MaChucVu = ?";
    String SELECT_ALL_SQL = "SELECT * FROM ChucVu ";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChucVu WHERE MaChucVu = ?";

    @Override
    public void insert(ChucVu entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaChucVu(),
                    entity.getTenChucVu(),
                    entity.getMoTa());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void update(ChucVu entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenChucVu(),
                    entity.getMoTa(),
                    entity.getMaChucVu());
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
    public ChucVu SelectByID(String ID) {
        List<ChucVu> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChucVu> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<ChucVu> SelectBySQL(String sql, Object... args) {
        List<ChucVu> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setMaChucVu(rs.getString(1));
                cv.setTenChucVu(rs.getString(2));
                cv.setMoTa(rs.getString(3));
                list.add(cv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
