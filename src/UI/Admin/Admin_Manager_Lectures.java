/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Admin;

import DAO.ConnectDB;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Admin_Manager_Lectures extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admin_Manager_Lectures
     */
    public Admin_Manager_Lectures() {
        initComponents();
        this.loadDataToTable();
    }
    ConnectDB connect = new ConnectDB();
    boolean isDelete = true;

    public void DeleteLacture() {

        String sql = "exec sp_removeGiangvien N'" + txt_IDLecturers.getText() + "'";
        try {
            connect.UpdateSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa giang viên, Mã lỗi: " + e);
        }

    }

    public void loadDataToTable() {
        String head[] = {"Mã giảng viên", "Họ và tên", "Email/Tên người dùng", "Mật khẩu", "Số điện thoại", "Địa chỉ"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        String sql = "select Magiangvien, Tengiangvien, Giangvien.Email, Matkhau, Sodienthoai, Diachi from Giangvien  inner join Taikhoan on Giangvien.Email = Taikhoan.Tentaikhoan";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                tablemodel.addRow(data);
            }
            Tab_view.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi " + e);
        }
        isDelete = false;
    }

    public void showDetail(int row) {
        txt_IDLecturers.setText(Tab_view.getValueAt(row, 0).toString());
        txt_Name.setText(Tab_view.getValueAt(row, 1).toString());
        txt_email.setText(Tab_view.getValueAt(row, 2).toString());
        txt_Password.setText(Tab_view.getValueAt(row, 3).toString());
        txt_Numberphone.setText(Tab_view.getValueAt(row, 4).toString());
        txt_Address.setText(Tab_view.getValueAt(row, 5).toString());
    }

    public boolean AddNewLacture() {

        if (txt_IDLecturers.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống mã giảng viên!");
            return false;
        }
        if (txt_IDLecturers.getText().matches("[ ]+")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng mã giảng viên!");
            return false;
        }
        if (txt_Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống Họ Tên!");
            return false;
        }
        if (txt_Name.getText().matches("[ ]+")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng tên giảng viên!");
            return false;
        }
        if (txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống Email!");
            return false;
        }
        if (txt_email.getText().matches("[ ]+")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng Email!");
            return false;
        }

        for (int i = 0; i < Tab_view.getRowCount(); i++) {
            if (txt_email.getText().equalsIgnoreCase(Tab_view.getValueAt(i, 2).toString())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
                return false;
            }
        }
        
        if (txt_Password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống Mật khẩu!");
            return false;
        }
        if (txt_Password.getText().matches("[ ]+")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng mật khẩu");
            return false;
        }
        if (txt_Numberphone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống số điện thoại!");
            return false;
        }
        try {
            Double.parseDouble(txt_Numberphone.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số !");
            return false;
        }
        if (txt_Numberphone.getText().matches("[ ]+") || txt_Numberphone.getText().length() > 12) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng số điện thoại!");
            return false;
        }
        if (txt_Address.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để trống địa chỉ!");
            return false;
        }
        if (txt_Address.getText().matches("[ ]+")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng địa chỉ!");
            return false;
        }
        for (int i = 0; i < Tab_view.getRowCount(); i++) {
            if (txt_IDLecturers.getText().equalsIgnoreCase(Tab_view.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại!");
                return false;
            }
        }
        return true;
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_view = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_Numberphone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_IDLecturers = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_Clean = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_Addnew = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_Name = new javax.swing.JTextField();
        txt_Address = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Quản lý giảng viên");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/reminder.png"))); // NOI18N

        jLabel2.setText("Email chính là tài khoản đăng nhập!!!");

        jLabel3.setText("Mã giảng viên của mỗi giảng viên là khác nhau");

        Tab_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã giảng viên", "Tên giảng viên", "Email/Tài khoản đăng nhập", "mật khẩu", "Số điện thoại", "Địa chỉ"
            }
        ));
        Tab_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_view);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý giảng viên"));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        txt_Numberphone.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txt_Numberphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumberphoneActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        txt_IDLecturers.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel10.setText("Mã giảng viên:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setText("Họ và Tên: ");

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/delete.png"))); // NOI18N
        btn_Delete.setText("Xóa");
        btn_Delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel6.setText("Email/Tài khoản:");

        btn_Clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/wiping-swipe-for-floors.png"))); // NOI18N
        btn_Clean.setText("Làm sạch");
        btn_Clean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Clean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CleanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel7.setText("Địa chỉ:");

        btn_Addnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/plus.png"))); // NOI18N
        btn_Addnew.setText("Thêm mới");
        btn_Addnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Addnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddnewActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel8.setText("Mật khẩu:");

        txt_Password.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        txt_email.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        txt_Name.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        txt_Address.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(txt_Name))
                    .addComponent(txt_IDLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Numberphone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_Clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Addnew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_Delete)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(btn_Clean))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(btn_Addnew)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16)
                                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_IDLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Numberphone, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(txt_Name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2)))
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NumberphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumberphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumberphoneActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        if (isDelete == true) {
            DeleteLacture();
            this.loadDataToTable(); 
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } else {

        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CleanActionPerformed
        txt_Address.setText("");
        txt_IDLecturers.setText("");
        txt_Name.setText("");
        txt_Numberphone.setText("");
        txt_Password.setText("");
        txt_email.setText("");
        this.loadDataToTable();
        txt_IDLecturers.setEditable(true);
        txt_IDLecturers.setBackground(Color.white);

    }//GEN-LAST:event_btn_CleanActionPerformed

    private void btn_AddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddnewActionPerformed
        if (this.AddNewLacture()) {
            String sql = "exec sp_addGiangvien N'" + txt_IDLecturers.getText() + "', N'" + txt_Name.getText() + "', N'" + txt_Numberphone.getText() + "', N'" + txt_Address.getText() + "', N'" + txt_email.getText() + "', N'" + txt_Password.getText() + "', N'giangvien' ";
            try {
                connect.UpdateSQL(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm giải giảng viên lỗi, mã lỗi: 1, Lỗi chi tiết: " + e);
            }
        }
        this.loadDataToTable();

    }//GEN-LAST:event_btn_AddnewActionPerformed

    private void Tab_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_viewMouseClicked
        // TODO add your handling code here:
        int row = Tab_view.getSelectedRow();
        this.showDetail(row);
        txt_IDLecturers.setEditable(false);
        txt_IDLecturers.setBackground(Color.gray);
        isDelete = true;
    }//GEN-LAST:event_Tab_viewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab_view;
    private javax.swing.JButton btn_Addnew;
    private javax.swing.JButton btn_Clean;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Address;
    private javax.swing.JTextField txt_IDLecturers;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_Numberphone;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
