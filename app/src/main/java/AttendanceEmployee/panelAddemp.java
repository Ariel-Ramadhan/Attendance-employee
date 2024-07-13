/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AttendanceEmployee;

import static AttendanceEmployee.panelEmp.showTable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author ariel
 */
public class panelAddemp extends javax.swing.JPanel {

    /**
     * Creates new form panelAddemp
     */
    Connection conn = null;
    ResultSet st = null;
    PreparedStatement ps = null;
    String status;
    
    public panelAddemp() {
        initComponents();
        conn = MyConnection.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    void reset(){
        txtFname.setText("");
        txtLname.setText("");
        txtDepartment.setSelectedIndex(0);
        txtDesignation.setSelectedIndex(0);
        txtNumber.setText("");
        r_Active.setSelected(false);
        r_Inactive.setSelected(false);
        txtAddress.setText("");
        txtSalary.setText("");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JComboBox<>();
        txtDesignation = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        r_Active = new javax.swing.JRadioButton();
        r_Inactive = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(1200, 730));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Add Employe");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel2.setText("Department :");

        txtFname.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });

        txtLname.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel3.setText("Last name :");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel4.setText("First name :");

        txtDepartment.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Accounts", "Manufacturing", "Packing", "Sales" }));
        txtDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtDepartmentItemStateChanged(evt);
            }
        });
        txtDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentActionPerformed(evt);
            }
        });

        txtDesignation.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtDesignation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Designation" }));
        txtDesignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesignationActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel5.setText(" Designation :");

        txtNumber.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel6.setText("Status :");

        txtAddress.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel7.setText("Address  :");

        txtSalary.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel8.setText(" Salary :");

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel9.setText("Contact No  :");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Employe");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        r_Active.setBackground(new java.awt.Color(153, 153, 153));
        r_Active.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Active.setText("Active");
        r_Active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_ActiveActionPerformed(evt);
            }
        });

        r_Inactive.setBackground(new java.awt.Color(153, 153, 153));
        r_Inactive.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        r_Inactive.setText("In - Active");
        r_Inactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_InactiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDepartment, 0, 263, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(txtFname)
                                .addComponent(jLabel4))
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDesignation, 0, 263, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(r_Active)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(r_Inactive))))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtAddress)
                    .addComponent(txtSalary))
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(443, 443, 443))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_Active)
                            .addComponent(r_Inactive))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void txtDesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesignationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesignationActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "Are you sure?", "Add Record", JOptionPane.YES_NO_OPTION);
        if (p==0){
            String sql = "INSERT INTO `emp_list`(`fname`,`lname`,`department`,`designation`,`number`,`status`,`address`,`salary`) VALUES (?,?,?,?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                
                ps.setString(1, txtFname.getText());
                ps.setString(2, txtLname.getText());
                ps.setString(3, txtDepartment.getSelectedItem().toString());
                ps.setString(4, txtDesignation.getSelectedItem().toString());
                ps.setString(5, txtNumber.getText());
                ps.setString(6, status);
                ps.setString(7, txtAddress.getText());
                ps.setString(8, txtSalary.getText());
                
                ps.execute();
                JOptionPane.showMessageDialog(null, "Data Stored");
                reset();
                showTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void r_ActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_ActiveActionPerformed
        // TODO add your handling code here:
        status = "Active";
        r_Active.setSelected(true);
        r_Inactive.setSelected(false);
    }//GEN-LAST:event_r_ActiveActionPerformed

    private void r_InactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_InactiveActionPerformed
        // TODO add your handling code here:
        status = "In - Active";
        r_Active.setSelected(false);
        r_Inactive.setSelected(true);
    }//GEN-LAST:event_r_InactiveActionPerformed

    private void txtDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtDepartmentItemStateChanged
        // TODO add your handling code here:
        ArrayList<String> array  = new ArrayList<>();
        Iterator<String> iterator = null;
        if (txtDepartment.getSelectedItem().equals("Accounts")){
            array.add("Charted Accountant");
            array.add("Head Accountant");
            array.add("Senior Accountant");
            array.add("Junior Accountant");
            iterator = array.iterator();
            while (iterator.hasNext()){
                txtDesignation.addItem(iterator.next());
            } 
        } else if (txtDepartment.getSelectedItem().equals("Manufacturing")){
            array.add("Head Officer");
            array.add("Checker");
            array.add("Superviser");
            array.add("Helper");
            iterator = array.iterator();
            while (iterator.hasNext()){
                txtDesignation.addItem(iterator.next());
            } 
        } else if (txtDepartment.getSelectedItem().equals("Packing")){
            array.add("Head Packing Officer");
            array.add("Assembler");
            array.add("Superviser");
            array.add("Helper");
            iterator = array.iterator();
            while (iterator.hasNext()){
                txtDesignation.addItem(iterator.next());
            }
        } else if (txtDepartment.getSelectedItem().equals("Sales")){
            array.add("Head Sales Officer");
            array.add("Quality Man");
            array.add("Dispatcher");
            array.add("Helper");
            iterator = array.iterator();
            while (iterator.hasNext()){
                txtDesignation.addItem(iterator.next());
            }
        }
        
    }//GEN-LAST:event_txtDepartmentItemStateChanged

    private void txtDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton r_Active;
    private javax.swing.JRadioButton r_Inactive;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JComboBox<String> txtDepartment;
    private javax.swing.JComboBox<String> txtDesignation;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
