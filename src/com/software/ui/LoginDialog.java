//* Coder: NGUYEN DOAN CHI THUC - HUYNH VAN DAT
//* Date of writing code: 29/11/2021
//* Class: IT16301
package com.software.ui;

import com.software.dao.NhanVienDAO;
import com.software.dao.TaiKhoanDAO;
import com.software.entity.NhanVien;
import com.software.entity.TaiKhoan;
import com.software.jdbcHelper.MsgBox;
import com.software.jdbcHelper.XImage;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class LoginDialog extends javax.swing.JFrame {

    /**
     * Creates new form LoginDialog
     */
    static String phoneLogin = null;
    static String positionLogin = null;
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    List<NhanVien> listNhanVien;
    List<TaiKhoan> listTaiKhoan;
    int dem = 0;
    int clickFirst = 0;

    public LoginDialog() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtUser.setBackground(new java.awt.Color(0, 0, 0, 1));
        pwdPass.setBackground(new java.awt.Color(0, 0, 0, 1));
        lblTitle.requestFocus();
        this.setIconImage(XImage.getAppIcon());
        pwdPass.setEchoChar((char) 0);
        lblAnHienPass.setEnabled(false);
    }

    public boolean ValidateFormLogin() {
        String isPhone = "^[0]+[3_5_7-9]+[0-9]{8}";
        String isPassWord = ".{8,}";
        if (txtUser.getText().equals("Số Điện Thoại") || txtUser.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập Username");
            return false;
        } else if (pwdPass.getText().equals("Mật Khẩu") || pwdPass.getText().isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập Password");
            return false;
        } else if (!txtUser.getText().matches(isPhone)) {
            MsgBox.alert(this, "Số điện thoại không hợp lệ!");
            return false;
        } else if (!pwdPass.getText().matches(isPassWord)) {
            MsgBox.alert(this, "Mật khẩu không hợp lệ!\nMật khẩu ít nhất 8 ký tự");
            return false;
        }
        return true;
    }

    @SuppressWarnings("null")
    public void Login() {
        listTaiKhoan = taiKhoanDAO.SelectAll();
        listNhanVien = nhanVienDAO.SelectAll();
        int check = 0;
        String phone = null;
        String pass = null;
        String position = null;
        for (int i = 0; i < listNhanVien.size(); i++) {
            if (txtUser.getText().equals(listNhanVien.get(i).getSoDienThoai())) {
                check = 1;
                phone = txtUser.getText();
                position = listNhanVien.get(i).getMaChucVu();
                break;
            }
        }
        if (check == 0) {
            MsgBox.alert(this, "Số điện thoại hoặc mật khẩu không đúng!\nVui lòng kiểm tra lại!");
            reset();
        } else {
            check = 0;
            for (int i = 0; i < listTaiKhoan.size(); i++) {
                if (phone.equals(listTaiKhoan.get(i).getSoDienThoai())) {
                    check = 1;
                    pass = listTaiKhoan.get(i).getMatKhau();
                    break;
                }
            }
            if (check == 1) {
                if (pwdPass.getText().equals(pass)) {
                    MsgBox.alert(this, "Đăng nhập thành công!");
                    phoneLogin = phone;
                    positionLogin = position;
                    this.dispose();
                    new MainInterfaceDialog().setVisible(true);
                } else {
                    MsgBox.alert(this, "Số điện thoại hoặc mật khẩu không đúng!\nVui lòng kiểm tra lại!");
                    reset();
                }
            } else {
                MsgBox.alert(this, "Số điện thoại hoặc mật khẩu không đúng!\nVui lòng kiểm tra lại!");
                reset();
            }
        }
    }

    public void clickPassword() {
        if (clickFirst == 0) {
            pwdPass.setText("");
            lblAnHienPass.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/hidden.png")));
            lblAnHienPass.setEnabled(true);
            pwdPass.setEchoChar('●');
            dem = 0;
        }
        clickFirst ++;
    }
    
    public void clickHidePass() {
        if (!pwdPass.getText().equals("Mật Khẩu")) {
            if (dem % 2 != 0) {
                lblAnHienPass.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/hidden.png")));
                pwdPass.setEchoChar('●');
            } else {
                lblAnHienPass.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/view.png")));
                pwdPass.setEchoChar((char) 0);
            }
            dem++;
        }
    }
    
    public void reset() {
        dem = 0;
        clickFirst = 0;
        txtUser.setText("Số Điện Thoại");
        pwdPass.setText("Mật Khẩu");
        lblAnHienPass.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/view.png")));
        pwdPass.setEchoChar((char) 0);
        lblAnHienPass.setEnabled(false);
        lblLogin.requestFocus();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGioiThieu = new javax.swing.JLabel();
        lblGioiThieu1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblAnHienPass = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        pwdPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        lblGioiThieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGioiThieu.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiThieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiThieu.setText("© 2021 Bing Bong Login From | Design by HAZ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGioiThieu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGioiThieu1.setForeground(new java.awt.Color(255, 153, 0));
        lblGioiThieu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiThieu1.setText("© 2021 Bing Bong Login From | Design by HAZ");
        getContentPane().add(lblGioiThieu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 390, 20));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 153, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("BING BONG LOGIN");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 68, 470, 40));

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        lblQuenMatKhau.setText("Forgot password?");
        lblQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseExited(evt);
            }
        });
        getContentPane().add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, -1, -1));

        lblLogin.setBackground(new java.awt.Color(51, 102, 255));
        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.setOpaque(true);
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
        });
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 129, 44));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/running.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, -1));

        jPanel1.setOpaque(false);

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 102, 255));
        txtUser.setText("Số Điện Thoại");
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 51, 255)));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/steward (1).png"))); // NOI18N

        lblAnHienPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnHienPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/view.png"))); // NOI18N
        lblAnHienPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 51, 255)));
        lblAnHienPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAnHienPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnHienPassMouseClicked(evt);
            }
        });

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/smartphone.png"))); // NOI18N

        pwdPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pwdPass.setForeground(new java.awt.Color(102, 102, 255));
        pwdPass.setText("Mật Khẩu");
        pwdPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 51, 255)));
        pwdPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdPassFocusLost(evt);
            }
        });
        pwdPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUser)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pwdPass, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(lblAnHienPass, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAnHienPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 410, 150));

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/close.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 0, 30, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/background2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 0, 490, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        lblLogin.requestFocus();
        if (ValidateFormLogin() == true) {
            Login();
        }
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        this.dispose();
        new ForgotPasswordDialog().setVisible(true);
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/closeHower.png")));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/close.png")));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        lblLogin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(51, 255, 51)));
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        lblLogin.setBorder(null);
    }//GEN-LAST:event_lblLoginMouseExited

    private void lblQuenMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseEntered
        lblQuenMatKhau.setForeground(new Color(0, 102, 0));
        lblQuenMatKhau.setText("<html><u>Forgot password?</u></html>");
    }//GEN-LAST:event_lblQuenMatKhauMouseEntered

    private void lblQuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseExited
        lblQuenMatKhau.setForeground(new Color(102, 102, 102));
        lblQuenMatKhau.setText("Forgot password?");
    }//GEN-LAST:event_lblQuenMatKhauMouseExited

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        if (txtUser.getText().equals("Số Điện Thoại")) {
            txtUser.setText(null);
        }
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        if (txtUser.getText().isEmpty()) {
            txtUser.setText("Số Điện Thoại");
        }
    }//GEN-LAST:event_txtUserFocusLost

    private void pwdPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPassFocusGained
        clickPassword();
        if (pwdPass.getText().equals("Mật Khẩu")) {
            pwdPass.setText(null);
        }
    }//GEN-LAST:event_pwdPassFocusGained

    private void pwdPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPassFocusLost
        if (pwdPass.getText().isEmpty()) {
            pwdPass.setText("Mật Khẩu");
            lblAnHienPass.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/view.png")));
            pwdPass.setEchoChar((char) 0);
            dem = 0;
            clickFirst = 0;
        }
    }//GEN-LAST:event_pwdPassFocusLost

    private void pwdPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdPassMouseClicked
        clickPassword();
    }//GEN-LAST:event_pwdPassMouseClicked

    private void lblAnHienPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnHienPassMouseClicked
        clickHidePass();
    }//GEN-LAST:event_lblAnHienPassMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnHienPass;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblGioiThieu;
    private javax.swing.JLabel lblGioiThieu1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField pwdPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
