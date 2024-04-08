package Testing;

import com.software.dao.NhanVienDAO;
import com.software.entity.NhanVien;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUpdate {

    NhanVienDAO udao = new NhanVienDAO();

    @BeforeClass
    public static void OpenConnect() {

    }

    @Before
    public void beforeUser() {

    }

    @Test
    public void testUpdateNullusername() {
        boolean t;
        NhanVien uip = new NhanVien();
        try {
            uip.setMaNV("nnv0232");
            uip.setTenNV("");
            uip.setCmnd("vtk@fpt.edu.vn");
            uip.setDiaChi("sdfsdf");
            uip.setGioiTinh(true);
            uip.setGmail("trinhlek4@gmail.com");
            uip.setMaChucVu("1");
            uip.setSoDienThoai("0384372773");
            udao.update(uip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien ubf = udao.SelectByID(uip.getMaNV());
        if (ubf != null) {
            boolean temp = uip.getMaNV().equals(ubf.getMaNV())
                    && uip.getTenNV().equals(ubf.getTenNV()) && uip.getGmail().equals(ubf.getGmail())
                    && uip.getMaChucVu() == ubf.getMaChucVu();
            t = temp;
        } else {
            t = false;
        }

        assertFalse(t);
    }

    @Test
    public void testUpdateNullpass() {
        boolean t;
        NhanVien uip = new NhanVien();
        try {
            uip.setMaNV("nnv0232");
            uip.setTenNV("dasdasdassad");
            uip.setCmnd("vtk@fpt.edu.vn");
            uip.setDiaChi("sdfsdf");
            uip.setGioiTinh(true);
            uip.setGmail("trinhlek4@gmail.com");
            uip.setMaChucVu("1");
            uip.setSoDienThoai("0384372773");
            udao.update(uip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien ubf = udao.SelectByID(uip.getMaNV());
        if (ubf != null) {
            boolean temp = uip.getMaNV().equals(ubf.getMaNV())
                    && uip.getTenNV().equals(ubf.getTenNV()) && uip.getGmail().equals(ubf.getGmail())
                    && uip.getMaChucVu() == ubf.getMaChucVu();
            t = temp;
        } else {
            t = false;
        }

        assertFalse(t);
    }

   

    @Test
    public void testUpdateNullemail() {
        boolean t;
        NhanVien uip = new NhanVien();
        try {
            uip.setMaNV("nnv0232");
            uip.setTenNV("dasdasdassad");
            uip.setCmnd("vtk@fpt.edu.vn");
            uip.setDiaChi("sdfsdf");
            uip.setGioiTinh(true);
            uip.setGmail("");
            uip.setMaChucVu("1");
            uip.setSoDienThoai("0384372773");
            udao.update(uip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien ubf = udao.SelectByID(uip.getMaNV());
        if (ubf != null) {
            boolean temp = uip.getMaNV().equals(ubf.getMaNV())
                    && uip.getTenNV().equals(ubf.getTenNV()) && uip.getGmail().equals(ubf.getGmail())
                    && uip.getMaChucVu() == ubf.getMaChucVu();
            t = temp;
        } else {
            t = false;
        }

        assertFalse(t);
    }

    @Test
    public void testUpdateEmailError() {
         boolean t;
        NhanVien uip = new NhanVien();
        try {
            uip.setMaNV("nnv0232");
            uip.setTenNV("dasdasdassad");
            uip.setCmnd("vtk@fpt.edu.vn");
            uip.setDiaChi("sdfsdf");
            uip.setGioiTinh(true);
            uip.setGmail("asdasasdasd.com");
            uip.setMaChucVu("1");
            uip.setSoDienThoai("0384372773");
            udao.update(uip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien ubf = udao.SelectByID(uip.getMaNV());
        if (ubf != null) {
            boolean temp = uip.getMaNV().equals(ubf.getMaNV())
                    && uip.getTenNV().equals(ubf.getTenNV()) && uip.getGmail().equals(ubf.getGmail())
                    && uip.getMaChucVu() == ubf.getMaChucVu();
            t = temp;
        } else {
            t = false;
        }

        assertFalse(t);
    }

    @After
    public void afterUser() {

    }

    @AfterClass
    public static void CloseConnect() {

    }
}
