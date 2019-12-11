/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Student;

import javax.swing.JOptionPane;
import java.util.*;
import DAO.ConnectDB;
import java.sql.*;
import Model.Question;
import javax.swing.AbstractButton;

/**
 *
 * @author trung
 */
public class Student_Exam_Form extends javax.swing.JFrame {

    /**
     * Creates new form Student_Exam_Form
     */
    public Student_Exam_Form() {
        initComponents();

        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Bài thi");
        jLabel1.setText("Bài kiểm tra");
        btn_Submit.setEnabled(false);

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        seconds++;
                        if (seconds > 60) {
                            seconds = 0;
                            minute++;
                        }
                        if (tbl_Minute.getText().equals("0") && lbl_seconds.getText().equals("0")) {
                            JOptionPane.showMessageDialog(null, "Hết thời gian làm bài");
                            endExam();
                        }
                        lbl_seconds.setText("" + ((60 - seconds)));
                        tbl_Minute.setText("" + ((19 - minute)));
                    } catch (Exception e) {
                    }
                }

            }
        }.start();

    }

    static int minute = 0;
    static int seconds = 0;

    ConnectDB con = new ConnectDB();
    ArrayList<Question> listQS = new ArrayList<>();

    public void endExam() {
        try {

            //câu 1
            for (Enumeration<AbstractButton> buttons = btnGrCH1.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(0).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 2
            for (Enumeration<AbstractButton> buttons = btnGrCH2.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(1).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }

            //câu 3
            for (Enumeration<AbstractButton> buttons = btnGrCH3.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(2).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 4
            for (Enumeration<AbstractButton> buttons = btnGrCH4.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(3).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }

            //câu 5
            for (Enumeration<AbstractButton> buttons = btnGrCH5.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(4).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }

            //câu 6
            for (Enumeration<AbstractButton> buttons = btnGrCH6.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(5).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 7
            for (Enumeration<AbstractButton> buttons = btnGrCH7.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(6).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 8
            for (Enumeration<AbstractButton> buttons = btnGrCH8.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(7).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 9
            for (Enumeration<AbstractButton> buttons = btnGrCH9.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(8).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }
            //câu 10
            for (Enumeration<AbstractButton> buttons = btnGrCH10.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    if (button.getText().equalsIgnoreCase(listQS.get(9).getDapandung())) {
                        diemThi += 1;
                    }

                }
            }

            String sql = "exec sp_addKetqua N'" + lbl_StudentID.getText() + "', " + diemThi + ", N'" + lbl_Exam.getText() + "'";
            con.UpdateSQL(sql);
            Student_ResultExam_Form Result_Exam = new Student_ResultExam_Form();
            Result_Exam.setContent(lbl_Exam.getText(), lbl_Subject.getText(), lbl_StudentName.getText(), lbl_StudentID.getText(), lbl_lecturers.getText(), diemThi);
            this.dispose();
            Result_Exam.show();
//            JOptionPane.showMessageDialog(null, sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void loadQuestion() {
        try {
            String sql = "select  Noidungcauhoi,Dapansai1,Dapansai2,Dapansai3,Dapandung from cauhoi where Mamon = '" + lbl_Subject.getText() + "'\n"
                    + "order by NEWID()";
            ResultSet rs = con.querySQL(sql);
            while (rs.next()) {
                Question qs = new Question();
                qs.setNoidungcauhoi(rs.getString(1));
                qs.setDapansai1(rs.getString(2));
                qs.setDapansai2(rs.getString(3));
                qs.setDapansai3(rs.getString(4));
                qs.setDapandung(rs.getString(5));
                listQS.add(qs);
            }

            Random rd = new Random();
            List ListAsw = new ArrayList();
            for (int i = 0; i < listQS.size(); i++) {
                String a[] = {listQS.get(i).getDapandung(), listQS.get(i).getDapansai1(), listQS.get(i).getDapansai2(), listQS.get(i).getDapansai3()};
                String newA[] = new String[4];
                Vector v = new Vector();
                int iNewNumber = 0;
                for (int j = 0; j < 4; j++) {
                    do {
                        iNewNumber = rd.nextInt(4);
                    } while (v.contains(iNewNumber));
                    v.add(iNewNumber);
                    newA[j] = a[iNewNumber];
                }
                ListAsw.add(newA);
            }

            String c1[] = (String[]) ListAsw.get(0);
            lbl_Ques1.setText(listQS.get(0).getNoidungcauhoi());
            rdo_quest1_A.setText(c1[0]);
            rdo_quest1_B.setText(c1[1]);
            rdo_quest1_C.setText(c1[2]);
            rdo_quest1_D.setText(c1[3]);

            String c2[] = (String[]) ListAsw.get(1);
            lbl_Ques2.setText(listQS.get(1).getNoidungcauhoi());
            rdo_quest2_A.setText(c2[0]);
            rdo_quest2_B.setText(c2[1]);
            rdo_quest2_C.setText(c2[2]);
            rdo_quest2_D.setText(c2[3]);

            String c3[] = (String[]) ListAsw.get(2);
            lbl_Ques3.setText(listQS.get(2).getNoidungcauhoi());
            rdo_quest3_A.setText(c3[0]);
            rdo_quest3_B.setText(c3[1]);
            rdo_quest3_C.setText(c3[2]);
            rdo_quest3_D.setText(c3[3]);

            String c4[] = (String[]) ListAsw.get(3);
            lbl_Ques4.setText(listQS.get(3).getNoidungcauhoi());
            rdo_quest4_A.setText(c4[0]);
            rdo_quest4_B.setText(c4[1]);
            rdo_quest4_C.setText(c4[2]);
            rdo_quest4_D.setText(c4[3]);

            String c5[] = (String[]) ListAsw.get(4);
            lbl_Ques5.setText(listQS.get(4).getNoidungcauhoi());
            rdo_quest5_A.setText(c5[0]);
            rdo_quest5_B.setText(c5[1]);
            rdo_quest5_C.setText(c5[2]);
            rdo_quest5_D.setText(c5[3]);

            String c6[] = (String[]) ListAsw.get(5);
            lbl_Ques6.setText(listQS.get(5).getNoidungcauhoi());
            rdo_quest6_A.setText(c6[0]);
            rdo_quest6_B.setText(c6[1]);
            rdo_quest6_C.setText(c6[2]);
            rdo_quest6_D.setText(c6[3]);

            String c7[] = (String[]) ListAsw.get(6);
            lbl_Ques7.setText(listQS.get(6).getNoidungcauhoi());
            rdo_quest7_A.setText(c7[0]);
            rdo_quest7_B.setText(c7[1]);
            rdo_quest7_C.setText(c7[2]);
            rdo_quest7_D.setText(c7[3]);

            String c8[] = (String[]) ListAsw.get(7);
            lbl_Ques8.setText(listQS.get(7).getNoidungcauhoi());
            rdo_quest8_A.setText(c8[0]);
            rdo_quest8_B.setText(c8[1]);
            rdo_quest8_C.setText(c8[2]);
            rdo_quest8_D.setText(c8[3]);

            String c9[] = (String[]) ListAsw.get(8);
            lbl_Ques9.setText(listQS.get(8).getNoidungcauhoi());
            rdo_quest9_A.setText(c9[0]);
            rdo_quest9_B.setText(c9[1]);
            rdo_quest9_C.setText(c9[2]);
            rdo_quest9_D.setText(c9[3]);

            String c10[] = (String[]) ListAsw.get(9);
            lbl_Ques10.setText(listQS.get(9).getNoidungcauhoi());
            rdo_quest10_A.setText(c10[0]);
            rdo_quest10_B.setText(c10[1]);
            rdo_quest10_C.setText(c10[2]);
            rdo_quest10_D.setText(c10[3]);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void setTitle(String NameExam, String Lecturers, String Subject, String nameStudent, String id) {
        lbl_Exam.setText(NameExam);
        lbl_lecturers.setText(Lecturers);
        lbl_Subject.setText(Subject);
        lbl_StudentID.setText(id);
        lbl_StudentName.setText(nameStudent);
        this.loadQuestion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrCH1 = new javax.swing.ButtonGroup();
        btnGrCH2 = new javax.swing.ButtonGroup();
        btnGrCH3 = new javax.swing.ButtonGroup();
        btnGrCH4 = new javax.swing.ButtonGroup();
        btnGrCH5 = new javax.swing.ButtonGroup();
        btnGrCH6 = new javax.swing.ButtonGroup();
        btnGrCH7 = new javax.swing.ButtonGroup();
        btnGrCH8 = new javax.swing.ButtonGroup();
        btnGrCH9 = new javax.swing.ButtonGroup();
        btnGrCH10 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_Ques1 = new javax.swing.JLabel();
        rdo_quest1_A = new javax.swing.JRadioButton();
        rdo_quest1_B = new javax.swing.JRadioButton();
        rdo_quest1_C = new javax.swing.JRadioButton();
        rdo_quest1_D = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_Ques2 = new javax.swing.JLabel();
        rdo_quest2_A = new javax.swing.JRadioButton();
        rdo_quest2_B = new javax.swing.JRadioButton();
        rdo_quest2_C = new javax.swing.JRadioButton();
        rdo_quest2_D = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_Ques3 = new javax.swing.JLabel();
        rdo_quest3_A = new javax.swing.JRadioButton();
        rdo_quest3_B = new javax.swing.JRadioButton();
        rdo_quest3_C = new javax.swing.JRadioButton();
        rdo_quest3_D = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbl_Ques4 = new javax.swing.JLabel();
        rdo_quest4_A = new javax.swing.JRadioButton();
        rdo_quest4_B = new javax.swing.JRadioButton();
        rdo_quest4_C = new javax.swing.JRadioButton();
        rdo_quest4_D = new javax.swing.JRadioButton();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbl_Ques5 = new javax.swing.JLabel();
        rdo_quest5_A = new javax.swing.JRadioButton();
        rdo_quest5_B = new javax.swing.JRadioButton();
        rdo_quest5_C = new javax.swing.JRadioButton();
        rdo_quest5_D = new javax.swing.JRadioButton();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lbl_Ques6 = new javax.swing.JLabel();
        rdo_quest6_A = new javax.swing.JRadioButton();
        rdo_quest6_B = new javax.swing.JRadioButton();
        rdo_quest6_C = new javax.swing.JRadioButton();
        rdo_quest6_D = new javax.swing.JRadioButton();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lbl_Ques7 = new javax.swing.JLabel();
        rdo_quest7_A = new javax.swing.JRadioButton();
        rdo_quest7_B = new javax.swing.JRadioButton();
        rdo_quest7_C = new javax.swing.JRadioButton();
        rdo_quest7_D = new javax.swing.JRadioButton();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbl_Ques9 = new javax.swing.JLabel();
        rdo_quest9_A = new javax.swing.JRadioButton();
        rdo_quest9_B = new javax.swing.JRadioButton();
        rdo_quest9_C = new javax.swing.JRadioButton();
        rdo_quest9_D = new javax.swing.JRadioButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lbl_Ques8 = new javax.swing.JLabel();
        rdo_quest8_A = new javax.swing.JRadioButton();
        rdo_quest8_B = new javax.swing.JRadioButton();
        rdo_quest8_C = new javax.swing.JRadioButton();
        rdo_quest8_D = new javax.swing.JRadioButton();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lbl_Ques10 = new javax.swing.JLabel();
        rdo_quest10_A = new javax.swing.JRadioButton();
        rdo_quest10_B = new javax.swing.JRadioButton();
        rdo_quest10_C = new javax.swing.JRadioButton();
        rdo_quest10_D = new javax.swing.JRadioButton();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tbl_Minute = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_seconds = new javax.swing.JLabel();
        tbl_Minute1 = new javax.swing.JLabel();
        tbl_Minute2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ckb_finish = new javax.swing.JCheckBox();
        btn_Submit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        lbl_Subject = new javax.swing.JLabel();
        lbl_Exam = new javax.swing.JLabel();
        lbl_lecturers = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_StudentName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_StudentID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Câu 1:");

        lbl_Ques1.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH1.add(rdo_quest1_A);
        rdo_quest1_A.setText("jRadioButton1");

        btnGrCH1.add(rdo_quest1_B);
        rdo_quest1_B.setText("jRadioButton1");

        btnGrCH1.add(rdo_quest1_C);
        rdo_quest1_C.setText("jRadioButton1");

        btnGrCH1.add(rdo_quest1_D);
        rdo_quest1_D.setText("jRadioButton1");
        rdo_quest1_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest1_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest1_D)
                            .addComponent(rdo_quest1_C)
                            .addComponent(rdo_quest1_B)
                            .addComponent(rdo_quest1_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest1_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest1_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest1_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdo_quest1_D)
                .addGap(15, 15, 15))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Câu 2:");

        lbl_Ques2.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH2.add(rdo_quest2_A);
        rdo_quest2_A.setText("jRadioButton1");

        btnGrCH2.add(rdo_quest2_B);
        rdo_quest2_B.setText("jRadioButton1");

        btnGrCH2.add(rdo_quest2_C);
        rdo_quest2_C.setText("jRadioButton1");

        btnGrCH2.add(rdo_quest2_D);
        rdo_quest2_D.setText("jRadioButton1");
        rdo_quest2_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest2_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest2_D)
                            .addComponent(rdo_quest2_C)
                            .addComponent(rdo_quest2_B)
                            .addComponent(rdo_quest2_A))
                        .addGap(0, 566, Short.MAX_VALUE))
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest2_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest2_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest2_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdo_quest2_D)
                .addGap(15, 15, 15))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Câu 3:");

        lbl_Ques3.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH3.add(rdo_quest3_A);
        rdo_quest3_A.setText("jRadioButton1");

        btnGrCH3.add(rdo_quest3_B);
        rdo_quest3_B.setText("jRadioButton1");

        btnGrCH3.add(rdo_quest3_C);
        rdo_quest3_C.setText("jRadioButton1");

        btnGrCH3.add(rdo_quest3_D);
        rdo_quest3_D.setText("jRadioButton1");
        rdo_quest3_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest3_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest3_D)
                            .addComponent(rdo_quest3_C)
                            .addComponent(rdo_quest3_B)
                            .addComponent(rdo_quest3_A))
                        .addGap(0, 566, Short.MAX_VALUE))
                    .addComponent(jSeparator5))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest3_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest3_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest3_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdo_quest3_D)
                .addGap(15, 15, 15))
        );

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Câu 4:");

        lbl_Ques4.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH4.add(rdo_quest4_A);
        rdo_quest4_A.setText("jRadioButton1");

        btnGrCH4.add(rdo_quest4_B);
        rdo_quest4_B.setText("jRadioButton1");

        btnGrCH4.add(rdo_quest4_C);
        rdo_quest4_C.setText("jRadioButton1");

        btnGrCH4.add(rdo_quest4_D);
        rdo_quest4_D.setText("jRadioButton1");
        rdo_quest4_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest4_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest4_D)
                            .addComponent(rdo_quest4_C)
                            .addComponent(rdo_quest4_B)
                            .addComponent(rdo_quest4_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator6))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest4_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest4_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest4_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdo_quest4_D)
                .addGap(15, 15, 15))
        );

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setText("Câu 5:");

        lbl_Ques5.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH5.add(rdo_quest5_A);
        rdo_quest5_A.setText("jRadioButton1");

        btnGrCH5.add(rdo_quest5_B);
        rdo_quest5_B.setText("jRadioButton1");

        btnGrCH5.add(rdo_quest5_C);
        rdo_quest5_C.setText("jRadioButton1");

        btnGrCH5.add(rdo_quest5_D);
        rdo_quest5_D.setText("jRadioButton1");
        rdo_quest5_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest5_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest5_D)
                            .addComponent(rdo_quest5_C)
                            .addComponent(rdo_quest5_B)
                            .addComponent(rdo_quest5_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator7))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest5_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest5_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest5_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest5_D)
                .addGap(15, 15, 15))
        );

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setText("Câu 6:");

        lbl_Ques6.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques6, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH6.add(rdo_quest6_A);
        rdo_quest6_A.setText("jRadioButton1");
        rdo_quest6_A.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGrCH6.add(rdo_quest6_B);
        rdo_quest6_B.setText("jRadioButton1");
        rdo_quest6_B.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGrCH6.add(rdo_quest6_C);
        rdo_quest6_C.setText("jRadioButton1");
        rdo_quest6_C.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGrCH6.add(rdo_quest6_D);
        rdo_quest6_D.setText("jRadioButton1");
        rdo_quest6_D.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdo_quest6_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest6_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest6_D)
                            .addComponent(rdo_quest6_C)
                            .addComponent(rdo_quest6_B)
                            .addComponent(rdo_quest6_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator8))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest6_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest6_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest6_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest6_D)
                .addGap(15, 15, 15))
        );

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("Câu 7:");

        lbl_Ques7.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques7, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH7.add(rdo_quest7_A);
        rdo_quest7_A.setText("jRadioButton1");

        btnGrCH7.add(rdo_quest7_B);
        rdo_quest7_B.setText("jRadioButton1");

        btnGrCH7.add(rdo_quest7_C);
        rdo_quest7_C.setText("jRadioButton1");

        btnGrCH7.add(rdo_quest7_D);
        rdo_quest7_D.setText("jRadioButton1");
        rdo_quest7_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest7_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest7_D)
                            .addComponent(rdo_quest7_C)
                            .addComponent(rdo_quest7_B)
                            .addComponent(rdo_quest7_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator9))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest7_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest7_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest7_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest7_D)
                .addGap(15, 15, 15))
        );

        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setText("Câu 9:");

        lbl_Ques9.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques9, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH9.add(rdo_quest9_A);
        rdo_quest9_A.setText("jRadioButton1");

        btnGrCH9.add(rdo_quest9_B);
        rdo_quest9_B.setText("jRadioButton1");

        btnGrCH9.add(rdo_quest9_C);
        rdo_quest9_C.setText("jRadioButton1");

        btnGrCH9.add(rdo_quest9_D);
        rdo_quest9_D.setText("jRadioButton1");
        rdo_quest9_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest9_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest9_D)
                            .addComponent(rdo_quest9_C)
                            .addComponent(rdo_quest9_B)
                            .addComponent(rdo_quest9_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator10))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest9_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest9_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest9_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest9_D)
                .addGap(15, 15, 15))
        );

        jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setText("Câu 8:");

        lbl_Ques8.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques8, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH8.add(rdo_quest8_A);
        rdo_quest8_A.setText("jRadioButton1");

        btnGrCH8.add(rdo_quest8_B);
        rdo_quest8_B.setText("jRadioButton1");

        btnGrCH8.add(rdo_quest8_C);
        rdo_quest8_C.setText("jRadioButton1");

        btnGrCH8.add(rdo_quest8_D);
        rdo_quest8_D.setText("jRadioButton1");
        rdo_quest8_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest8_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest8_D)
                            .addComponent(rdo_quest8_C)
                            .addComponent(rdo_quest8_B)
                            .addComponent(rdo_quest8_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator11))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest8_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest8_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(rdo_quest8_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdo_quest8_D)
                .addGap(15, 15, 15))
        );

        jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setText("Câu 10:");

        lbl_Ques10.setText("Chỗ này để load câu hỏi lên nè1");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Ques10, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Ques10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btnGrCH10.add(rdo_quest10_A);
        rdo_quest10_A.setText("jRadioButton1");

        btnGrCH10.add(rdo_quest10_B);
        rdo_quest10_B.setText("jRadioButton1");

        btnGrCH10.add(rdo_quest10_C);
        rdo_quest10_C.setText("jRadioButton1");

        btnGrCH10.add(rdo_quest10_D);
        rdo_quest10_D.setText("jRadioButton1");
        rdo_quest10_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_quest10_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_quest10_D)
                            .addComponent(rdo_quest10_C)
                            .addComponent(rdo_quest10_B)
                            .addComponent(rdo_quest10_A))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator12))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rdo_quest10_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest10_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest10_C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(rdo_quest10_D)
                .addGap(15, 15, 15))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Thí sinh không được sử dụng tài liệu - Giáo viên không giải thích gì thêm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(231, 153, 64));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("BÀI KIỂM TRA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Môn:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Giảng viên coi thi:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Kì thi:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Thời gian làm bài:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("THỜI GIAN CÒN LẠI");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/clock (3).png"))); // NOI18N

        tbl_Minute.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tbl_Minute.setText("00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText(":");

        lbl_seconds.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_seconds.setText("00");

        tbl_Minute1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_Minute1.setText("Phút");

        tbl_Minute2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_Minute2.setText("Giây");

        ckb_finish.setText("Kết thúc bài kiểm tra?");
        ckb_finish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ckb_finishMouseClicked(evt);
            }
        });
        ckb_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_finishActionPerformed(evt);
            }
        });

        btn_Submit.setBackground(new java.awt.Color(255, 255, 102));
        btn_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/Plane-512 copy.png"))); // NOI18N
        btn_Submit.setText("KẾT THÚC");
        btn_Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Submit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("35 phút");

        lbl_Subject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Subject.setText("ABC");

        lbl_Exam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Exam.setText("ABC");

        lbl_lecturers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_lecturers.setText("ABC");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Sinh viên");

        lbl_StudentName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_StudentName.setText("ABC");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Mã sinh viên");

        lbl_StudentID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_StudentID.setText("ABC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Exam, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tbl_Minute)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbl_Minute1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_seconds)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbl_Minute2))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_lecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(ckb_finish)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_Subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_Exam, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(lbl_StudentName))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbl_StudentID))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_lecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbl_Minute)
                    .addComponent(jLabel11)
                    .addComponent(lbl_seconds)
                    .addComponent(tbl_Minute1)
                    .addComponent(tbl_Minute2))
                .addGap(84, 84, 84)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(ckb_finish)
                .addGap(18, 18, 18)
                .addComponent(btn_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_quest1_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest1_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest1_DActionPerformed

    private void ckb_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_finishActionPerformed


    }//GEN-LAST:event_ckb_finishActionPerformed

    private void ckb_finishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ckb_finishMouseClicked
        if (ckb_finish.isSelected()) {
            btn_Submit.setEnabled(true);
        } else if (ckb_finish.isSelected() == false) {
            btn_Submit.setEnabled(false);
        }
    }//GEN-LAST:event_ckb_finishMouseClicked

    private void rdo_quest2_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest2_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest2_DActionPerformed

    private void rdo_quest3_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest3_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest3_DActionPerformed

    private void rdo_quest4_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest4_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest4_DActionPerformed

    private void rdo_quest5_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest5_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest5_DActionPerformed

    private void btn_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitActionPerformed
        endExam();
    }//GEN-LAST:event_btn_SubmitActionPerformed

    private void rdo_quest6_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest6_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest6_DActionPerformed

    private void rdo_quest7_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest7_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest7_DActionPerformed

    private void rdo_quest9_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest9_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest9_DActionPerformed

    private void rdo_quest8_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest8_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest8_DActionPerformed

    private void rdo_quest10_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_quest10_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_quest10_DActionPerformed
    static double diemThi = 0;

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
            java.util.logging.Logger.getLogger(Student_Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Exam_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrCH1;
    private javax.swing.ButtonGroup btnGrCH10;
    private javax.swing.ButtonGroup btnGrCH2;
    private javax.swing.ButtonGroup btnGrCH3;
    private javax.swing.ButtonGroup btnGrCH4;
    private javax.swing.ButtonGroup btnGrCH5;
    private javax.swing.ButtonGroup btnGrCH6;
    private javax.swing.ButtonGroup btnGrCH7;
    private javax.swing.ButtonGroup btnGrCH8;
    private javax.swing.ButtonGroup btnGrCH9;
    private javax.swing.JButton btn_Submit;
    private javax.swing.JCheckBox ckb_finish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbl_Exam;
    private javax.swing.JLabel lbl_Ques1;
    private javax.swing.JLabel lbl_Ques10;
    private javax.swing.JLabel lbl_Ques2;
    private javax.swing.JLabel lbl_Ques3;
    private javax.swing.JLabel lbl_Ques4;
    private javax.swing.JLabel lbl_Ques5;
    private javax.swing.JLabel lbl_Ques6;
    private javax.swing.JLabel lbl_Ques7;
    private javax.swing.JLabel lbl_Ques8;
    private javax.swing.JLabel lbl_Ques9;
    private javax.swing.JLabel lbl_StudentID;
    private javax.swing.JLabel lbl_StudentName;
    private javax.swing.JLabel lbl_Subject;
    private javax.swing.JLabel lbl_lecturers;
    private javax.swing.JLabel lbl_seconds;
    private javax.swing.JRadioButton rdo_quest10_A;
    private javax.swing.JRadioButton rdo_quest10_B;
    private javax.swing.JRadioButton rdo_quest10_C;
    private javax.swing.JRadioButton rdo_quest10_D;
    private javax.swing.JRadioButton rdo_quest1_A;
    private javax.swing.JRadioButton rdo_quest1_B;
    private javax.swing.JRadioButton rdo_quest1_C;
    private javax.swing.JRadioButton rdo_quest1_D;
    private javax.swing.JRadioButton rdo_quest2_A;
    private javax.swing.JRadioButton rdo_quest2_B;
    private javax.swing.JRadioButton rdo_quest2_C;
    private javax.swing.JRadioButton rdo_quest2_D;
    private javax.swing.JRadioButton rdo_quest3_A;
    private javax.swing.JRadioButton rdo_quest3_B;
    private javax.swing.JRadioButton rdo_quest3_C;
    private javax.swing.JRadioButton rdo_quest3_D;
    private javax.swing.JRadioButton rdo_quest4_A;
    private javax.swing.JRadioButton rdo_quest4_B;
    private javax.swing.JRadioButton rdo_quest4_C;
    private javax.swing.JRadioButton rdo_quest4_D;
    private javax.swing.JRadioButton rdo_quest5_A;
    private javax.swing.JRadioButton rdo_quest5_B;
    private javax.swing.JRadioButton rdo_quest5_C;
    private javax.swing.JRadioButton rdo_quest5_D;
    private javax.swing.JRadioButton rdo_quest6_A;
    private javax.swing.JRadioButton rdo_quest6_B;
    private javax.swing.JRadioButton rdo_quest6_C;
    private javax.swing.JRadioButton rdo_quest6_D;
    private javax.swing.JRadioButton rdo_quest7_A;
    private javax.swing.JRadioButton rdo_quest7_B;
    private javax.swing.JRadioButton rdo_quest7_C;
    private javax.swing.JRadioButton rdo_quest7_D;
    private javax.swing.JRadioButton rdo_quest8_A;
    private javax.swing.JRadioButton rdo_quest8_B;
    private javax.swing.JRadioButton rdo_quest8_C;
    private javax.swing.JRadioButton rdo_quest8_D;
    private javax.swing.JRadioButton rdo_quest9_A;
    private javax.swing.JRadioButton rdo_quest9_B;
    private javax.swing.JRadioButton rdo_quest9_C;
    private javax.swing.JRadioButton rdo_quest9_D;
    private javax.swing.JLabel tbl_Minute;
    private javax.swing.JLabel tbl_Minute1;
    private javax.swing.JLabel tbl_Minute2;
    // End of variables declaration//GEN-END:variables
}
