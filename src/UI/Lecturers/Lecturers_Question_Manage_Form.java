package UI.Lecturers;

import DAO.ConnectDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lecturers_Question_Manage_Form extends javax.swing.JInternalFrame {

    public Lecturers_Question_Manage_Form() {
        initComponents();
        this.loadDatatoCBB();
        this.loadDatatotable();
    }
    int IDquestion = -1;

    ConnectDB connet = new ConnectDB();
    ResultSet rs;

    public boolean checkForm() {
        try {
            if (txt_ContentQuestion.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Không để trống câu hỏi!");
                return false;
            }
            if (txt_ContentQuestion.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng câu hỏi!");
                return false;
            }
            if (txt_Answer1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống đáp án 1!");
                return false;
            }
            if (txt_Answer1.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đáp án!");
                return false;
            }
            if (txt_Answer2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống đáp án 2!");
                return false;
            }
            if (txt_Answer2.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đáp án!");
                return false;
            }
            if (txt_Answer3.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống đáp án 3!");
                return false;
            }
            if (txt_Answer3.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đáp án!");
                return false;
            }
            if (txt_CorrectAnswer.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống đáp án 4!");
                return false;
            }
            if (txt_CorrectAnswer.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đáp án!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    public void loadDatatotable() {
        try {
            String head[] = {"mã câu hỏi", "môn", "Mô tả câu hỏi", "đáp án 1", "đáp án 2", "đáp án 3", "đáp án đúng"};
            DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
            String sql = "select * from Cauhoi";
            rs = connet.querySQL(sql);
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
                tablemodel.addRow(data);
            }
            tab_View.setModel(tablemodel);
        } catch (Exception e) {

        }

    }

    public void loadDatatoCBB() {
        try {
            String sql = "select mamon from mon";
            rs = connet.querySQL(sql);
            while (rs.next()) {
                cbb_Subject.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_CorrectAnswer = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ContentQuestion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_Answer2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_Answer1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_Answer3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        tab_View = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_AddQuestion = new javax.swing.JButton();
        btn_Clean = new javax.swing.JButton();
        cbb_Subject = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_delete1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setClosable(true);
        setForeground(new java.awt.Color(255, 204, 51));
        setTitle("Quản lý câu hỏi");
        setPreferredSize(new java.awt.Dimension(1200, 640));

        jLabel1.setText("Nội dung câu hỏi:");

        jLabel2.setText("Đáp án 1:");

        jLabel3.setText("Đáp án 2:");

        jLabel4.setText("Đáp án 3:");

        txt_CorrectAnswer.setColumns(20);
        txt_CorrectAnswer.setRows(5);
        jScrollPane1.setViewportView(txt_CorrectAnswer);

        jLabel5.setText("Đáp án 4/đáp án đúng:");

        txt_ContentQuestion.setColumns(20);
        txt_ContentQuestion.setRows(5);
        jScrollPane2.setViewportView(txt_ContentQuestion);

        txt_Answer2.setColumns(20);
        txt_Answer2.setRows(5);
        jScrollPane3.setViewportView(txt_Answer2);

        txt_Answer1.setColumns(20);
        txt_Answer1.setRows(5);
        jScrollPane4.setViewportView(txt_Answer1);

        txt_Answer3.setColumns(20);
        txt_Answer3.setRows(5);
        jScrollPane5.setViewportView(txt_Answer3);

        tab_View.setBackground(new java.awt.Color(255, 255, 204));
        tab_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã câu hỏi", "Môn", "Mô tả câu hỏi", "Đáp án 1", "Đáp án 2", "Đáp án 3", "Đáp án đúng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, false, true
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
        jScrollPane6.setViewportView(tab_View);

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/perspective.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
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

        btn_AddQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/add-file (1).png"))); // NOI18N
        btn_AddQuestion.setText("Thêm");
        btn_AddQuestion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_AddQuestion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_AddQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddQuestionActionPerformed(evt);
            }
        });

        btn_Clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/broom.png"))); // NOI18N
        btn_Clean.setText("Làm mới");
        btn_Clean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Clean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CleanActionPerformed(evt);
            }
        });

        cbb_Subject.setMaximumRowCount(12);

        jLabel6.setText("Môn:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/warninggg.png"))); // NOI18N

        jLabel8.setText("Câu trả lời 4 sẽ là đáp án đúng");

        jLabel9.setText("Đáp án sẽ được trộn lẫn ở mỗi đề thi");

        btn_delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logouttt.png"))); // NOI18N
        btn_delete1.setText("Thoát");
        btn_delete1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_delete1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2)
                        .addComponent(cbb_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AddQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Clean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(cbb_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btn_AddQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Clean)
                                .addGap(26, 26, 26)
                                .addComponent(btn_delete)
                                .addGap(27, 27, 27)
                                .addComponent(btn_delete1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddQuestionActionPerformed
        if (this.checkForm()) {
            try {
                String sql = "exec sp_addCauhoi N'" + cbb_Subject.getSelectedItem().toString() + "' ,N'" + txt_ContentQuestion.getText() + "' , N'" + txt_Answer1.getText() + "',N'" + txt_Answer2.getText() + "',N'" + txt_Answer3.getText() + "',N'" + txt_CorrectAnswer.getText() + "'";
                connet.UpdateSQL(sql);
                this.loadDatatotable();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btn_AddQuestionActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        if (IDquestion == -1) {
            JOptionPane.showMessageDialog(this, "Chọn đói tượng cập nhât");
        } else {
            try {
                this.checkForm();
                String sql = (String) "exec sp_updateCauhoi " + IDquestion + ", N'" + cbb_Subject.getSelectedItem().toString() + "',N'" + txt_ContentQuestion.getText() + "' ,N'" + txt_Answer1.getText() + "',N'" + txt_Answer2.getText() + "',N'" + txt_Answer3.getText() + "',N'" + txt_CorrectAnswer.getText() + "'";
                connet.UpdateSQL(sql);
                IDquestion = -1;
                this.loadDatatotable();
//                JOptionPane.showMessageDialog(this, sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }

    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CleanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CleanActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (IDquestion == -1) {
            JOptionPane.showMessageDialog(this, "Chọn đói tượng cập nhât");
        } else {
            try {
                String sql = "exec sp_removeCauhoi " + IDquestion;
                connet.UpdateSQL(sql);
                IDquestion = -1;
                this.loadDatatotable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }


    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tab_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_ViewMouseClicked
        // TODO add your handling code here:
        int row = tab_View.getSelectedRow();
        cbb_Subject.setSelectedItem(tab_View.getValueAt(row, 1));
        txt_ContentQuestion.setText(tab_View.getValueAt(row, 2).toString());
        txt_Answer1.setText(tab_View.getValueAt(row, 3).toString());
        txt_Answer2.setText(tab_View.getValueAt(row, 4).toString());
        txt_Answer3.setText(tab_View.getValueAt(row, 5).toString());
        txt_CorrectAnswer.setText(tab_View.getValueAt(row, 6).toString());
        IDquestion = Integer.parseInt(tab_View.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tab_ViewMouseClicked

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "Thoát?", "Bạn có muốn thoát?", JOptionPane.YES_NO_OPTION);
        if (c == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btn_delete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddQuestion;
    private javax.swing.JButton btn_Clean;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JComboBox<String> cbb_Subject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tab_View;
    private javax.swing.JTextArea txt_Answer1;
    private javax.swing.JTextArea txt_Answer2;
    private javax.swing.JTextArea txt_Answer3;
    private javax.swing.JTextArea txt_ContentQuestion;
    private javax.swing.JTextArea txt_CorrectAnswer;
    // End of variables declaration//GEN-END:variables
}
