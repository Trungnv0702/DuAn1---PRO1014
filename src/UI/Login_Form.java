package UI;

import DAO.ConnectDB;
import UI.Admin.Admin_Manage_Form;
import UI.Lecturers.Lecturers_Manage_Main_Form;
import UI.Student.Student_CheckCode_Form;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author trung
 */
public class Login_Form extends javax.swing.JFrame {

    public Login_Form() {
        this.openLogin();
        initComponents();
        setResizable(false);

        setLocationRelativeTo(null);
    }

    void openLogin() {
        new ChaoJDialog(this, true).setVisible(true);
    }

    ConnectDB connect = new ConnectDB();

    public boolean checkLogin() {
        try {
            String Username = txt_Username.getText();
            String Password = txt_Password.getText();
            String sql = "select role from Taikhoan where Tentaikhoan like N'" + Username + "' and Matkhau like N'" + Password + "'";
            String sqlGetName = "select Tensinhvien,masinhvien from Sinhvien where Email = N'" + Username + "'";
            ResultSet getName = connect.querySQL(sqlGetName);
            ResultSet rs = connect.querySQL(sql);
            String role = "";
            String pushName = "";
            String pushID="";
            while (getName.next()) {
                pushName = getName.getString(1);
                pushID = getName.getString(2);
            }
            while (rs.next()) {
                role = rs.getString(1);
            }
            if (role.equalsIgnoreCase("admin")) {
                Admin_Manage_Form adminform = new Admin_Manage_Form();
                adminform.setUsername(txt_Username.getText());
                adminform.show();
                this.dispose();
                return true;
            } else if (role.equalsIgnoreCase("Sinhvien")) {
                Student_CheckCode_Form checkCode = new Student_CheckCode_Form();
                checkCode.setName(pushName, pushID);
                checkCode.show();
                this.dispose();
                return true;
            } else if (role.equalsIgnoreCase("giangvien")) {
                Lecturers_Manage_Main_Form LectureMform = new Lecturers_Manage_Main_Form();
                LectureMform.show();
                String sql1 = "	select magiangvien,tengiangvien from giangvien where email like '" + Username + "'";
                String tengiangvien = "";
                rs = connect.querySQL(sql1);
                if (rs.next()) {
                    LectureMform.setThongTinLecture(rs.getString(1), rs.getString(2), txt_Username.getText());
                }

                this.dispose();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi" + e);
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Username = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        txt_Password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 384));
        setPreferredSize(new java.awt.Dimension(988, 469));
        getContentPane().setLayout(null);

        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Username);
        txt_Username.setBounds(600, 110, 220, 40);

        btn_exit.setBackground(new java.awt.Color(153, 153, 153));
        btn_exit.setForeground(new java.awt.Color(204, 204, 204));
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logoutttttt.png"))); // NOI18N
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit);
        btn_exit.setBounds(750, 300, 80, 40);

        btn_login.setBackground(new java.awt.Color(153, 153, 153));
        btn_login.setForeground(new java.awt.Color(204, 204, 204));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/enter.png"))); // NOI18N
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(590, 300, 80, 40);
        getContentPane().add(txt_Password);
        txt_Password.setBounds(600, 210, 220, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Exam FPL version 1.0.1");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 340, 150, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Website: edu.fpt.vn");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 370, 140, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email: fpteducation@fe.edu.vn");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 400, 210, 20);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel6.setText("PASSWORD:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(600, 170, 90, 30);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel8.setText("USERNAME:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(600, 70, 90, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/Anhdangnhao.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 990, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        if (this.checkLogin()) {
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu, hãy kiểm tra lại!");
        }

    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
