/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pourosova;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author mahadi
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setResizable(false);
        ScaleImage1();
        ScaleImage2();
    }

    public void ScaleImage1() {
        ImageIcon ic;
        ic = new ImageIcon("D:\\Java\\Pourosova\\Images\\logo.png");
        Image im = ic.getImage();
        Image imscale = im.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(imscale);
        jLabel3.setIcon(scaledicon);
    }

    public void ScaleImage2() {
        ImageIcon ic;
        ic = new ImageIcon("D:\\Java\\Pourosova\\Images\\back.jpg");
        Image im = ic.getImage();
        Image imscale = im.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(imscale);
        jLabel4.setIcon(scaledicon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        nid = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        goBackBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Java\\Pourosova\\Images\\nid.png")); // NOI18N
        jLabel1.setToolTipText("NID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 136, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Java\\Pourosova\\Images\\password.png")); // NOI18N
        jLabel2.setToolTipText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 204, -1, 40));

        loginBtn.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        loginBtn.setText("Log in");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 274, 221, 41));

        nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nidActionPerformed(evt);
            }
        });
        getContentPane().add(nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 136, 374, 40));

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 204, 374, 40));

        goBackBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        goBackBtn.setText("Go back");
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 327, 221, 41));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 6, 119, 87));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nidActionPerformed

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        // TODO add your handling code here:
        Welcome w = new Welcome();
        w.setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackBtnActionPerformed

    public void loginBtnActionPerformed_work() {
        try {
            // TODO add your handling code here:
            String Nid = nid.getText();
            String Pass = password.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rivendell_pourosova", "root", "admin");

            String query = "SELECT * FROM rivendell_pourosova.user_info WHERE NID = '" + Nid + "' AND password = '" + Pass + "';";
            // System.out.println(query);
            PreparedStatement stmt = con.prepareStatement(query);
//            stmt.setString(1, Nid);//1 specifies the first parameter in the query  
//            stmt.setString(2, Pass);
            ResultSet r = stmt.executeQuery();
            if (r.next()) {
                new UserMain().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Wrong NID or password!", "Error", 0);
                nid.setText("");
                password.setText("");
            }

        } catch (Exception ex) {
            //Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        loginBtnActionPerformed_work();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginBtnActionPerformed_work();
        }
    }//GEN-LAST:event_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBackBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField nid;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
