//* Coder: BUI TRONG NHAN
//* Date of writing code: 29/11/2021
//* MSSV: PC01721
//* Class: IT16301
package com.software.dao;

import com.software.entity.NhanVien;
import com.software.jdbcHelper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends SoftwareDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NHANVIEN(MaNV, TenNV, SoDienThoai, DiaChi, CMND, GioiTinh, MaChucVu, Gmail, PathAnh) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NHANVIEN SET  TenNV = ?, SoDienThoai = ?, DiaChi = ?, CMND = ?, GioiTinh = ?, MaChucVu = ?, Gmail = ?, PathAnh = ? WHERE MANV =?";
    String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MANV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MANV = ?";
    String SELECT_BY_SDT_SQL = "SELECT * FROM NHANVIEN WHERE SoDienThoai = ?";

    @Override
    public void insert(NhanVien entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaNV(),
                    entity.getTenNV(),
                    entity.getSoDienThoai(),
                    entity.getDiaChi(),
                    entity.getCmnd(),
                    entity.isGioiTinh(),
                    entity.getMaChucVu(),
                    entity.getGmail(),
                    entity.getPath());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenNV(),
                    entity.getSoDienThoai(),
                    entity.getDiaChi(),
                    entity.getCmnd(),
                    entity.isGioiTinh(),
                    entity.getMaChucVu(),
                    entity.getGmail(),
                    entity.getPath(),
                    entity.getMaNV());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<NhanVien> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM NHANVIEN WHERE HOTEN LIKE ?";
        return SelectBySQL(sql, "%" + keyword + "%");
    }

    @Override
    public NhanVien SelectByID(String ID) {
        List<NhanVien> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> SelectAll() {
        return this.SelectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public List<NhanVien> SelectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet result = XJdbc.query(sql, args);
            while (result.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(result.getString("MaNV"));
                entity.setTenNV(result.getString("TenNV"));
                entity.setSoDienThoai(result.getString("SoDienThoai"));
                entity.setDiaChi(result.getString("DiaChi"));
                entity.setCmnd(result.getString("CMND"));
                entity.setGioiTinh(result.getBoolean("GioiTinh"));
                entity.setMaChucVu(result.getString("MaChucVu"));
                entity.setGmail(result.getString("Gmail"));
                entity.setPath(result.getString("PathAnh"));
                list.add(entity);
            }
            result.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<NhanVien> SelectByIDS(String ID) {
        List<NhanVien> list = this.SelectBySQL(SELECT_BY_ID_SQL, ID);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<NhanVien> SelectBySDT(String SDT) {
        List<NhanVien> list = this.SelectBySQL(SELECT_BY_SDT_SQL, SDT);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
