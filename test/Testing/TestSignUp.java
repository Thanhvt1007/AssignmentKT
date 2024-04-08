package Testing;

import com.software.dao.TaiKhoanDAO;
import com.software.entity.TaiKhoan;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestSignUp {

    TaiKhoanDAO udao = new TaiKhoanDAO();
    @Rule
    public ErrorCollector ec = new ErrorCollector();
    static int count, index;

    public int countUser() {
        int temp = 0;
        try {
            List<TaiKhoan> u = udao.SelectAll();
            temp = u.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Before
    public void beforeUser() {
        count = countUser();
        System.out.println(count);
    }

    @Test
    public void testSignup1() {
        try {
            TaiKhoan user = new TaiKhoan();
            udao.insert(user);
        } catch (Exception e) {
            ec.addError(new Throwable("Loi check null: " + e));
        }
        index = countUser();
        Assert.assertEquals(index, count);
    }

    @Test
    public void testSignup2() {
        try {
            TaiKhoan user = new TaiKhoan();
            user.setSoDienThoai("");
            user.setMatKhau("123456");
            udao.insert(user);
        } catch (Exception e) {
            ec.addError(new Throwable("Loi check null user: " + e));
        }
        index = countUser();
        Assert.assertEquals(index, count);
    }

    @Test
    public void testSignup3() {
        try {
            TaiKhoan user = new TaiKhoan();
            user.setSoDienThoai("");
            user.setMatKhau("123456");
            udao.insert(user);
        } catch (Exception e) {
            ec.addError(new Throwable("Loi check null pass: " + e));
        }
        index = countUser();
        Assert.assertEquals(index, count);
    }

    @Test
    public void testSignup4() {
        try {
            TaiKhoan user = new TaiKhoan();
            user.setSoDienThoai("");
            user.setMatKhau("123456");
            udao.insert(user);
        } catch (Exception e) {
            ec.addError(new Throwable("Loi check null FullName: " + e));
        }
        index = countUser();
        Assert.assertEquals(index, count);
    }

    @Test
    public void testSignup7() {
        try {
            TaiKhoan user = new TaiKhoan();
            user.setSoDienThoai("037996723");
            user.setMatKhau("123456");
            udao.insert(user);
        } catch (Exception e) {
            ec.addError(new Throwable("Check đầy đủ thông tin: " + e));
        }
        index = countUser();
        Assert.assertEquals(index, count);
    }

    @After
    public void afterUser() {
        System.out.println(count);
    }

    @AfterClass
    public static void CloseConnect() {

    }

}
