/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Lecturers;

import DAO.ConnectDB;
import DAO.Interface_Class;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trung
 */
public class Lecturers_Create_Exam_Form extends javax.swing.JInternalFrame implements Interface_Class {

    /**
     * Creates new form Lecturers_Create_Exam_Form
     */
    public Lecturers_Create_Exam_Form() {
        initComponents();
        this.loadDataToCBB();

        this.loadDataTotable();
    }

    public String magiangvien;

    public Lecturers_Create_Exam_Form(String magiangvien) {
        initComponents();
        this.loadDataToCBB();
        this.magiangvien = magiangvien;
        this.loadDataTotable();
    }

    ConnectDB connect = new ConnectDB();
    ResultSet rs;

    public void loadDataTotable() {
        try {
            String head[] = {"Mã kì thi", "Tên kì thi", "Môn", "Người khởi tại"};
            DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
            String sql = "select Makithi,Tenkithi,Mamon,Tengiangvien "
                    + "from Kithi inner join giangvien on Kithi.MaGiangvien = Giangvien.Magiangvien";
            rs = connect.querySQL(sql);
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                tablemodel.addRow(data);
            }
            tbl_Exam.setModel(tablemodel);

        } catch (Exception e) {
        }
    }

    public void loadDataToCBB() {
        try {
            String sql = "select mamon from mon";
            rs = connect.querySQL(sql);
            while (rs.next()) {
                cbb_subject.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }

    public boolean checkForm() {
        try {
            if (txt_makithi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không bỏ trống mã kỳ thi");
                return false;
            }
            for (int i = 0; i < tbl_Exam.getRowCount(); i++) {
                if (txt_makithi.getText().equalsIgnoreCase(tbl_Exam.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "Mã kì thi đã tồn tại!");
                    return false;
                }
            }
            if (txt_makithi.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mã kỳ thi!");
                return false;
            }
            if (txt_tenkithi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không bỏ trống tên kỳ thi");
                return false;
            }
            if (txt_tenkithi.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên kỳ thi!");
                return false;
            }
        } catch (Exception e) {
           
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbb_subject = new javax.swing.JComboBox<>();
        txt_tenkithi = new javax.swing.JTextField();
        txt_makithi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_addnew = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Exam = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("Tên kì thi:");

        jLabel2.setText("Môn thi:");

        jLabel3.setText("Mã kì thi:");

        btn_addnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/add-file (1).png"))); // NOI18N
        btn_addnew.setText("Thêm");
        btn_addnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_addnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addnewActionPerformed(evt);
            }
        });

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/perspective.png"))); // NOI18N
        btn_Delete.setText("Xóa");
        btn_Delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logouttt.png"))); // NOI18N
        btn_exit.setText("Thoát");
        btn_exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_exit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        tbl_Exam.setBackground(new java.awt.Color(255, 255, 204));
        tbl_Exam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã kì thi", "Tên thì thi", "Môn thi", "Người khởi tao"
            }
        ));
        tbl_Exam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ExamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Exam);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/warninggg.png"))); // NOI18N

        jLabel5.setText("Kiểm tra các trường trước khi thêm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(108, 108, 108)
                        .addComponent(txt_makithi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbb_subject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tenkithi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_addnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_addnew)
                        .addGap(45, 45, 45)
                        .addComponent(btn_Delete)
                        .addGap(29, 29, 29)
                        .addComponent(btn_exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_makithi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txt_tenkithi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbb_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addnewActionPerformed
        this.AddNew();
    }//GEN-LAST:event_btn_addnewActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        this.Delete();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void tbl_ExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ExamMouseClicked
        // TODO add your handling code here:
        int row = tbl_Exam.getSelectedRow();
        txt_makithi.setText(tbl_Exam.getValueAt(row, 0).toString());
        txt_tenkithi.setText(tbl_Exam.getValueAt(row, 1).toString());
        cbb_subject.setSelectedItem(tbl_Exam.getValueAt(row, 2));


    }//GEN-LAST:event_tbl_ExamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_addnew;
    private javax.swing.JButton btn_exit;
    private javax.swing.JComboBox<String> cbb_subject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Exam;
    private javax.swing.JTextField txt_makithi;
    private javax.swing.JTextField txt_tenkithi;
    // End of variables declaration//GEN-END:variables

    @Override
    public void AddNew() {
        // TODO add your handling code here:
        if (this.checkForm()) {
            try {
                String sql = "exec sp_addKithi N'" + txt_makithi.getText() + "',N'" + txt_tenkithi.getText() + "',N'" + cbb_subject.getSelectedItem() + "',N'" + magiangvien + "'";
                connect.UpdateSQL(sql);
                JOptionPane.showMessageDialog(this,"thêm thành công");
                this.loadDataTotable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"thêm thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(this,"thêm thất bại");
        }
    }

    @Override
    public void Delete() {
        // TODO add your handling code here:
        try {
            String sql = "exec sp_removeKithi N'" + txt_makithi.getText() + "'";
            connect.UpdateSQL(sql);
            loadDataTotable();
            JOptionPane.showMessageDialog(this,"xóa thành công");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this,"xóa thất bại");
        }
    }

    @Override
    public void CleanForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LoadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
