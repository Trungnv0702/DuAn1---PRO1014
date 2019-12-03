/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Student;

import DAO.ConnectDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Student_CheckCode_Form extends javax.swing.JFrame {
    
    public Student_CheckCode_Form() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    static String studentID;
    
    public void setName(String username, String id) {
        lbl_setName.setText(username);
        studentID = id;
    }
    
    String usernameGet;
    
    ConnectDB connect = new ConnectDB();
    
    public boolean check_Login() {
        
        String IDExam = txt_maKithi.getText();
        String Subject = txt_Monthi.getText();
        
        String sql = "select * from Kithi where Makithi = N'" + IDExam + "' and Mamon  = N'" + Subject + "'";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Student_Exam_Form student_Exam = new Student_Exam_Form();
                student_Exam.show();
                this.dispose();
                student_Exam.setTitle(rs.getString(1), rs.getString(4), rs.getString(3), lbl_setName.getText(), studentID);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public boolean checked_Exam() {
        try {
            String sql = "select * from Ketqua where Makithi = N'" + txt_maKithi.getText() + "' and Masinhvien = N'" + studentID + "'";
            ResultSet rs = connect.querySQL(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bạn đã thi kì thi " + txt_maKithi.getText());
                return false;
            }
            else 
                return  true;
        } catch (Exception e) {
        }
        return false;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_maKithi = new javax.swing.JTextField();
        txt_Monthi = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        btn_enter = new javax.swing.JButton();
        lbl_setName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exam FPL");
        setMinimumSize(new java.awt.Dimension(990, 445));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mã kì thi:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 150, 66, 19);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Môn thi:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 230, 57, 19);
        getContentPane().add(txt_maKithi);
        txt_maKithi.setBounds(580, 180, 222, 35);

        txt_Monthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MonthiActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Monthi);
        txt_Monthi.setBounds(580, 260, 222, 35);

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logouttt.png"))); // NOI18N
        btn_exit.setText("Thoát");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit);
        btn_exit.setBounds(750, 350, 97, 43);

        btn_enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/checkmark.png"))); // NOI18N
        btn_enter.setText("VÀO THI");
        btn_enter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_enterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_enterMouseEntered(evt);
            }
        });
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enter);
        btn_enter.setBounds(540, 350, 109, 43);
        getContentPane().add(lbl_setName);
        lbl_setName.setBounds(830, 10, 150, 14);

        jLabel5.setText("Chào,");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(790, 10, 40, 14);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/nhap.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 990, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
        if (checked_Exam()== false) {
            return;
        }
        if (check_Login()) {
            
        } else {
            JOptionPane.showMessageDialog(null, "Sai kì thi hoặc môn thi, kiểm tra lại!");
            return;
        }

    }//GEN-LAST:event_btn_enterActionPerformed

    private void btn_enterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_enterMouseClicked

    }//GEN-LAST:event_btn_enterMouseClicked

    private void btn_enterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_enterMouseEntered
        // TODO add your hadling code here:
    }//GEN-LAST:event_btn_enterMouseEntered

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        
        int c = JOptionPane.showConfirmDialog(this, "Thoát chương trình", "Bạn có muốn thoát?", JOptionPane.YES_NO_OPTION);
        if (c == 0) {
            this.dispose();
        }

    }//GEN-LAST:event_btn_exitActionPerformed

    private void txt_MonthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MonthiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MonthiActionPerformed

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
            java.util.logging.Logger.getLogger(Student_CheckCode_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_CheckCode_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_CheckCode_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_CheckCode_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_CheckCode_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enter;
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_setName;
    private javax.swing.JTextField txt_Monthi;
    private javax.swing.JTextField txt_maKithi;
    // End of variables declaration//GEN-END:variables
}
