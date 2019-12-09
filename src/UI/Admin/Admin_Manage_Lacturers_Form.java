package UI.Admin;

import DAO.ConnectDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_Manage_Lacturers_Form extends javax.swing.JInternalFrame {

    public Admin_Manage_Lacturers_Form() {
        initComponents();
        this.loadToTable();
    }
    ConnectDB connect = new ConnectDB();
    boolean isAddDelete = false;

    public void DeleteLacture() {

        String sql = "exec sp_removeGiangvien N'" + txt_IDLecturers.getText() + "'";
        try {
            connect.UpdateSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa giang viên, Mã lỗi: " + e);
        }

    }

//    public void AddNewLacture() {
//
//        if (txt_IDLecturers.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống mã giảng viên");
//            return;
//        }
//        if (txt_Name.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống Họ Tên");
//            return;
//        }
//        if (txt_email.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống Email");
//            return;
//        }
//        if (txt_Password.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống Mật khẩu");
//            return;
//        }
//        if (txt_Numberphone.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống số điện thoại");
//            return;
//        }
//        if (txt_Address.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống địa chỉ");
//            return;
//        }
//
//        String sql = "exec sp_addGiangvien N'" + txt_IDLecturers.getText() + "', N'" + txt_Name.getText() + "', N'" + txt_Numberphone.getText() + "', N'" + txt_Address.getText() + "', N'" + txt_email.getText() + "', N'" + txt_Password.getText() + "', N'giangvien' ";
//        try {
//            for (int i = 0; i < tab_View.getRowCount(); i++) {
//                if (txt_IDLecturers.getText().equalsIgnoreCase(tab_View.getValueAt(i, 0).toString())) {
//                    JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại!");
//                    return;
//                }
//            }
//            connect.UpdateSQL(sql);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Thêm giải giảng viên lỗi, mã lỗi: 1, Lỗi chi tiết: " + e);
//        }
//    }
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
        for (int i = 0; i < tab_View.getRowCount(); i++) {
            if (txt_IDLecturers.getText().equalsIgnoreCase(tab_View.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại!");
                return false;
            }
        }
        return true;
    }

    public void UpdateLecturers() {
        if (txt_IDLecturers.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn một đối tượng để cập nhật");
            return;
        }
        String sql = "exec sp_removeGiangvien N'" + txt_IDLecturers.getText() + "' ";
        try {
            connect.UpdateSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa giảng viên");
        }
    }

    public void loadToTable() {
        String head[] = {"Mã giảng viên", "Họ và tên", "Email/Tên người dùng", "Mật khẩu", "Số điện thoại", "Địa chỉ"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        String sql = "select Magiangvien, Tengiangvien, Giangvien.Email, Matkhau, Sodienthoai, Diachi from Giangvien  inner join Taikhoan on Giangvien.Email = Taikhoan.Tentaikhoan";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                tablemodel.addRow(data);
            }
            tab_View.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load Combobox" + e);
        }
    }

    int row = -1;

    public void showDetail(int row) {
        txt_IDLecturers.setText(tab_View.getValueAt(row, 0).toString());
        txt_Name.setText(tab_View.getValueAt(row, 1).toString());
        txt_email.setText(tab_View.getValueAt(row, 2).toString());
        txt_Password.setText(tab_View.getValueAt(row, 3).toString());
        txt_Numberphone.setText(tab_View.getValueAt(row, 4).toString());
        txt_Address.setText(tab_View.getValueAt(row, 5).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tab_View = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 2), new java.awt.Dimension(0, 2), new java.awt.Dimension(32767, 2));
        jPanel1 = new javax.swing.JPanel();
        txt_Numberphone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_IDLecturers = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_Delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_Clean = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Addnew = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_Name = new javax.swing.JTextField();
        txt_Address = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setVisible(true);

        tab_View.setBackground(new java.awt.Color(255, 255, 204));
        tab_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã giảng viên", "Họ và tên", "Email/Tên người dùng", "Mật khẩu", "Số điện thoại", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_View);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/reminder.png"))); // NOI18N

        jLabel8.setText("LƯU Ý!");

        jLabel9.setText("Email chính là tài khoản đăng nhập");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel1.setText("Họ và Tên: ");

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/delete.png"))); // NOI18N
        btn_Delete.setText("Xóa");
        btn_Delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel2.setText("Email/Tài khoản:");

        btn_Clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/wiping-swipe-for-floors.png"))); // NOI18N
        btn_Clean.setText("Làm sạch");
        btn_Clean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Clean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CleanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel3.setText("Địa chỉ:");

        btn_Addnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/plus.png"))); // NOI18N
        btn_Addnew.setText("Thêm mới");
        btn_Addnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Addnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddnewActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setText("Mật khẩu:");

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
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(215, 215, 215))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Numberphone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_Clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Addnew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
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
                                .addComponent(jLabel5)
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
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Numberphone, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(txt_Name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel11.setText("Mã giảng viên là duy nhất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(102, 102, 102))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_ViewMouseClicked
        row = tab_View.getSelectedRow();
        showDetail(row);
    }//GEN-LAST:event_tab_ViewMouseClicked

    private void btn_AddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddnewActionPerformed

        if (this.AddNewLacture()) {
            String sql = "exec sp_addGiangvien N'" + txt_IDLecturers.getText() + "', N'" + txt_Name.getText() + "', N'" + txt_Numberphone.getText() + "', N'" + txt_Address.getText() + "', N'" + txt_email.getText() + "', N'" + txt_Password.getText() + "', N'giangvien' ";
            try {
                connect.UpdateSQL(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm giải giảng viên lỗi, mã lỗi: 1, Lỗi chi tiết: " + e);
            }
        }
        this.loadToTable();

    }//GEN-LAST:event_btn_AddnewActionPerformed

    private void btn_CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CleanActionPerformed
        txt_Address.setText("");
        txt_IDLecturers.setText("");
        txt_Name.setText("");
        txt_Numberphone.setText("");
        txt_Password.setText("");
        txt_email.setText("");


    }//GEN-LAST:event_btn_CleanActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        if (txt_IDLecturers.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Chọn một đối tượng để xóa!");
            return;
        }
        DeleteLacture();
        this.loadToTable();
        txt_Address.setText("");
        txt_IDLecturers.setText("");
        txt_Name.setText("");
        txt_Numberphone.setText("");
        txt_Password.setText("");
        txt_email.setText("");

    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void txt_NumberphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumberphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumberphoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Addnew;
    private javax.swing.JButton btn_Clean;
    private javax.swing.JButton btn_Delete;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_View;
    private javax.swing.JTextField txt_Address;
    private javax.swing.JTextField txt_IDLecturers;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_Numberphone;
    private javax.swing.JTextField txt_Password;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
