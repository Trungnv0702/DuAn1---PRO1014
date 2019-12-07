package UI.Lecturers;

import DAO.ConnectDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lecturers_Subject_Management_Form extends javax.swing.JInternalFrame {

    public Lecturers_Subject_Management_Form() {
        initComponents();
        this.loadToTable();
    }

    public boolean checkForm() {
        try {
            if (txt_IDSubject.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không để trống mã môn!");
                return false;
            }
            if (txt_IDSubject.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mã môn!");
                return false;
            }
            if (txt_SubjectName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không để trống tên môn!");
                return false;
            }
            if (txt_SubjectName.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên môn!");
                return false;
            }
            for (int i = 0; i < tbl_view.getRowCount(); i++) {
                if (txt_IDSubject.getText().equalsIgnoreCase(tbl_view.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "mã môn đã tồn tại, hãy chọn mã môn khác!");
                    return false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    public void loadToTable() {
        String head[] = {"Mã môn", "Tên môn"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        String sql = "	select * from mon";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2)};
                tablemodel.addRow(data);
            }
            tbl_view.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load Combobox" + e);
        }
    }

 
    ConnectDB connect = new ConnectDB();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_IDSubject = new javax.swing.JTextField();
        txt_SubjectName = new javax.swing.JTextField();
        btn_Exit = new javax.swing.JButton();
        btn_AddNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_view = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 102));
        setClosable(true);
        setForeground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã môn:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tên môn:");

        txt_SubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SubjectNameActionPerformed(evt);
            }
        });

        btn_Exit.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logouttt.png"))); // NOI18N
        btn_Exit.setText("Thoát");
        btn_Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Exit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        btn_AddNew.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_AddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/add-file (1).png"))); // NOI18N
        btn_AddNew.setText("Thêm");
        btn_AddNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_AddNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddNewActionPerformed(evt);
            }
        });

        tbl_view.setBackground(new java.awt.Color(255, 255, 204));
        tbl_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã môn", "Tên môn"
            }
        ));
        jScrollPane1.setViewportView(tbl_view);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_SubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txt_IDSubject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_AddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_IDSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_AddNew))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btn_Exit)))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddNewActionPerformed
        if (this.checkForm()) {
            try {
                String sql = "exec sp_addMon N'" + txt_IDSubject.getText() + "', N'" + txt_SubjectName.getText() + "' ";
                connect.UpdateSQL(sql);
                loadToTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm môn thất bại, Mã lỗi: " + e);
            }
        }
    }//GEN-LAST:event_btn_AddNewActionPerformed

    private void txt_SubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SubjectNameActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "Thoát chương trình", "Bạn có muốn thoát?", JOptionPane.YES_NO_OPTION);
        if (c == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btn_ExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddNew;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_view;
    private javax.swing.JTextField txt_IDSubject;
    private javax.swing.JTextField txt_SubjectName;
    // End of variables declaration//GEN-END:variables
}
