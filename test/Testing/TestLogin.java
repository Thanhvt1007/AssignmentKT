package Testing;

import com.software.dao.TaiKhoanDAO;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestLogin {

    TaiKhoanDAO udao = new TaiKhoanDAO();
    @Rule
    public ErrorCollector ec = new ErrorCollector();

    @Test
    public void checkLogin1() {
        String user = "";
        String pass = "";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check null: " + e));
        }
    }

    @Test
    public void checkLogin2() {
        String user = "";
        String pass = "abc";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check null user: " + e));
        }
    }

    @Test
    public void checkLogin3() {
        String user = "tuine";
        String pass = "";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check null pass: " + e));
        }
    }

    @Test
    public void checkLogin4() {
        String user = "tuine";
        String pass = "123";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check sai user,pass: " + e));
        }
    }

    @Test
    public void checkLogin5() {
        String user = "phine";
        String pass = "0379967723";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check sai user, dung pass: " + e));
        }
    }

    @Test
    public void checkLogin6() {
        String user = "0379967723";
        String pass = "1234";
        boolean expected = false;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check dung user, sai pass: " + e));
        }
    }
//
    @Test
    public void checkLogin7() {
        String user = "0769331203";
        String pass = "admin@123";
        boolean expected = true;
        boolean actual = udao.checkLogin(user, pass) != null;
        try {
           Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            ec.addError(new Throwable("Loi check dung user, dung pass: " + e));
        }
    }

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(TestLogin.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
