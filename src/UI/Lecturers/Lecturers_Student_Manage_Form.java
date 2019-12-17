package UI.Lecturers;

import DAO.ConnectDB;
import DAO.Interface_Class;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lecturers_Student_Manage_Form extends javax.swing.JInternalFrame implements Interface_Class {

    public Lecturers_Student_Manage_Form() {
        initComponents();
        this.loadDataToCombobox();
        this.loadToTable();
        this.setTitle("Quản lý sinh viên");
    }

    String ReMail = "\\w+@+\\w+(\\.\\w+){1,2}";
    ConnectDB connect = new ConnectDB();
    int row = -1;

    public void deleteStudent() {
        String sql = "exec sp_removeSinhvien N'" + txt_IDStudent.getText() + "'";
        try {
            connect.UpdateSQL(sql);
            this.loadToTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi xóa học sinh: " + e);
        }
        txt_Address.setText("");
        txt_Email.setText("");
        txt_FullName.setText("");
        txt_IDStudent.setText("");
        txt_Major.setText("");
        txt_Password.setText("");
        txt_SchoolYear.setText("");

    }

    public boolean checkFormAddNew() {
        try {
            if (txt_IDStudent.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống mã sinh viên!");
                return false;
            }
            if (txt_IDStudent.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mã sinh viên!");
                return false;
            }
            if (txt_FullName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống tên!");
                return false;
            }
            if (txt_FullName.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên sinh viên!");
                return false;
            }
            if (txt_Email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống email/tên đăng nhập!");
                return false;
            }
            if (!txt_Email.getText().matches(ReMail)) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng email sinh viên!");
                return false;
            }
            if (txt_Password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống mật khẩu!");
                return false;
            }
            if (txt_Password.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mật khẩu!");
                return false;
            }
            if (txt_SchoolYear.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống khóa!");
                return false;
            }
            if (txt_SchoolYear.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng khóa!");
                return false;
            }
            if (txt_Major.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống ngành!");
                return false;
            }
            if (txt_Major.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mật khẩu!");
                return false;
            }
            if (txt_Address.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống địa chỉ!");
                return false;
            }
            if (txt_Address.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng địa ch!");
                return false;
            }
            for (int i = 0; i < tab_View.getRowCount(); i++) {
                if (txt_IDStudent.getText().equalsIgnoreCase(tab_View.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại!");
                    return false;
                }
            }
            for (int i = 0; i < tab_View.getRowCount(); i++) {
                if (txt_Email.getText().equalsIgnoreCase(tab_View.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
                    return false;
                }
            }
            if (!txt_IDStudent.getText().equals("") || !txt_FullName.getText().equals("") || !txt_Email.getText().equals("") || txt_Email.getText().matches(ReMail)
                    || !txt_Password.getText().equals("") || !txt_SchoolYear.getText().equals("") || !txt_Major.getText().equals("") || !txt_Address.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Thêm thành công !");
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    public boolean checkFormUpdate() {
        try {
            if (txt_FullName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống tên!");
                return false;
            }
            if (txt_FullName.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên sinh viên!");
                return false;
            }
            if (txt_Email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống email/tên đăng nhập!");
                return false;
            }
            if (!txt_Email.getText().matches(ReMail)) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng email sinh viên!");
                return false;
            }
            if (txt_Password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống mật khẩu!");
                return false;
            }
            if (txt_Password.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mật khẩu!");
                return false;
            }
            if (txt_SchoolYear.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống khóa!");
                return false;
            }
            if (txt_SchoolYear.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng khóa!");
                return false;
            }
            if (txt_Major.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống ngành!");
                return false;
            }
            if (txt_Major.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mật khẩu!");
                return false;
            }
            if (txt_Address.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống địa chỉ!");
                return false;
            }
            if (txt_Address.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng địa ch!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    public void showDetail(int row) {
        txt_IDStudent.setText(tab_View.getValueAt(row, 0).toString());
        txt_FullName.setText(tab_View.getValueAt(row, 1).toString());
        txt_Email.setText(tab_View.getValueAt(row, 2).toString());
        txt_Password.setText(tab_View.getValueAt(row, 3).toString());
        txt_SchoolYear.setText(tab_View.getValueAt(row, 4).toString());
        cbb_Class.setSelectedItem(tab_View.getValueAt(row, 5).toString());
        txt_Major.setText(tab_View.getValueAt(row, 6).toString());
        txt_Address.setText(tab_View.getValueAt(row, 7).toString());

    }

    public void loadDataToCombobox() {
        String sql = "select Tenlop from Lop";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                cbb_Class.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load combobox" + e);
        }
    }

    public void loadToTable() {
        String head[] = {"Mã sinh viên", "Tên sinh viên", "Email/Tên người dùng", "Mật khẩu", "Khóa", "Lớp", "Ngành", "Địa chỉ"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        String sql = "select Masinhvien, Tensinhvien, Sinhvien.Email, Matkhau, Khoa, Malop, Nganh, Diachi from Sinhvien inner join Taikhoan on Sinhvien.Email = Taikhoan.Tentaikhoan";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                tablemodel.addRow(data);
            }
            tab_View.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load Combobox" + e);
        }

    }

    @Override
    public void AddNew() {
        if (this.checkFormAddNew()) {
            try {
                String sql = "exec sp_addSinhvien N'" + txt_IDStudent.getText() + "',N'" + txt_FullName.getText() + "',N'" + txt_Email.getText() + "',N'" + cbb_Class.getSelectedItem().toString() + "',N'" + txt_SchoolYear.getText() + "',N'" + txt_Major.getText() + "',N'" + txt_Address.getText() + "',N'" + txt_Password.getText() + "','Sinhvien'";
                connect.UpdateSQL(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại!" + e);
            }
        }
        this.loadToTable();
    }

    @Override
    public void Update() {
        if (this.checkFormUpdate()) {
            String sql = "exec sp_updateSinhvien N'" + txt_IDStudent.getText() + "',N'" + txt_FullName.getText() + "',N'" + txt_Email.getText() + "',N'" + cbb_Class.getSelectedItem().toString() + "',N'" + txt_SchoolYear.getText() + "',N'" + txt_Major.getText() + "',N'" + txt_Address.getText() + "',N'" + txt_Password.getText() + "'";
            try {
                connect.UpdateSQL(sql);
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi sửa sinh viên: " + e);
            }
        }
        this.loadToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        txt_FullName = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        txt_Major = new javax.swing.JTextField();
        txt_SchoolYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbb_Class = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_View = new javax.swing.JTable();
        btn_Delete = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_Addnew = new javax.swing.JButton();
        txt_clean = new javax.swing.JButton();
        txt_Address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_IDStudent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("Họ và Tên:");

        jLabel2.setText("Ngành:");

        jLabel3.setText("Email/Tên đăng nhập:");

        jLabel4.setText("Khóa:");

        jLabel5.setText("Mật khẩu:");

        txt_FullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FullNameActionPerformed(evt);
            }
        });

        jLabel6.setText("Lớp:");

        tab_View.setBackground(new java.awt.Color(255, 255, 204));
        tab_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Email/tài khoản đăng nhập", "Mật khẩu", "Khóa", "Lớp", "Ngành", "Địa chỉ"
            }
        ));
        tab_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_View);

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/perspective.png"))); // NOI18N
        btn_Delete.setText("Xóa");
        btn_Delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/updateddd.png"))); // NOI18N
        btn_Update.setText("Cập nhật");
        btn_Update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Update.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_Addnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/add-file (1).png"))); // NOI18N
        btn_Addnew.setText("Thêm");
        btn_Addnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Addnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddnewActionPerformed(evt);
            }
        });

        txt_clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/broom.png"))); // NOI18N
        txt_clean.setText("Làm mới");
        txt_clean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_clean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        txt_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cleanActionPerformed(evt);
            }
        });

        jLabel7.setText("Địa chỉ:");

        txt_IDStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDStudentActionPerformed(evt);
            }
        });

        jLabel8.setText("Mã sinh viên:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_IDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Major, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Addnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txt_clean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_IDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_SchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_Addnew)
                        .addGap(30, 30, 30)
                        .addComponent(btn_Update)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Major, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txt_clean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_FullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FullNameActionPerformed

    private void btn_AddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddnewActionPerformed
        this.AddNew();
    }//GEN-LAST:event_btn_AddnewActionPerformed

    private void txt_IDStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDStudentActionPerformed

    private void txt_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cleanActionPerformed
       this.CleanForm();
    }//GEN-LAST:event_txt_cleanActionPerformed

    private void tab_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_ViewMouseClicked
        row = tab_View.getSelectedRow();
        this.showDetail(row);
        txt_IDStudent.disable();
        txt_Email.disable();
    }//GEN-LAST:event_tab_ViewMouseClicked

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
       this.Delete();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        this.Update();
    }//GEN-LAST:event_btn_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Addnew;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Update;
    private javax.swing.JComboBox<String> cbb_Class;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_View;
    private javax.swing.JTextField txt_Address;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_FullName;
    private javax.swing.JTextField txt_IDStudent;
    private javax.swing.JTextField txt_Major;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_SchoolYear;
    private javax.swing.JButton txt_clean;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Delete() {
        if (txt_IDStudent.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn một đối tượng để xóa!");
            return;
        }
        this.deleteStudent();
        this.loadToTable();
        txt_IDStudent.enable();
    }

    @Override
    public void CleanForm() {
        txt_Address.setText("");
        txt_Email.setText("");
        txt_FullName.setText("");
        txt_IDStudent.setText("");
        txt_Major.setText("");
        txt_Password.setText("");
        txt_SchoolYear.setText("");
        txt_IDStudent.enable();
        txt_Email.enable();
    }

    @Override
    public void LoadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
