/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.ui;

import com.software.jdbcHelper.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author DELL
 */
public class HelloScreenDialog extends javax.swing.JFrame {

    Timer timer;

    public HelloScreenDialog() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
        prbLoading.setUI(new BasicProgressBarUI() {
        });
        this.LoadPrb();
        prbLoading.setBackground(new java.awt.Color(0, 0, 1, 0));
    }

    public void LoadPrb() {
        timer = new Timer(60, new ActionListener() {
            @Override
            @SuppressWarnings("UnusedAssignment")
            public void actionPerformed(ActionEvent e) {
                int giaTriHienTai = prbLoading.getValue();
                lblPhanTram.setVisible(false);
                lblPhanTram.setVisible(true);
                lblPhanTram.setText(String.valueOf(giaTriHienTai)+"%");
                prbLoading.setValue(giaTriHienTai += 1);
                if (prbLoading.getValue() == 100) {
                    timer.stop();
                    HelloScreenDialog.this.dispose();
                    new LoginDialog().setVisible(true);

                }
            }
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPhanTram = new javax.swing.JLabel();
        prbLoading = new javax.swing.JProgressBar();
        lblClose = new javax.swing.JLabel();
        lblAnhNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhanTram.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhanTram.setForeground(new java.awt.Color(255, 255, 255));
        lblPhanTram.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhanTram.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(lblPhanTram, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 50, 40));

        prbLoading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prbLoading.setForeground(new java.awt.Color(51, 153, 255));
        prbLoading.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 153, 255)));
        prbLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        prbLoading.setOpaque(true);
        getContentPane().add(prbLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 990, 40));

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/close2.png"))); // NOI18N
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
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 30, 30));

        lblAnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/software/icon/NenManHinhChao.png"))); // NOI18N
        lblAnhNen.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(lblAnhNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/close2.png")));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/software/icon/closeHower.png")));
    }//GEN-LAST:event_lblCloseMouseEntered

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
            java.util.logging.Logger.getLogger(HelloScreenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelloScreenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelloScreenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelloScreenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloScreenDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAnhNen;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblPhanTram;
    private javax.swing.JProgressBar prbLoading;
    // End of variables declaration//GEN-END:variables
}
