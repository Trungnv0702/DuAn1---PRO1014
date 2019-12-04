/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Lecturers;

import DAO.ConnectDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrinhNgocQuang
 */
public class Lecturers_Statistics_Form extends javax.swing.JInternalFrame {

    public Lecturers_Statistics_Form() {
        initComponents();
        this.loadDataToCombobox();
    }
    String sql;
    ConnectDB connect = new ConnectDB();

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

    public void clearTable() {
        DefaultTableModel m = (DefaultTableModel) tbl_View.getModel();
        m.getDataVector().removeAllElements();
    }

    public void fillToTable() {
        ConnectDB conDB = new ConnectDB();
        String head[] = {"Mã sinh viên", "Tên sinh viên", "Tên kỳ thi", "Điểm", "Mã lớp", "Ngành", "Khóa"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        try {
            ResultSet rs = conDB.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
                tablemodel.addRow(data);
            }
            tbl_View.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "fill to table" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbb_Class = new javax.swing.JComboBox<>();
        btn_View = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_View = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbb_Order = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        btn_View.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_View.setText("Xem");
        btn_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewActionPerformed(evt);
            }
        });

        tbl_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Tên kỳ thi", "Điểm", "Mã lớp", "Ngành", "Khóa"
            }
        ));
        jScrollPane1.setViewportView(tbl_View);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Bảng thống kê kết quả");

        cbb_Order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cao đến thấp", "Thấp đến cao" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Lớp :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Thứ tự :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbb_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_View)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_Class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(btn_View))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbb_Order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewActionPerformed
        String desc = "Cao đến thấp";
        String asc = "Thấp đến cao";

        if (cbb_Order.getSelectedItem().toString().equals(desc)) {
            sql = "select Sinhvien.Masinhvien,Tensinhvien,Tenkithi,Diem,Malop,Nganh,Khoa\n"
                    + "from Sinhvien left join Ketqua \n"
                    + "on Sinhvien.Masinhvien = Ketqua.Masinhvien\n"
                    + "left join Kithi\n"
                    + "on Kithi.Makithi = Ketqua.Makithi\n"
                    + "where Malop = " + "'" + cbb_Class.getSelectedItem().toString() + "'"
                    + "order by Diem desc";
            this.clearTable();
            this.fillToTable();
            return;
        }
        if (cbb_Order.getSelectedItem().toString().equals(asc)) {
            sql = "select Sinhvien.Masinhvien,Tensinhvien,Tenkithi,Diem,Malop,Nganh,Khoa\n"
                    + "from Sinhvien left join Ketqua \n"
                    + "on Sinhvien.Masinhvien = Ketqua.Masinhvien\n"
                    + "left join Kithi\n"
                    + "on Kithi.Makithi = Ketqua.Makithi\n"
                    + "where Malop = " + "'" + cbb_Class.getSelectedItem().toString() + "'"
                    + "order by Diem asc";
            this.clearTable();
            this.fillToTable();
            return;
        }
        
    }//GEN-LAST:event_btn_ViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_View;
    private javax.swing.JComboBox<String> cbb_Class;
    private javax.swing.JComboBox<String> cbb_Order;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_View;
    // End of variables declaration//GEN-END:variables
}
