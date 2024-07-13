/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AttendanceEmployee;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author ariel
 */
public class panelAttendance extends javax.swing.JPanel {

    Connection conn = null;
    static ResultSet st = null;
    static PreparedStatement ps = null;

    String absen;
    
    DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String currentDate = LocalDate.now().format(dFormat);
    
    /**
     * Creates new form panelAddemp
     */
    public panelAttendance() {
        initComponents();
        conn = MyConnection.getConnection();
        showTable1();
        this.getDate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public static void showTable1() {
        DefaultTableModel sb = new DefaultTableModel();

        sb.addColumn("ID");
        sb.addColumn("Fitst name");
        sb.addColumn("Last name");
        sb.addColumn("Department");
        sb.addColumn("Desiqnation");
        sb.addColumn("Attendance");
        sb.addColumn("Date");
        sb.addColumn("Time");
        tblEmp1.setModel(sb);

        ArrayList<String> srno = new ArrayList<>();
        ArrayList<String> absen = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();

        try {
            ps = MyConnection.getConnection().prepareStatement("SELECT srno,absen,date,time FROM emp_abs");
            st = ps.executeQuery();

            while (st.next()) {
                srno.add(st.getString("srno"));
                absen.add(st.getString("absen"));
                date.add(st.getString("date"));
                time.add(st.getString("time"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        for(int i = 0; i < srno.size(); i++){
            Vector<String> row = new Vector<>();
            
            try {
                ps = MyConnection.getConnection().prepareStatement("SELECT srno,fname,lname,department,designation FROM emp_list WHERE srno = ?");
                ps.setString(1, srno.get(i));
                st = ps.executeQuery();
                
                while (st.next()) {
                    
                    row.add(srno.get(i));
                    row.add(st.getString("fname"));
                    row.add(st.getString("lname"));
                    row.add(st.getString("department"));
                    row.add(st.getString("designation"));
                    row.add(absen.get(i));
                    row.add(date.get(i));
                    row.add(time.get(i));
                    
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            sb.addRow(row);
        }
    }
    
    public static void showTable1(String currentDate) {
        DefaultTableModel sb = new DefaultTableModel();

        sb.addColumn("ID");
        sb.addColumn("Fitst name");
        sb.addColumn("Last name");
        sb.addColumn("Department");
        sb.addColumn("Desiqnation");
        sb.addColumn("Attendance");
        sb.addColumn("Date");
        sb.addColumn("Time");
        tblEmp1.setModel(sb);

        ArrayList<String> srno = new ArrayList<>();
        ArrayList<String> absen = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();

        try {
            ps = MyConnection.getConnection().prepareStatement("SELECT srno,absen,date,time FROM emp_abs WHERE date = ?");
            ps.setString(1, currentDate);
            st = ps.executeQuery();

            while (st.next()) {
                srno.add(st.getString("srno"));
                absen.add(st.getString("absen"));
                date.add(st.getString("date"));
                time.add(st.getString("time"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        for(int i = 0; i < srno.size(); i++){
            Vector<String> row = new Vector<>();
            
            try {
                ps = MyConnection.getConnection().prepareStatement("SELECT srno,fname,lname,department,designation FROM emp_list WHERE srno = ?");
                ps.setString(1, srno.get(i));
                st = ps.executeQuery();
                
                while (st.next()) {
                    
                    row.add(srno.get(i));
                    row.add(st.getString("fname"));
                    row.add(st.getString("lname"));
                    row.add(st.getString("department"));
                    row.add(st.getString("designation"));
                    row.add(absen.get(i));
                    row.add(date.get(i));
                    row.add(time.get(i));
                    
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            sb.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")

    void reset() {
        txtSearch3.setText("");
        txtFname3.setText("");
        r_Permission.setSelected(false);
        r_Attendance.setSelected(false);
        r_Sick.setSelected(false);
        r_Paidleave.setSelected(false);
    }
    
    void getDate() {
        
        ArrayList<String> date = new ArrayList<>();
        
        txtDate.removeAllItems();
        
        String d = null;
        
        try {
            String sql = "SELECT date FROM emp_abs";
            ps = MyConnection.getConnection().prepareStatement(sql);
            st = ps.executeQuery();
            
            while (st.next()) {
                
                String dd = st.getString("date");
                String hariIni = "Hari ini";
                
                if (dd.equals(currentDate)) {
                    dd = hariIni;
                }
                
//                if (d == null || !d.equals(dd)) {
                    date.add(dd);
//                    d = dd;
//                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        date = Sorting.removeDuplicates(date);
        
        Collections.reverse(date);
        
        for (String i: date)
        {
            txtDate.addItem(i);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        r_Permission = new javax.swing.JRadioButton();
        txtSearch3 = new javax.swing.JTextField();
        r_Attendance = new javax.swing.JRadioButton();
        r_Paidleave = new javax.swing.JRadioButton();
        r_Sick = new javax.swing.JRadioButton();
        txtFname3 = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp1 = new javax.swing.JTable();
        txtDate = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(1200, 730));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Attendance");

        r_Permission.setBackground(new java.awt.Color(153, 153, 153));
        r_Permission.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Permission.setText("Izin");
        r_Permission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_PermissionActionPerformed(evt);
            }
        });

        txtSearch3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtSearch3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch3FocusLost(evt);
            }
        });
        txtSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch3ActionPerformed(evt);
            }
        });
        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch3KeyPressed(evt);
            }
        });

        r_Attendance.setBackground(new java.awt.Color(153, 153, 153));
        r_Attendance.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Attendance.setText("Hadir");
        r_Attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_AttendanceActionPerformed(evt);
            }
        });

        r_Paidleave.setBackground(new java.awt.Color(153, 153, 153));
        r_Paidleave.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Paidleave.setText("Cuti");
        r_Paidleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_PaidleaveActionPerformed(evt);
            }
        });

