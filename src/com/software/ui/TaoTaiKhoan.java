/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.ui;

import com.software.dao.NhanVienDAO;
import com.software.dao.TaiKhoanDAO;
import com.software.entity.NhanVien;
import com.software.entity.TaiKhoan;
import com.software.jdbcHelper.XImage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TaoTaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form TaoTaiKhoan
     */
    NhanVienDAO dao = new NhanVienDAO();
    TaiKhoanDAO daoTK = new TaiKhoanDAO();
    static String manv = MainInterfaceDialog.manv;
    List<TaiKhoan> listTK;

    public TaoTaiKhoan() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        NhanVien nv = dao.SelectByID(manv);
        this.setForm(nv);
        this.setTitle("Shop Thể Thao BingBong");
        this.setIconImage(XImage.getAppIcon());
    }

    public void setForm(NhanVien nv) {
        txtSDT.setText(nv.getSoDienThoai());
    }

    public TaiKhoan getForm() {
        TaiKhoan tk = new TaiKhoan();
        tk.setSoDienThoai(txtSDT.getText());
        tk.setMatKhau(pwdMatKhau.getText());
        return tk;
    }

    public void insert() {
        TaiKhoan tk = getForm();
        daoTK.insert(tk);
        JOptionPane.showMessageDialog(this, "Susecfully");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBack = new javax.swing.JLabel();
        btnHoanTat = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        pwdMatKhau = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        pwdXNMarKhau = new javax.swing.JPasswordField();
        lblMatKhau = new javax.swing.JLabel();
        lblNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/back.png"))); // NOI18N
        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 36, 36));

        btnHoanTat.setBackground(new java.awt.Color(0, 51, 255));
        btnHoanTat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHoanTat.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanTat.setText("Hoàn Tất");
        btnHoanTat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHoanTat.setSelected(true);
        btnHoanTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTatActionPerformed(evt);
            }
        });
        getContentPane().add(btnHoanTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 90, 40));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 51));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Tạo Tài Khoản");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 550, -1));

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Số Điện Thoại");

        pwdMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Xác nhận mật khẩu ");

        pwdXNMarKhau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lblMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMatKhau.setText("Mật Khẩu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdXNMarKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwdXNMarKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, -1, -1));

        lblNen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/background2.jpg"))); // NOI18N
        getContentPane().add(lblNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void btnHoanTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTatActionPerformed
        if (checkForm()) {
            insert();
            this.dispose();

        }
    }//GEN-LAST:event_btnHoanTatActionPerformed

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
            java.util.logging.Logger.getLogger(TaoTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaoTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanTat;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNen;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField pwdMatKhau;
    private javax.swing.JPasswordField pwdXNMarKhau;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables

    public boolean checkForm() {

        TaiKhoan tk = getForm();

        if (pwdMatKhau.getText().equals("")
                || pwdXNMarKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mật khẩu của bạn !", "Error", 1);
            return false;
        } else if (pwdMatKhau.getText().length() < 6 || pwdMatKhau.getText().length() > 18) {
            JOptionPane.showMessageDialog(this, "Mật khẩu bao gồm 6 đến 18 ký tự", "Error", 1);
            return false;
        } else if (!(pwdXNMarKhau.getText()).equalsIgnoreCase(pwdMatKhau.getText())) {
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu chưa chính xác", "Error", 1);
            pwdXNMarKhau.requestFocus();
            return false;
        }
//        listTK = daoTK.SelectAll();
//        for (TaiKhoan tkk : listTK) {
////            if (txtSDT.getText().equals(tkk.getSoDienThoai())) {
////                JOptionPane.showMessageDialog(this, "Mã nhân viên không được phép trùng!", "Error", 1);
////                return false;
////            }
//            String sdt = tkk.getSoDienThoai();
//            System.out.println(sdt);
        // }

        return true;
    }
}