        r_Sick.setBackground(new java.awt.Color(153, 153, 153));
        r_Sick.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Sick.setText("Sakit");
        r_Sick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_SickActionPerformed(evt);
            }
        });

        txtFname3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N

        btnSubmit.setBackground(new java.awt.Color(153, 153, 153));
        btnSubmit.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel4.setText("Search ID/Username :");

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel5.setText("Name Employe");

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel6.setText("Status");

        tblEmp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tblEmp1);

        txtDate.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtDateItemStateChanged(evt);
            }
        });
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFname3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(r_Attendance)
                                            .addComponent(jLabel6)
                                            .addComponent(r_Permission))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(r_Sick)
                                            .addComponent(r_Paidleave)))
                                    .addComponent(txtDate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(802, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_Permission)
                            .addComponent(r_Sick))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_Attendance)
                            .addComponent(r_Paidleave))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFname3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearch3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusGained
        // TODO add your handling code here:
        if (txtSearch3.getText().trim().equals("Enter Employe Id to Search")) {
            txtSearch3.setText("");
        }
    }//GEN-LAST:event_txtSearch3FocusGained

    private void txtSearch3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusLost
        // TODO add your handling code here:
        if (txtSearch3.getText().trim().equals("")) {
            txtSearch3.setText(" Enter Employe Id/Username to Search...");
            txtFname3.setText("");
            r_Permission.setSelected(false);
            r_Attendance.setSelected(false);
            r_Sick.setSelected(false);
            r_Paidleave.setSelected(false);
        }
    }//GEN-LAST:event_txtSearch3FocusLost

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtSearch3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String sql = "select * from emp_list where srno = ? or fname like '%" + txtSearch3.getText() + "%'";
                ps = conn.prepareStatement(sql);
                ps.setString(1, txtSearch3.getText());
                st = ps.executeQuery();
                if (st.next()) {
                    txtFname3.setText(st.getString(2));
                    if (st.getString(9).equals("Permission")) {
                        r_Permission.setSelected(true);
                        r_Attendance.setSelected(false);
                        r_Sick.setSelected(false);
                        r_Paidleave.setSelected(false);
                    } else if (st.getString(9).equals("Attendance")) {
                        r_Permission.setSelected(false);
                        r_Attendance.setSelected(true);
                        r_Sick.setSelected(false);
                        r_Paidleave.setSelected(false);
                    } else if (st.getString(9).equals("Sick")) {
                        r_Permission.setSelected(false);
                        r_Attendance.setSelected(false);
                        r_Sick.setSelected(true);
                        r_Paidleave.setSelected(false);
                    } else if (st.getString(9).equals("Paid - leave")) {
                        r_Permission.setSelected(false);
                        r_Attendance.setSelected(false);
                        r_Sick.setSelected(false);
                        r_Paidleave.setSelected(true);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_txtSearch3KeyPressed

    private void r_PaidleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_PaidleaveActionPerformed
        // TODO add your handling code here:
        absen = "Cuti";
        r_Permission.setSelected(false);
        r_Attendance.setSelected(false);
        r_Sick.setSelected(false);
        r_Paidleave.setSelected(true);
    }//GEN-LAST:event_r_PaidleaveActionPerformed

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String value1 = txtSearch3.getText();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter tFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String d = date.format(dFormat);
        String t = time.format(tFormat);
        int p = JOptionPane.showConfirmDialog(null, "Are you sure?", "Submit record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {
                String sql = "INSERT INTO `emp_abs` (`srno`,`absen`, `date`, `time`) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, value1);
                ps.setString(2, absen);
                ps.setString(3, d);
                ps.setString(4, t);
                ps.execute();
                JOptionPane.showMessageDialog(null, "Submit Sucessfully");
                reset();
                this.getDate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        showTable1(currentDate);

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void r_PermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_PermissionActionPerformed
        // TODO add your handling code here:
        absen = "Izin";
        r_Permission.setSelected(true);
        r_Attendance.setSelected(false);
        r_Sick.setSelected(false);
        r_Paidleave.setSelected(false);
    }//GEN-LAST:event_r_PermissionActionPerformed

    private void r_AttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_AttendanceActionPerformed
        // TODO add your handling code here:
        absen = "Hadir";
        r_Permission.setSelected(false);
        r_Attendance.setSelected(true);
        r_Sick.setSelected(false);
        r_Paidleave.setSelected(false);
    }//GEN-LAST:event_r_AttendanceActionPerformed

    private void r_SickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_SickActionPerformed
        // TODO add your handling code here:
        absen = "Sakit";
        r_Permission.setSelected(false);
        r_Attendance.setSelected(false);
        r_Sick.setSelected(true);
        r_Paidleave.setSelected(false);
    }//GEN-LAST:event_r_SickActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
        
        String selected = (String) txtDate.getSelectedItem();

        if (selected != null && selected.equals("Hari ini")) {
            showTable1(currentDate);
        } else {
            showTable1(selected);
        }
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtDateItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDateItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_Attendance;
    private javax.swing.JRadioButton r_Paidleave;
    private javax.swing.JRadioButton r_Permission;
    private javax.swing.JRadioButton r_Sick;
    private static javax.swing.JTable tblEmp1;
    private javax.swing.JComboBox<String> txtDate;
    private javax.swing.JTextField txtFname3;
    private javax.swing.JTextField txtSearch3;
    // End of variables declaration//GEN-END:variables
}
